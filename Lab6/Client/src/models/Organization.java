package models;

import generators.IdGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Organization implements Serializable {
    @Serial
    private static final long serialVersionUID = -2198189148456433300L;
    private int id;
    private String name;
    private Coordinates coordinates;
    private LocalDate creationDate;
    private Long annualTurnover;
    private String fullName;
    private OrganizationType type;
    private Address postalAddress;

    public Organization(){
        this.id = IdGenerator.generateID();
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDate.now();
        this.annualTurnover = null;
        this.fullName = null;
        this.type = null;
        this.postalAddress = null;
    }

    public Organization(int id){
        this.id = id;
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDate.now();
        this.annualTurnover = null;
        this.fullName = null;
        this.type = null;
        this.postalAddress = null;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ",name=" + name +
                ",coordinates=" + coordinates +
                ",creationDate=" + creationDate +
                ",annualTurnover=" + annualTurnover +
                ",fullName=" + fullName +
                ",type=" + type +
                ",postalAddress" + postalAddress +
                "}";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(Long annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }
}
