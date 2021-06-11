package ru.omel.po.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.omel.po.data.entity.Demand;
import ru.omel.po.data.entity.Point;

import java.util.List;

public interface PointRepository extends JpaRepository<Point, Integer> {
    List<Point> findAllByDemand(Demand demand);
    Point findPointById(Long id);
}