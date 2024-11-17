package com.example.experiment1.repository;


import com.example.experiment1.dox.Address;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {


    @Query("""
    select * from address where address.user_id=:userId;
""")
    List<Address> findByUserId(String userId);
}
