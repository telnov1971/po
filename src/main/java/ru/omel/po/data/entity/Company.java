package ru.omel.po.data.entity;

import ru.omel.po.data.AbstractEntity;

import javax.persistence.*;

@Table(name = "COMPANY")
@Entity
public class Company extends AbstractEntity {
    private String specifications = "";
    private Double trans_power = 0.0;
    private int trans_count = 0;

    @OneToOne
    @JoinColumn(name = "demand")
    private Demand demand;

    public Company() {
    }

    public Company(String specifications, Double trans_power, int trans_count, Demand demand) {
        this.specifications = specifications;
        this.trans_power = trans_power;
        this.trans_count = trans_count;
        this.demand = demand;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String character) {
        this.specifications = character;
    }

    public Double getTrans_power() {
        return trans_power;
    }

    public void setTrans_power(Double trans_power) {
        this.trans_power = trans_power;
    }

    public int getTrans_count() {
        return trans_count;
    }

    public void setTrans_count(int trans_count) {
        this.trans_count = trans_count;
    }

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }
}