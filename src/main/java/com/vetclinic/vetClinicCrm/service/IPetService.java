package com.vetclinic.vetClinicCrm.service;

import com.vetclinic.vetClinicCrm.model.dto.IPetInformationDto;
import com.vetclinic.vetClinicCrm.model.dto.PetDto;

import java.text.ParseException;
import java.util.List;

public interface IPetService {

    void save(PetDto petDto) throws ParseException;
    void delete(Long id);
    void softDelete(Long id);
    PetDto update(PetDto petDto);
    List<PetDto> findAll();
    List<PetDto> findAllByName(String name);

}
