package com.projetpfe.project.Services.ServiceImpl;

import com.projetpfe.project.Entities.Commentaire;
import com.projetpfe.project.Repositories.CommentaireRepository;
import com.projetpfe.project.Services.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Override
    public Commentaire ajoutComment(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire getById(Long id) {
        return commentaireRepository.findById(id).get();
    }

    @Override
    public Commentaire editComment(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public void deleteById(Long id) {
        try {
            commentaireRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e)
        {
            System.out.println("doesn't exist");
        }
    }

    @Override
    public List<Commentaire> getCommentsByFichierId(Long id) {
        return commentaireRepository.findByFichier_Id(id);
    }
}
