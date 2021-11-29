package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "ParentInfo")
@Table(name = "parent_info")
public class ParentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "father_surname")
    private String fatherSurname;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "father_patronymic")
    private String fatherPatronymic;
    @Column(name = "father_phone_number", length = 20)
    private String fatherPhoneNumber;
    @Column(name = "mother_surname")
    private String motherSurname;
    @Column(name = "mother_name")
    private String motherName;
    @Column(name = "mother_patronymic")
    private String motherPatronymic;
    @Column(name = "mother_phone_number", length = 20)
    private String motherPhoneNumber;

    @OneToOne
    @JoinColumn(name = "child_id", nullable = false)
    private Child child;

    public ParentInfo() {
    }

    public ParentInfo(Child child, String fatherSurname, String fatherName, String fatherPatronymic, String fatherPhoneNumber, String motherSurname, String motherName, String motherPatronymic, String motherPhoneNumber) {
        this.child = child;
        this.fatherName = fatherName;
        this.fatherSurname = fatherSurname;
        this.fatherPatronymic = fatherPatronymic;
        this.fatherPhoneNumber = fatherPhoneNumber;
        this.motherSurname = motherSurname;
        this.motherName = motherName;
        this.motherPatronymic = motherPatronymic;
        this.motherPhoneNumber = motherPhoneNumber;
    }

    public ParentInfo(Integer id, Child child, String fatherSurname, String fatherName, String fatherPatronymic, String fatherPhoneNumber, String motherSurname, String motherName, String motherPatronymic, String motherPhoneNumber) {
        this.id = id;
        this.child = child;
        this.fatherSurname = fatherSurname;
        this.fatherName = fatherName;
        this.fatherPatronymic = fatherPatronymic;
        this.fatherPhoneNumber = fatherPhoneNumber;
        this.motherSurname = motherSurname;
        this.motherName = motherName;
        this.motherPatronymic = motherPatronymic;
        this.motherPhoneNumber = motherPhoneNumber;
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

    public String getFatherSurname() {
        return fatherSurname;
    }

    public void setFatherSurname(String fatherSurname) {
        this.fatherSurname = fatherSurname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherPatronymic() {
        return fatherPatronymic;
    }

    public void setFatherPatronymic(String fatherPatronymic) {
        this.fatherPatronymic = fatherPatronymic;
    }

    public String getFatherPhoneNumber() {
        return fatherPhoneNumber;
    }

    public void setFatherPhoneNumber(String fatherPhoneNumber) {
        this.fatherPhoneNumber = fatherPhoneNumber;
    }

    public String getMotherSurname() {
        return motherSurname;
    }

    public void setMotherSurname(String motherSurname) {
        this.motherSurname = motherSurname;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherPatronymic() {
        return motherPatronymic;
    }

    public void setMotherPatronymic(String motherPatronymic) {
        this.motherPatronymic = motherPatronymic;
    }

    public String getMotherPhoneNumber() {
        return motherPhoneNumber;
    }

    public void setMotherPhoneNumber(String motherPhoneNumber) {
        this.motherPhoneNumber = motherPhoneNumber;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                "child=" + child +
                ", fatherSurname='" + fatherSurname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", fatherPatronymic='" + fatherPatronymic + '\'' +
                ", fatherPhoneNumber='" + fatherPhoneNumber + '\'' +
                ", motherSurname='" + motherSurname + '\'' +
                ", motherName='" + motherName + '\'' +
                ", motherPatronymic='" + motherPatronymic + '\'' +
                ", motherPhoneNumber='" + motherPhoneNumber + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentInfo that = (ParentInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(fatherSurname, that.fatherSurname) && Objects.equals(fatherName, that.fatherName) && Objects.equals(fatherPatronymic, that.fatherPatronymic) && Objects.equals(fatherPhoneNumber, that.fatherPhoneNumber) && Objects.equals(motherSurname, that.motherSurname) && Objects.equals(motherName, that.motherName) && Objects.equals(motherPatronymic, that.motherPatronymic) && Objects.equals(motherPhoneNumber, that.motherPhoneNumber) && Objects.equals(child, that.child);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fatherSurname, fatherName, fatherPatronymic, fatherPhoneNumber, motherSurname, motherName, motherPatronymic, motherPhoneNumber, child);
    }
}