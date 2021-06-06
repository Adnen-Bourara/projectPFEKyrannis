package com.projetpfe.project.Services;

import com.projetpfe.project.Entities.Fichier;

import java.util.List;

public interface FichierService {
    Fichier addFichier(Fichier fichier);
    Fichier editFichier (Fichier fichier);
    Fichier getByID(Long id);
    List<Fichier> getAll();
    List<Fichier> getFichierByClientId(Long id);
    void deleteFichier(Long id);
}
