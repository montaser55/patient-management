package com.om.patientservice.controller;

import com.om.patientservice.dto.PatientRequestDTO;
import com.om.patientservice.dto.PatientResponseDTO;
import com.om.patientservice.dto.validators.CreatePatientValidationGroup;
import com.om.patientservice.model.Patient;
import com.om.patientservice.repository.PatientRepository;
import com.om.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping( "/patients")
@Tag(name = "Patient", description = "API for managing Patients")
public class PatientController {

    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get Patients")
    public List<PatientResponseDTO> getPatients() {
        return patientService.getPatients();
    }

    @PostMapping
    @Operation(summary = "Create a new Patient")
    public PatientResponseDTO createPatient(
            @Validated({Default.class, CreatePatientValidationGroup.class})
            @RequestBody PatientRequestDTO patientRequestDTO) {
        return patientService.createPatient(patientRequestDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Patient")
    public PatientResponseDTO updatePatient(
            @PathVariable UUID id,
            @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO) {
        return patientService.updatePatient(id, patientRequestDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Patient")
    public void deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
    }
}
