package ru.omel.po.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.omel.po.data.entity.Demand;
import ru.omel.po.data.entity.Temporary;

public interface TemporaryRepository extends JpaRepository<Temporary, Integer> {
    Temporary findAllByDemand(Demand demand);
}