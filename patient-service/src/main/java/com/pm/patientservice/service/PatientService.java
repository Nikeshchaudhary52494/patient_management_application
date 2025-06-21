package com.pm.patientservice.service;

import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.rapository.PatientRepository;
import com.pm.patientservice.dto.PatientResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        System.out.println(patients);

        return patients.stream().map(PatientMapper::toDTO).toList();
    }

}
