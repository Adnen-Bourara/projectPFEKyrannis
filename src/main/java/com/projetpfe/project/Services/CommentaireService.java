package com.projetpfe.project.Services;

import com.projetpfe.project.Entities.Commentaire;

import java.util.List;

public interface CommentaireService {

    Commentaire ajoutComment(Commentaire commentaire);
    Commentaire getById(Long id);
    Commentaire editComment(Commentaire commentaire);
    void deleteById(Long id);
    List<Commentaire> getCommentsByFichierId(Long id);

}
