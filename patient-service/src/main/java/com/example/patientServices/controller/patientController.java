package com.example.patientServices.controller;

import com.example.patientServices.Service.patientService;
import com.example.patientServices.dto.patientResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
