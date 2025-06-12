package com.example.patientServices.mapper;

import com.example.patientServices.Model.Patient;
import com.example.patientServices.dto.patientResponseDto;

public class patientMapper {

    public static patientResponseDto patientMapping(Patient patient) {
        patientResponseDto patientresponsedto = new patientResponseDto();
        patientresponsedto.setId(patient.getId().toString());
        patientresponsedto.setName(patient.getName());
        patientresponsedto.setEmail(patient.getEmail());
        patientresponsedto.setAddress(patient.getAddress());
        patientresponsedto.setDateOfBirth(patient.getDateOfBirth().toString());
        return patientresponsedto;
    }
}
