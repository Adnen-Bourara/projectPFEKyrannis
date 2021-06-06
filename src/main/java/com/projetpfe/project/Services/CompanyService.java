package com.projetpfe.project.Services;

import com.projetpfe.project.Entities.Company;

import java.util.List;

public interface CompanyService {
    Company createCompany(Company company);
    List<Company> getAll();
    Company getById(Long id);
    void deleteCompany(Long id);
}
