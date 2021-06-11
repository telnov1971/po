package ru.omel.po.data.entity;

import ru.omel.po.data.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "TEMPORARY")
@Entity
public class Temporary extends AbstractEntity {
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date duration;
    @NotNull
    private String contract;

    @OneToOne
    @JoinColumn(name = "demand")
    private Demand demand;

    public Temporary() {
    }

    public Temporary(Date duration, String contract, Demand demand) {
        this.duration = duration;
        this.contract = contract;
        this.demand = demand;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }
}