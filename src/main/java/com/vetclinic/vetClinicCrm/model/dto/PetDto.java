package com.vetclinic.vetClinicCrm.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDto extends BaseDTO {

    private String name;
    private String breed;
    private String species;
    private int age;
    private String statement;
    private String gender;
    private Long petOwnerId;


}
