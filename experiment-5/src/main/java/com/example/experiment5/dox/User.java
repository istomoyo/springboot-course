package com.example.experiment5.dox;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.LocalDate;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public static final String User = "Uim5";
    public static final String ADMIN = "07tB";

    @Id
    @CreatedBy
    private String id;
    private String name;
    private String account;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String role;



    @ReadOnlyProperty
    private LocalDate createTime;
    @ReadOnlyProperty
    private LocalDate updateTime;

}
