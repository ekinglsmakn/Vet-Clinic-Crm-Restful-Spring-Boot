package com.vetclinic.vetClinicCrm.controller;

import com.vetclinic.vetClinicCrm.model.dto.IPetInformationDto;
import com.vetclinic.vetClinicCrm.model.dto.PetDto;
import com.vetclinic.vetClinicCrm.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private IPetService iPetService;

    @PostMapping
    @RequestMapping("/savePet")
    public ResponseEntity savePet(@RequestBody PetDto petDto) throws ParseException {
        this.iPetService.save(petDto);
        return new ResponseEntity("The Save Request Has Succeeded!", HttpStatus.ACCEPTED);
    }

    @PutMapping
    @RequestMapping("/updatePet")
    public ResponseEntity updatePet(@RequestBody PetDto petDto) {
        this.iPetService.update(petDto);
        return new ResponseEntity("The Update Request Has Succeeded!", HttpStatus.CREATED);
    }

    @DeleteMapping
    @RequestMapping(value = "/deletePet/{id}")
    public ResponseEntity hardDeletePet(@PathVariable Long id) {
        this.iPetService.delete(id);
        return new ResponseEntity("The Delete Request Has Succeeded!", HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    @RequestMapping(value = "/softDeletePet/{id}")
    public ResponseEntity softDeletePet(@PathVariable Long id) {
        this.iPetService.delete(id);
        return new ResponseEntity("The Delete Request Has Succeeded!", HttpStatus.ACCEPTED);
    }

    @GetMapping
    @RequestMapping("/getAllPet")
    public List<PetDto> getAllPet(){
        return this.iPetService.findAll();
    }


    @GetMapping
    @RequestMapping("/getAllByName/{name}")
    public List<PetDto> getAllByName(@PathVariable String name){
        return this.iPetService.findAllByName(name);
    }

}
