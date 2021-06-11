package ru.omel.po.data.dto;

import org.springframework.beans.factory.annotation.Autowired;
import ru.omel.po.data.entity.Client;
import ru.omel.po.data.entity.Company;
import ru.omel.po.data.entity.Demand;
import ru.omel.po.data.entity.Point;
import ru.omel.po.data.service.CompanyService;
import ru.omel.po.data.service.DemandService;
import ru.omel.po.data.service.PointService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DemandCompanyDto {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private DemandService demandService;
    @Autowired
    private PointService pointService;
    private Demand demand;
    private Company company;

    private String objectName;
    private String objectAdress;
    private Demand.Type type;
    private Demand.Status status;
    private Date date;
    private Client client;
    private List<Point> points = new LinkedList<>();
    private String note;
    private String character;
    private Double trans_power;
    private int trans_count;

    public DemandCompanyDto() {
        this.demand = new Demand();
        this.company = new Company();
        this.date = new Date();
    }

    public DemandCompanyDto(Long id) {
        this.demand = demandService.findDemandById(id);
        this.company = companyService.findAllByDemand(demand);
        this.objectName = demand.getObjectName();
        this.objectAdress = demand.getObjectAdress();
        this.type = demand.getType();
        this.status = demand.getStatus();
        this.date = demand.getDate();
        this.client = demand.getClient();
        this.points = demand.getPoints();
        this.note = demand.getNote();
        this.character = company.getSpecifications();
        this.trans_power = company.getTrans_power();
        this.trans_count = company.getTrans_count();
    }

    public void save(DemandCompanyDto demandCompanyDto){
        demand.setObjectName(demandCompanyDto.objectName);
        demand.setObjectAdress(demandCompanyDto.objectAdress);
        demand.setType(demandCompanyDto.type);
        demand.setStatus(demandCompanyDto.status);
        demand.setNote(demandCompanyDto.note);
        company.setSpecifications(demandCompanyDto.character);
        company.setTrans_count(demandCompanyDto.trans_count);
        company.setTrans_power(demandCompanyDto.trans_power);
        for(Point pointDto : demandCompanyDto.points){
            Point point = pointService.findPointById(pointDto.getId());
            point.setPowerCurrent(pointDto.getPowerCurrent());
            point.setPowerDemand(pointDto.getPowerDemand());
            point.setSafety(pointDto.getSafety());
            point.setVoltage(pointDto.getVoltage());
            pointService.save(point);
        }
        companyService.save(company);
        demandService.save(demand);
    }
}
