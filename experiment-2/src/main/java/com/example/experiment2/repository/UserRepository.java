package com.example.experiment2.repository;


import com.example.experiment2.dox.User;
import com.example.experiment2.dto.UserAddressDTO;
import com.example.experiment2.dto.UserCountDTO;
import com.example.experiment2.mapper.UserExtractor;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {




    @Query(value = "select * from user u join address a on u.id = a.user_id where u.id = :uId ",resultSetExtractorClass = UserExtractor.class)
    UserAddressDTO findByUId(String uId);

    @Query("""
    select u.id as user_id,u.name,count(a.user_id) as count from user u left join address a on u.id = a.user_id group by u.id order by count;
""")
     List <UserCountDTO> findAllAddresses();



}