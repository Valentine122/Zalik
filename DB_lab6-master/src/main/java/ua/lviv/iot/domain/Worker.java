package ua.lviv.iot.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "Worker")
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 500)
    private String name;
    @Column(name = "surname", length = 500)
    private String surname;
    @Column(name = "date_of_employment")
    private Date dateOfEmployment;
    @Column(name = "status", length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "child_group_id", nullable = false)
    private ChildGroup childGroup;

    public Worker() {
    }

    public Worker(String name, String surname, Date dateOfEmployment, ChildGroup childGroup, String status) {
        this.name = name;
        this.surname = surname;
        this.dateOfEmployment = dateOfEmployment;
        this.childGroup = childGroup;
        this.status = status;
    }

    public Worker(Integer id, String name, String surname, Date dateOfEmployment, ChildGroup childGroup, String status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfEmployment = dateOfEmployment;
        this.childGroup = childGroup;
        this.status = status;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public ChildGroup getChildGroup() {
        return childGroup;
    }

    public void setChildGroup(ChildGroup childGroup) {
        this.childGroup = childGroup;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                ", childGroup=" + childGroup +
                ", status='" + status + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id) && Objects.equals(name, worker.name) && Objects.equals(surname, worker.surname) && Objects.equals(dateOfEmployment, worker.dateOfEmployment) && Objects.equals(childGroup, worker.childGroup) && Objects.equals(status, worker.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, dateOfEmployment, childGroup, status);
    }
}
