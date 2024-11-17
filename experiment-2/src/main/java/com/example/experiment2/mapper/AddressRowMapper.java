package com.example.experiment2.mapper;

import com.example.experiment2.dox.Address;
import com.example.experiment2.dox.User;
import com.example.experiment2.dto.AddressUserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AddressRowMapper implements RowMapper<AddressUserDTO> {

    @Override

    public AddressUserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = User.builder()
                .id(rs.getString("u.id"))
                .name(rs.getString("name"))
                .createTime(rs.getObject("u.create_time", LocalDateTime.class))
                .updateTime(rs.getObject("u.update_time", LocalDateTime.class))
                .build();
        Address address = Address.builder()
                .id(rs.getString("a.id"))
                .detail( rs.getString("detail"))
                .userId(rs.getString("user_id"))
                .createTime(rs.getObject("a.create_time", LocalDateTime.class))
                .build();

        return AddressUserDTO.builder()
                .user(user)
                .address(address)
                .build();

    }

}
