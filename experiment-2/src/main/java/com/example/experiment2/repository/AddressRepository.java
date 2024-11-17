package com.example.experiment2.repository;


import com.example.experiment2.dox.Address;
import com.example.experiment2.dto.AddressUserDTO;
import com.example.experiment2.mapper.AddressRowMapper;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {


    //    @Query("""
//    select * from address where address.user_id=:userId;
//""")
    List<Address> findByUserId(String userId);

    @Query(value = "select * from address a ,user u where a.user_id = u.id and a.id=:aId", rowMapperClass = AddressRowMapper.class)
    AddressUserDTO findByAId(String aId);
}
