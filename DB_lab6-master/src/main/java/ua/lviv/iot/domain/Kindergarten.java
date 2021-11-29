package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Kindergarten")
@Table(name = "kindergarten")
public class Kindergarten {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "street")
    private String street;
    @Column(name = "building_number")
    private Integer buildingNumber;
    @Column(name = "count_of_group")
    private Integer countOfGroup;

    public Kindergarten() {
    }

    public Kindergarten(String name, String street, Integer buildingNumber, Integer countOfGroup) {
        this(-1, name, street, buildingNumber, countOfGroup);
    }

    public Kindergarten(Integer id, String name, String street, Integer buildingNumber, Integer countOfGroup) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.countOfGroup = countOfGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Integer getCountOfGroup() {
        return countOfGroup;
    }

    public void setCountOfGroup(Integer countOfGroup) {
        this.countOfGroup = countOfGroup;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", countOfGroup=" + countOfGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kindergarten that = (Kindergarten) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(street, that.street) && Objects.equals(buildingNumber, that.buildingNumber) && Objects.equals(countOfGroup, that.countOfGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, buildingNumber, countOfGroup);
    }
}

