package com.example.patientServices.Service;

import com.example.patientServices.Model.Patient;
import com.example.patientServices.Repository.patientRepository;
import com.example.patientServices.dto.patientRequestDto;
import com.example.patientServices.dto.patientResponseDto;
import com.example.patientServices.mapper.patientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class patientService {

    @Autowired
    private patientRepository patientrepository;

    public List<patientResponseDto> getAllpatients() {
        List<Patient> patients = patientrepository.findAll();

        return patients.stream().map(patientMapper::patientMapping).toList();

    }

    public patientResponseDto createPatient(patientRequestDto patientrequestdto) {
        if(patientrepository.existsByEmail(patientrequestdto.getEmail())) {
            throw new RuntimeException("Email id already exist : " +
                    patientrequestdto.getEmail());
        }
        Patient newPatient = patientrepository.save(patientMapper.createPatientMap(patientrequestdto));
        return patientMapper.patientMapping(newPatient);
    }
}
