package com.vetclinic.vetClinicCrm.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetOwnerDto extends BaseDTO{

    private String name;
    private String surname;
    private String gender;
    private Long phone;
    private String email;


}
