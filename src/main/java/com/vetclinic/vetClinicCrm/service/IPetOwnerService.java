package com.vetclinic.vetClinicCrm.service;

import com.vetclinic.vetClinicCrm.model.dto.PetOwnerDto;
import java.util.List;

public interface IPetOwnerService {

    void save(PetOwnerDto petOwnerDto);
    void delete(Long id);
    PetOwnerDto update(PetOwnerDto petOwnerDto);
    List<PetOwnerDto> findAll();
    List<PetOwnerDto> findAllByName(String name);
}
