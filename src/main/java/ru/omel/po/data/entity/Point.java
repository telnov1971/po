package ru.omel.po.data.entity;

import ru.omel.po.data.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "POINT")
@Entity
public class Point extends AbstractEntity {
    public enum Safety {FIRST, SECOND, THIRD}
    public enum Voltage {NULL_FOUR, TEN}
    @NotNull
    @NotEmpty
    private Double powerDemand = 0.0;
    @NotNull
    @NotEmpty
    private Double powerCurrent = 0.0;
    @NotNull
    @NotEmpty
    private Double powerMax = 0.0;

    @Enumerated(EnumType.STRING)
    private Safety safety;
    @Enumerated(EnumType.STRING)
    private Voltage voltage;

    @ManyToOne
    @JoinColumn(name = "demand")
    private Demand demand;

    public Point(Double powerDemand, Safety safety, Voltage voltage, Demand demand) {
        this.powerDemand = powerDemand;
        this.safety = safety;
        this.voltage = voltage;
        this.demand = demand;
        this.powerMax = powerDemand + powerCurrent;
    }

    public Point() {
    }

    public Double getPowerDemand() {
        return powerDemand;
    }

    public void setPowerDemand(Double powerDemand) {
        this.powerDemand = powerDemand;
        this.powerMax = powerDemand + powerCurrent;
    }

    public Double getPowerCurrent() {
        return powerCurrent;
    }

    public void setPowerCurrent(Double powerCurrent) {
        this.powerCurrent = powerCurrent;
        this.powerMax = powerDemand + powerCurrent;
    }

    public Double getPowerMax() {
        return powerMax;
    }

    public Safety getSafety() {
        return safety;
    }

    public void setSafety(Safety safety) {
        this.safety = safety;
    }

    public Voltage getVoltage() {
        return voltage;
    }

    public void setVoltage(Voltage voltage) {
        this.voltage = voltage;
    }

    public Demand getDemand() {
        return demand;
    }

}