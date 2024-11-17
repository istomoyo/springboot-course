package com.example.experiment1.repository;


import com.example.experiment1.dox.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {





//改
    @Modifying
    @Query("""
    update user a set a.name = :name where a.id = :id
""")
    void updateUserById(String name, String id);
//查
    @Query("""
                    select * from user u where u.id = :id;
            """)
    List<User> findByUserId(String id);

}