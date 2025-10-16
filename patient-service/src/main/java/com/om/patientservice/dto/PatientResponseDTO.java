package com.om.patientservice.dto;

public record PatientResponseDTO(
        String id,
        String name,
        String gender,
        String email,
        String address,
        String dateOfBirth
) {
}
