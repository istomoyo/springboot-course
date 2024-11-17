package com.example.experiment2.dto;

import com.example.experiment2.dox.Address;
import com.example.experiment2.dox.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddressDTO {
    private User user;
    private List<Address> addresses;
}
