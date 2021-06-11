package ru.omel.po.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.omel.po.data.entity.Client;
import ru.omel.po.data.entity.Demand;
import ru.omel.po.data.repository.DemandRepository;

import java.util.List;

@Service
public class DemandService {
    private final DemandRepository demandRepository;

    @Autowired
    public DemandService(DemandRepository demandRepository) {
        this.demandRepository = demandRepository;
    }

    public List<Demand> findAllByClient(Client client) {
        return demandRepository.findAllByClient(client);
    }

    public List<Demand> findAll() {
        return demandRepository.findAll();
    }

    public Demand findDemandById(Long id) {
        return demandRepository.findDemandById(id);
    }

    public void save(Demand demand) {
        demandRepository.save(demand);
    }
}
