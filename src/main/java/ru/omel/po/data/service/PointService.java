package ru.omel.po.data.service;

import org.springframework.stereotype.Service;
import ru.omel.po.data.entity.Demand;
import ru.omel.po.data.entity.Point;
import ru.omel.po.data.repository.PointRepository;

import java.util.List;

@Service
public class PointService {
    private final PointRepository pointRepository;

    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public List<Point> findAllByDemand(Demand demand) {
        return pointRepository.findAllByDemand(demand);
    }

    public Point findPointById(Long id) {
        return pointRepository.findPointById(id);
    }

    public void save(Point point) {
        pointRepository.save(point);
    }
}
