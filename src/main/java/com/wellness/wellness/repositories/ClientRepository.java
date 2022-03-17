package com.wellness.wellness.repositories;

import com.wellness.wellness.model.Client;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {



    List<Client> findAllBy();

    @Query(value = "SELECT c FROM Client c where upper(c.name)  like %:name% or upper(c.lastName)  like %:name%")
    List<Client> findByNameContainingIgnoreCase(@Param("name") String name);

    @Query("SELECT c from Client c where c.postcode=:postalCode")
    List<Client> findAllByPostcodeContaining(@Param("postalCode") Integer postalCode);


    @Query("select c from Client c where (:gender is null or upper(c.gender)  like %:gender%) ")
    List<Client> findAllByGender(@Param("gender") String gender);

//    @Query("select c from Client c where (upper(c.name)  is null or upper(c.name) like %:name% or upper(c.lastName) like  %:name%) AND (:postcode is null or :postcode = c.postcode) and (:gender is null or upper (c.gender) like %:gender% )")
//    List<Client> findBy(@Param("name") String name, @Param("postcode") Integer postcode, @Param("gender") String gender);


//    @Query("SELECT c FROM Client c WHERE " +
//            "(:name IS NULL OR upper(c.name) like %:name% or upper(c.lastName) like %:name% ) AND " +
//            "(:postalCode IS NULL OR c.postcode =:postalCode) AND " +
//            "(:M IS NULL OR c.gender like%:M%) AND " +
//            "(:foodProvided IS NULL OR v.foodProvided = :foodProvided) AND " +
//            "(:indoor IS NULL OR v.indoor=:indoor) AND " +
//            "(:outdoor IS NULL OR v.outdoor=:outdoor) ")
//
//    List<Client> findByFilter(@Param("name") String name,
//                             @Param("postalCode") Integer postalCode,
//                             @Param("age") Integer age,
//                              @Param("M")Character M,
//                              @Param("F")Character F);


}
