package com.projetpfe.project.Repositories;

import com.projetpfe.project.Entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {
    List<Commentaire> findByFichier_Id(Long id);
}
