package com.vetclinic.vetClinicCrm.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Role extends BaseEntity{
    private String name;

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
