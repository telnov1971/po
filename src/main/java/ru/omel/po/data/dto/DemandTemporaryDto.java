package ru.omel.po.data.dto;

import org.springframework.beans.factory.annotation.Autowired;
import ru.omel.po.data.entity.Client;
import ru.omel.po.data.entity.Demand;
import ru.omel.po.data.entity.Point;
import ru.omel.po.data.entity.Temporary;
import ru.omel.po.data.service.DemandService;
import ru.omel.po.data.service.PointService;
import ru.omel.po.data.service.TemporaryService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DemandTemporaryDto {
    @Autowired
    private TemporaryService temporaryService;
    @Autowired
    private DemandService demandService;
    @Autowired
    private PointService pointService;
    private Demand demand;
    private Temporary temporary;

    private String objectName;
    private String objectAdress;
    private Demand.Type type;
    private Demand.Status status;
    private Date date;
    private Client client;
    private List<Point> points = new LinkedList<>();
    private String note;
    private Date duration;
    private String contract;

    public DemandTemporaryDto() {
        this.demand = new Demand();
        this.temporary = new Temporary();
        this.date = new Date();
    }

    public DemandTemporaryDto(Long id) {
        this.demand = demandService.findDemandById(id);
        this.temporary = temporaryService.findAllByDemand(demand);
        this.objectName = demand.getObjectName();
        this.objectAdress = demand.getObjectAdress();
        this.type = demand.getType();
        this.status = demand.getStatus();
        this.date = demand.getDate();
        this.client = demand.getClient();
        this.points = demand.getPoints();
        this.note = demand.getNote();
        this.duration = temporary.getDuration();
        this.contract = temporary.getContract();
    }

    public void save(DemandTemporaryDto demandTemporaryDto){
        demand.setObjectName(demandTemporaryDto.objectName);
        demand.setObjectAdress(demandTemporaryDto.objectAdress);
        demand.setType(demandTemporaryDto.type);
        demand.setStatus(demandTemporaryDto.status);
        demand.setNote(demandTemporaryDto.note);
        temporary.setDuration(demandTemporaryDto.duration);
        temporary.setContract(demandTemporaryDto.contract);
        for(Point pointDto : demandTemporaryDto.points){
            Point point = pointService.findPointById(pointDto.getId());
            point.setPowerCurrent(pointDto.getPowerCurrent());
            point.setPowerDemand(pointDto.getPowerDemand());
            point.setSafety(pointDto.getSafety());
            point.setVoltage(pointDto.getVoltage());
            pointService.save(point);
        }
        temporaryService.save(temporary);
        demandService.save(demand);
    }
}
