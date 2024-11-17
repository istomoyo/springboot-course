package com.example.experiment2.mapper;

import com.example.experiment2.dox.Address;
import com.example.experiment2.dox.User;
import com.example.experiment2.dto.UserAddressDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserExtractor implements ResultSetExtractor<UserAddressDTO> {
    @Override
    public UserAddressDTO extractData(ResultSet rs) throws SQLException, DataAccessException {
        User u =  null;
        List<Address> addresses = new ArrayList<Address>(); ;
        while(rs.next()) {
            if(u == null) {
                u = User.builder()
                        .id(rs.getString("u.id"))
                        .name(rs.getString("name"))
                        .createTime(rs.getObject("u.create_time", LocalDateTime.class))
                        .updateTime(rs.getObject("u.update_time", LocalDateTime.class))
                        .build();
            }
            Address address = Address.builder()
                    .id(rs.getString("a.id"))
                    .detail(rs.getString("detail"))
                    .userId(rs.getString("user_id"))
                    .build();
            addresses.add(address);
        }

        return UserAddressDTO.builder()
                .user(u)
                .addresses(addresses)
                .build();
    }
}
