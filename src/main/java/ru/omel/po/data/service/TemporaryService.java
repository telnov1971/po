package ru.omel.po.data.service;

import org.springframework.stereotype.Service;
import ru.omel.po.data.entity.Demand;
import ru.omel.po.data.entity.Temporary;
import ru.omel.po.data.repository.TemporaryRepository;

@Service
public class TemporaryService {
    private final TemporaryRepository temporaryRepository;

    public TemporaryService(TemporaryRepository temporaryRepository) {
        this.temporaryRepository = temporaryRepository;
    }

    public Temporary findAllByDemand(Demand demand) {
        return temporaryRepository.findAllByDemand(demand);
    }

    public void save(Temporary temporary) {
        temporaryRepository.save(temporary);
    }
}
