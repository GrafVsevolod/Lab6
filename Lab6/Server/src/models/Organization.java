package models;

import generators.IdGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Organization implements Comparable<Organization>, Serializable {
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
    public Organization(long id, String name, Coordinates coordinates, Integer annualTurnover, String fullName, OrganizationType type, Address postalAddress){
        this.id = (int) id;
        this.name = name;
        this.coordinates = coordinates;
        this.annualTurnover = Long.valueOf(annualTurnover);
        this.fullName = fullName;
        this.type = type;
        this.postalAddress = postalAddress;
    }
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
    public Organization(String[] data){
        this.id = 0;
        this.name = data[1];
        this.coordinates = new Coordinates(Long.parseLong(data[2]), Double.parseDouble(data[3]));
        this.creationDate = LocalDate.parse(data[4]);
        this.annualTurnover = Long.valueOf(data[5]);
        this.fullName = data[6];
        this.type = OrganizationType.valueOf(data[7]);
        this.postalAddress = new Address(data[8], data[9]);
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

    public int getAnnualTurnover() {
        return Math.toIntExact(annualTurnover);
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

    @Override
    public int compareTo(Organization o) {
        return (int) (this.name.compareTo(o.getName()));
    }
}
