package ru.omel.po.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.omel.po.data.entity.Client;
import ru.omel.po.data.entity.Demand;

import java.util.List;

public interface DemandRepository extends JpaRepository<Demand, Integer> {
    List<Demand> findAllByClient(Client client);
    List<Demand> findAll();
    Demand findDemandById(Long id);
}