package com.wellness.wellness.repositories;

import com.wellness.wellness.model.Client;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    List<Client> findByNameContainsIgnoreCase(String keyword);
    List<Client> findAllBy();



    @Query(value="SELECT c FROM Client c where upper(c.name)  like %:name% or upper(c.lastName)  like %:name%")
    List<Client> findByNameContainingIgnoreCase(@Param("name")String name);

        //    @Query(value="SELECT c FROM Client c where (upper(c.name)  like %:name% or upper(c.lastName)  like %:name%) And (c.gende")
        //    List<Client> findByNameContainingIgnoreCase(@Param("name")String name);



}
