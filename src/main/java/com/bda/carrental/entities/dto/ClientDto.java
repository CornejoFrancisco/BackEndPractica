package com.bda.carrental.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private long id;
    private String firstName;
    private String lastName;
    private String sex;
    private String birthDate;
    private long companyId;

}