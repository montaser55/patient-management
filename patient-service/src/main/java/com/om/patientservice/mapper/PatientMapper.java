package com.om.patientservice.mapper;

import com.om.patientservice.dto.PatientRequestDTO;
import com.om.patientservice.dto.PatientResponseDTO;
import com.om.patientservice.model.Gender;
import com.om.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient) {
       return new PatientResponseDTO(
                patient.getId().toString(),
                patient.getName(),
                patient.getGender().toString(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDateOfBirth().toString()
        );
    }

    public static Patient toModel(PatientRequestDTO patientRequestDTO) {
        return new Patient(
                null,
                patientRequestDTO.getName(),
                Gender.valueOf(patientRequestDTO.getGender()),
                patientRequestDTO.getEmail(),
                patientRequestDTO.getAddress(),
                LocalDate.parse(patientRequestDTO.getDateOfBirth()),
                LocalDate.now()
        );
    }
}
