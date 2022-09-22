package com.vetclinic.vetClinicCrm.model.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "pet")
public class Pet extends BaseEntity {
    private String name;
    private String breed;
    @Column(name = "species")
    private String species;   //what type of pet (cat,dog,bird etc..)
    private int age;
    private String statement;  //description about pet health
    private String gender;

    // if the pet owner is deleted, the pet should also be deleted
    @ManyToOne
    @JoinColumn(updatable = false)
    private PetOwner petOwner;  //a pet must have just one owner
}
