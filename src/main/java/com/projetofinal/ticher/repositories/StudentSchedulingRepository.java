package com.projetofinal.ticher.repositories;

import com.projetofinal.ticher.models.StudentScheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSchedulingRepository extends JpaRepository<StudentScheduling, Long> {
}
