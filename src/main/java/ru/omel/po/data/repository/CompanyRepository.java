package ru.omel.po.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.omel.po.data.entity.Company;
import ru.omel.po.data.entity.Demand;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findAllByDemand(Demand demand);
}