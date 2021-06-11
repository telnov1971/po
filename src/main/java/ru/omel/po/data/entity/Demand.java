package ru.omel.po.data.entity;

import ru.omel.po.data.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Table(name = "DEMAND")
@Entity
public class Demand extends AbstractEntity {
    public enum Type {TO_15, TO_150, COMPANY, TEMPORARY};
    public enum Status {NEW, IN_WORK, DENIDE, COMPLETED};

    @NotBlank
    @NotNull
    @NotEmpty
    private String objectName;
    @NotBlank
    @NotNull
    @NotEmpty
    private String objectAdress;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date = new Date();

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    @OneToMany(mappedBy = "demand", fetch = FetchType.EAGER)
    private List<Point> points = new LinkedList<>();

    private String note;

    public Demand(Client client, String objectName, String objectAdress, Type type) {
        this.client = client;
        this.objectName = objectName;
        this.objectAdress = objectAdress;
        this.type = type;
    }

    public Demand() {
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectAdress() {
        return objectAdress;
    }

    public void setObjectAdress(String objectAdress) {
        this.objectAdress = objectAdress;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Client getClient() {
        return client;
    }
}