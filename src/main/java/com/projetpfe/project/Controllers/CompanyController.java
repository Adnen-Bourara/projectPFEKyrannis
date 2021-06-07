package com.projetpfe.project.Controllers;

import com.projetpfe.project.Entities.Company;
import com.projetpfe.project.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/Company/create")
    public Object createCompany(@RequestBody Company company)
    {
        company = companyService.createCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }

    @GetMapping("/Company/GetAll")
    public Object getAll()
    {
        List<Company> listCompanies = companyService.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(listCompanies);
    }

    @GetMapping("/Company/getById/{id}")
    public Object getById(@PathVariable Long id)
    {
       Company company = companyService.getById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }

    @DeleteMapping("/Company/delete/{id}")
    public Object delete(@PathVariable Long id)
    {
        companyService.deleteCompany(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
