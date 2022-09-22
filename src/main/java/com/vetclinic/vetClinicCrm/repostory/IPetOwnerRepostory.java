package com.vetclinic.vetClinicCrm.repostory;

import com.vetclinic.vetClinicCrm.model.entity.PetOwner;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IPetOwnerRepostory extends JpaRepository<PetOwner, Long> {


    @EntityGraph(value = "PetOwner.detail",type = EntityGraph.EntityGraphType.FETCH)
    List<PetOwner> findPetOwnerByName(String name);

}
