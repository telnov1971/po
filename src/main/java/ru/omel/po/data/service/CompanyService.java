package ru.omel.po.data.service;

import org.springframework.stereotype.Service;
import ru.omel.po.data.entity.Company;
import ru.omel.po.data.entity.Demand;
import ru.omel.po.data.repository.CompanyRepository;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company findAllByDemand(Demand demand) {
        return companyRepository.findAllByDemand(demand);
    }

    public void save(Company company) {
        companyRepository.save(company);
    }
}
