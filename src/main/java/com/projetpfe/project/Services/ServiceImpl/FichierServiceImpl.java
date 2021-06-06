package com.projetpfe.project.Services.ServiceImpl;

import com.projetpfe.project.Entities.Fichier;
import com.projetpfe.project.Repositories.FichierRepository;
import com.projetpfe.project.Services.FichierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichierServiceImpl implements FichierService {

    @Autowired
    private FichierRepository fichierRepository;

    @Override
    public Fichier addFichier(Fichier fichier) {
        return fichierRepository.save(fichier);
    }

    @Override
    public Fichier editFichier(Fichier fichier) {
        return fichierRepository.save(fichier);
    }

    @Override
    public Fichier getByID(Long id) {
        return fichierRepository.findById(id).get();
    }

    @Override
    public List<Fichier> getAll() {
        return fichierRepository.findAll();
    }

    @Override
    public List<Fichier> getFichierByClientId(Long id) {
        return fichierRepository.findByClient_Id(id);
    }

    @Override
    public void deleteFichier(Long id) {
        try {
            fichierRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e)
        {
            System.out.println("doesn't exist");
        }
    }
}
