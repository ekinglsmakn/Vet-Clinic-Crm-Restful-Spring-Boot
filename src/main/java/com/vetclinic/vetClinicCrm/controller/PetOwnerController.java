package com.vetclinic.vetClinicCrm.controller;

import com.vetclinic.vetClinicCrm.model.dto.PetOwnerDto;
import com.vetclinic.vetClinicCrm.service.IPetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petOwner")
public class PetOwnerController {
    @Autowired
    private IPetOwnerService iPetOwnerService;

    @PostMapping
    @RequestMapping("/saveOwner")
    public ResponseEntity savePetOwner(@RequestBody PetOwnerDto petOwnerDto) {
        this.iPetOwnerService.save(petOwnerDto);
        return new ResponseEntity("The Save Request Has Succeeded!", HttpStatus.CREATED);
    }

    @PutMapping
    @RequestMapping("/updateOwner")
    public ResponseEntity updatePetOwner(@RequestBody PetOwnerDto petOwnerDto){
        this.iPetOwnerService.update(petOwnerDto);
        return new ResponseEntity("The Update Request Has Succeeded!", HttpStatus.CREATED);
    }

    @DeleteMapping
    @RequestMapping("deleteOwner/{id}")
    public ResponseEntity deletePetOwner(@PathVariable Long id){
        this.iPetOwnerService.delete(id);
        return new ResponseEntity("The Delete Request Has Succeeded!", HttpStatus.ACCEPTED);
    }

    @GetMapping
    @RequestMapping("/getAllOwner")
    public List<PetOwnerDto> getAllOwner(){
        return this.iPetOwnerService.findAll();
    }


    //Access to pet owner and pet information with "pet owner name" parameter
    @GetMapping
    @RequestMapping("/getAllByName/{name}")
    public List<PetOwnerDto> getAllByName(@PathVariable String name){
        return this.iPetOwnerService.findAllByName(name);
    }
}
