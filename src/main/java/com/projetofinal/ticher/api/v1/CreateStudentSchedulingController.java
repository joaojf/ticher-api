package com.projetofinal.ticher.api.v1;

import com.projetofinal.ticher.api.dto.StudentSchedulingRequest;
import com.projetofinal.ticher.api.dto.TeacherAvailabilityRequest;
import com.projetofinal.ticher.models.StudentScheduling;
import com.projetofinal.ticher.models.TeacherAvailability;
import com.projetofinal.ticher.repositories.StudentRepository;
import com.projetofinal.ticher.repositories.StudentSchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/schedules")
public class CreateStudentSchedulingController {

    private final StudentRepository studentRepository;
    private final StudentSchedulingRepository studentSchedulingRepository;

    @Autowired
    public CreateStudentSchedulingController(StudentRepository studentRepository, StudentSchedulingRepository studentSchedulingRepository) {
        this.studentRepository = studentRepository;
        this.studentSchedulingRepository = studentSchedulingRepository;
    }


    @PostMapping("/{idStudent}")
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid StudentSchedulingRequest request, @PathVariable Long idStudent){
        StudentScheduling scheduling = request.toStudentScheduling(idStudent, studentRepository);
        studentSchedulingRepository.save(scheduling);
        return ResponseEntity.ok().build();
    }

}
