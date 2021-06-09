package com.projetpfe.project.Controllers;

import com.projetpfe.project.Entities.Fichier;
import com.projetpfe.project.Entities.User;
import com.projetpfe.project.Services.FichierService;
import com.projetpfe.project.Services.ServiceImpl.FileStorageService;
import com.projetpfe.project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FichierController {

    @Autowired
    private FichierService fichierService;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
     private UserService userService;

    @PostMapping("/Fichier/create/Client/{id}")
    public Object createFichier(@RequestBody Fichier fichier,@PathVariable("id") Long id)
    {
        User client = userService.getById(id);
        fichier.setClient(client);
        fichier = fichierService.addFichier(fichier);
        return ResponseEntity.status(HttpStatus.CREATED).body(fichier);
    }

    @PutMapping("/Fichier/edit")
    public Object editFichier(@RequestBody Fichier fichier)
    {
        fichier = fichierService.editFichier(fichier);
        return ResponseEntity.status(HttpStatus.CREATED).body(fichier);
    }

    @GetMapping("/Fichier/getById/{id}")
    public Object getById(@PathVariable Long id)
    {
        Fichier fichier = fichierService.getByID(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(fichier);
    }

    @GetMapping("/Fichier/GetAll")
    public Object getAll()
    {
        List<Fichier> listFichier = fichierService.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(listFichier);
    }

    @GetMapping("/Fichier/getByClient/{id}")
    public Object getByClientId(@PathVariable Long id)
    {
        List<Fichier> listFichier = fichierService.getFichierByClientId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(listFichier);
    }

    @DeleteMapping("/Fichier/delete/{id}")
    public Object deleteFichier(@PathVariable Long id)
    { Fichier fichier = fichierService.getByID(id);
        fileStorageService.deleteFile(fichier.getNom()+'.'+fichier.getExtension());
        fichierService.deleteFichier(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
