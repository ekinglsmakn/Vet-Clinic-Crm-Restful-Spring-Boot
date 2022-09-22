package com.vetclinic.vetClinicCrm.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@SQLDelete(sql = "UPDATE table_product SET isActive = true WHERE id=?")
@Where(clause = "isActive=false")
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isActive = true; //used for deletion


}
