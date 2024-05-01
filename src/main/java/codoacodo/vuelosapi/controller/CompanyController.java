package codoacodo.vuelosapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codoacodo.vuelosapi.exceptions.ResourceNotFoundException;
import codoacodo.vuelosapi.models.Company;
import codoacodo.vuelosapi.services.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping("/add-company")
    public void createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
    }

    @GetMapping("/{id}")
    public Optional<Company> getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCompanyById(@PathVariable Long id) {
        try {
            companyService.deleteCompanyById(id);
            return "Compañía eliminada exitosamente";
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return "La compañía con el id seleccionado no fue encontrada";
        }
    }

    @PutMapping("/update") 
    public Optional<Company> updateCompany(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }
}
