package com.example.patientServices.controller;

import com.example.patientServices.Service.patientService;
import com.example.patientServices.dto.patientRequestDto;
import com.example.patientServices.dto.patientResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/patients")
@RestController
public class patientController {

    @Autowired
    private patientService patientservice;

    @GetMapping
    public ResponseEntity<List<patientResponseDto>> getAllpatients() {
        List<patientResponseDto> patients = patientservice.getAllpatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    public ResponseEntity<patientResponseDto> createPatient(@Valid @RequestBody patientRequestDto patientrequestdto) {
        patientResponseDto patientresponsedto = patientservice.createPatient(patientrequestdto);
        return ResponseEntity.ok().body(patientresponsedto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<patientResponseDto> updatePatient(@PathVariable UUID id, @RequestBody patientRequestDto patientrequestdto) {
        patientResponseDto patientresponsedto = patientservice.updatePatient(id,patientrequestdto);
    }


}
