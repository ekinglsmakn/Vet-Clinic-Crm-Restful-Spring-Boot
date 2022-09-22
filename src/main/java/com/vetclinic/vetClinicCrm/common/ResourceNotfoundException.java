package com.vetclinic.vetClinicCrm.common;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotfoundException extends RuntimeException{

    public ResourceNotfoundException(String message) {
        super(message);
    }
}
