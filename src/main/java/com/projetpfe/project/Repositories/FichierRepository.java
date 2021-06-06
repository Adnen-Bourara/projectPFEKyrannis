package com.projetpfe.project.Repositories;

import com.projetpfe.project.Entities.Fichier;
import com.projetpfe.project.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichierRepository extends JpaRepository<Fichier,Long> {
    List<Fichier> findByClient_Id(Long id);
}
