package com.projetpfe.project.Services.ServiceImpl;

import com.projetpfe.project.Entities.Company;
import com.projetpfe.project.Repositories.CompanyRepository;
import com.projetpfe.project.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public void deleteCompany(Long id) {
        try {
            companyRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e)
        {
            System.out.println("doesn't exist");
        }
    }
}
