package com.projetofinal.ticher.repositories;

import com.projetofinal.ticher.models.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRespository extends JpaRepository<Evaluation, Long> {
}
