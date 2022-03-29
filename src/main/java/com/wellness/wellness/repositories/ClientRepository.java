package com.wellness.wellness.repositories;

import com.wellness.wellness.model.Client;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {


    List<Client> findAllBy();


    @Query("select c from Client c where ((:keyword IS NULL or upper(c.name) like upper(concat('%',:keyword,'%'))  or upper(c.lastName) like upper(concat('%',:keyword,'%'))) AND"+
            " (:postcode is null or :postcode = c.postalcode) AND " +
            "(:gender is null or upper(c.gender) like upper(concat('%',:gender,'%'))) AND" +
            "((:agemin is null or :agemin >= c.birthday)AND :agemax is null or :agemax <= c.birthday))")
    List<Client> findByfilter(@Param("keyword") String keyword, @Param("postcode") Integer postcode, @Param("gender") String gender, @Param("agemin") LocalDate agemin, @Param("agemax") LocalDate agemax );




}
