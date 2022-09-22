package com.vetclinic.vetClinicCrm.serviceImp;

import com.vetclinic.vetClinicCrm.common.ResourceNotfoundException;
import com.vetclinic.vetClinicCrm.model.dto.IPetInformationDto;
import com.vetclinic.vetClinicCrm.model.dto.PetDto;
import com.vetclinic.vetClinicCrm.model.dto.PetOwnerInformationDto;
import com.vetclinic.vetClinicCrm.model.entity.Pet;
import com.vetclinic.vetClinicCrm.model.entity.PetOwner;
import com.vetclinic.vetClinicCrm.repostory.IPetOwnerRepostory;
import com.vetclinic.vetClinicCrm.repostory.IPetRepostory;
import com.vetclinic.vetClinicCrm.service.IPetService;
import com.vetclinic.vetClinicCrm.common.CustomizedMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetServiceImp implements IPetService {
    @Autowired
    private CustomizedMapper mapper;
    @Autowired
    private IPetRepostory iPetRepostory;
    @Autowired
    private IPetOwnerRepostory iPetOwnerRepostory;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(PetDto petDto) {

        Pet pet = mapper.map(petDto, Pet.class);
        PetOwner petOwner = this.iPetOwnerRepostory.findById(petDto.getPetOwnerId()).orElse(null);
        pet.setPetOwner(petOwner);
        mapper.map(iPetRepostory.save(pet), PetDto.class);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        this.iPetRepostory.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void softDelete(Long id) {

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public PetDto update(PetDto petDto) {
        Pet pet = this.iPetRepostory.findById(petDto.getId())
                .orElseThrow(() -> new ResourceNotfoundException("Pet not exist with this id")); //This line checks if id exist in database
        pet.setSpecies(petDto.getSpecies());
        pet.setBreed(petDto.getBreed());
        pet.setName(petDto.getName());
        pet.setAge(petDto.getAge());
        pet.setStatement(petDto.getStatement());
        petDto = mapper.map(iPetRepostory.save(pet), PetDto.class);
        return petDto;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PetDto> findAll() {

        return mapper.map(this.iPetRepostory.findAll(), new TypeToken<List<PetDto>>() {
        }.getType());
    }

    @Transactional(readOnly = true)
    @Override
    public List<PetDto> findAllByName(String name) {
        return mapper.map(this.iPetRepostory.findPetByName(name),new TypeToken<List<PetDto>>() {
        }.getType());

        //We converted the entity type list which returned from the repository, to the dto type list
    }


}
