package com.vetclinic.vetClinicCrm.repostory;

import com.vetclinic.vetClinicCrm.model.entity.Pet;
import com.vetclinic.vetClinicCrm.model.entity.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPetRepostory extends JpaRepository<Pet,Long> {

    List<Pet> findPetByName(String name);

}
