package ua.lviv.iot.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "Vaccination")
@Table(name = "vaccination")
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "date_of_vaccination")
    private Date dateOfVaccination;

    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    private Child child;

    public Vaccination() {
    }

    public Vaccination(Child child, String name, Date dateOfVaccination) {
        this.child = child;
        this.name = name;
        this.dateOfVaccination = dateOfVaccination;
    }

    public Vaccination(Integer id, Child child, String name, Date dateOfVaccination) {
        this.id = id;
        this.child = child;
        this.name = name;
        this.dateOfVaccination = dateOfVaccination;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfVaccination() {
        return dateOfVaccination;
    }

    public void setDateOfVaccination(Date dateOfVaccination) {
        this.dateOfVaccination = dateOfVaccination;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", child=" + child +
                ", name='" + name + '\'' +
                ", dateOfVaccination=" + dateOfVaccination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccination that = (Vaccination) o;
        return Objects.equals(id, that.id) && Objects.equals(child, that.child) && Objects.equals(name, that.name) && Objects.equals(dateOfVaccination, that.dateOfVaccination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, child, name, dateOfVaccination);
    }
}
