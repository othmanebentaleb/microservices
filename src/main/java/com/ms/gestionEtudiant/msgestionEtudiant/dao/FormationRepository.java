package com.ms.gestionEtudiant.msgestionEtudiant.dao;

import com.ms.gestionEtudiant.msgestionEtudiant.modele.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation,Long> {
}
