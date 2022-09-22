package com.vetclinic.vetClinicCrm.serviceImp;

import com.vetclinic.vetClinicCrm.common.CustomizedMapper;
import com.vetclinic.vetClinicCrm.common.ResourceNotfoundException;
import com.vetclinic.vetClinicCrm.model.dto.PetDto;
import com.vetclinic.vetClinicCrm.model.dto.PetOwnerDto;
import com.vetclinic.vetClinicCrm.model.entity.PetOwner;
import com.vetclinic.vetClinicCrm.repostory.IPetOwnerRepostory;
import com.vetclinic.vetClinicCrm.repostory.IPetRepostory;
import com.vetclinic.vetClinicCrm.service.IPetOwnerService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetOwnerServiceImp implements IPetOwnerService {

    @Autowired
    private CustomizedMapper mapper;
    @Autowired
    private IPetOwnerRepostory iPetOwnerRepostory;
    @Autowired
    private IPetRepostory iPetRepostory;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(PetOwnerDto petOwnerDto) {

        PetOwner petOwner = mapper.map(petOwnerDto, PetOwner.class);
        this.iPetOwnerRepostory.save(petOwner);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        this.iPetOwnerRepostory.deleteById(id);

    }

    @Override
    public PetOwnerDto update(PetOwnerDto petOwnerDto) {
        PetOwner petOwner = this.iPetOwnerRepostory.findById(petOwnerDto.getId())
                .orElseThrow(() -> new ResourceNotfoundException("PetOwner not exist with this id"));//This line checks if id exist in database
        petOwner.setName(petOwnerDto.getName());
        petOwner.setSurname(petOwnerDto.getSurname());
        petOwner.setPhone(petOwnerDto.getPhone());
        petOwner.setGender(petOwnerDto.getGender());
        petOwner.setEmail(petOwnerDto.getEmail());
        petOwnerDto = mapper.map(iPetOwnerRepostory.save(petOwner),PetOwnerDto.class);
        return petOwnerDto;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PetOwnerDto> findAll() {

        return mapper.map(this.iPetOwnerRepostory.findAll(), new TypeToken<List<PetOwnerDto>>() {
        }.getType());
    }


    @Transactional(readOnly = true)
    @Override
    public List<PetOwnerDto> findAllByName(String name) {
        return mapper.map(this.iPetOwnerRepostory.findPetOwnerByName(name), new TypeToken<List<PetOwnerDto>>() {
        }.getType());

        ////We converted the entity type list which returned from the repository, to the dto type list
    }
}
