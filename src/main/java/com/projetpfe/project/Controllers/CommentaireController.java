package com.projetpfe.project.Controllers;

import com.projetpfe.project.Entities.Commentaire;
import com.projetpfe.project.Entities.Fichier;
import com.projetpfe.project.Entities.User;
import com.projetpfe.project.Services.CommentaireService;
import com.projetpfe.project.Services.FichierService;
import com.projetpfe.project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @Autowired
    private UserService userService;

    @Autowired
    private FichierService fichierService;

    @PostMapping("/Comment/create/User/{id1}/Fichier/{id2}")
    public Object addComment(@RequestBody Commentaire commentaire, @PathVariable("id1") Long idUser,@PathVariable("id2") Long idFichier)
    {
        User u = userService.getById(idUser);
        Fichier f = fichierService.getByID(idFichier);
        commentaire.setFichier(f);
        commentaire.setCommentor(u);
        commentaire =  commentaireService.ajoutComment(commentaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentaire);

    }

    @GetMapping("/Comment/getByFichier/{id}")
    public Object getByFichier(@PathVariable Long id)
    {
        List<Commentaire> commentaireList = commentaireService.getCommentsByFichierId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentaireList);
    }

    @GetMapping("/Comment/GetById/{id}")
    public Object getById(@PathVariable Long id)
    {
       Commentaire commentaire = commentaireService.getById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentaire);
    }

    @PutMapping("/Comment/edit")
    public Object editComment(@RequestBody Commentaire commentaire)
    {
        commentaire =  commentaireService.editComment(commentaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentaire);
    }

    @DeleteMapping("/Comment/delete/{id}")
    public Object deleteComment(@PathVariable Long id)
    {
        commentaireService.deleteById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
