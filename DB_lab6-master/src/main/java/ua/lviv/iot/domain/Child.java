package ua.lviv.iot.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "Child")
@Table(name = "child")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 500)
    private String name;
    @Column(name = "surname", length = 500)
    private String surname;
    @Column(name = "certificate_of_birth")
    private Integer certificateOfBirth;
    @Column(name = "date_of_entry")
    private Date dateOfEntry;
    @Column(name = "status", length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "child_group_id", nullable = false)
    private ChildGroup childGroup;

    public Child() {
    }

    public Child(String name, String surname, Integer certificateOfBirth, Date dateOfEntry, ChildGroup childGroup, String status) {
        this.name = name;
        this.surname = surname;
        this.certificateOfBirth = certificateOfBirth;
        this.dateOfEntry = dateOfEntry;
        this.childGroup = childGroup;
        this.status = status;
    }

    public Child(Integer id, String name, String surname, Integer certificateOfBirth, Date dateOfEntry, ChildGroup childGroup, String status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.certificateOfBirth = certificateOfBirth;
        this.dateOfEntry = dateOfEntry;
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

    public Integer getCertificateOfBirth() {
        return certificateOfBirth;
    }

    public void setCertificateOfBirth(Integer certificateOfBirth) {
        this.certificateOfBirth = certificateOfBirth;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
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
                ", certificateOfBirth=" + certificateOfBirth +
                ", dateOfEntry=" + dateOfEntry +
                ", childGroup=" + childGroup +
                ", status='" + status + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(id, child.id) && Objects.equals(name, child.name) && Objects.equals(surname, child.surname) && Objects.equals(certificateOfBirth, child.certificateOfBirth) && Objects.equals(dateOfEntry, child.dateOfEntry) && Objects.equals(childGroup, child.childGroup) && Objects.equals(status, child.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, certificateOfBirth, dateOfEntry, childGroup, status);
    }
}
