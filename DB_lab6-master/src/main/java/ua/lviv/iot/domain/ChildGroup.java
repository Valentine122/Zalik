package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "ChildGroup")
@Table(name = "child_group")
public class ChildGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 200)
    private String name;
    @Column(name = "count_of_children")
    private Integer countOfChildren;

    @ManyToOne
    @JoinColumn(name = "kindergarten_id", nullable = false)
    private Kindergarten kindergarten;

    public ChildGroup() {
    }

    public ChildGroup(Kindergarten kindergarten, String name, Integer countOfChildren) {
        this.kindergarten = kindergarten;
        this.name = name;
        this.countOfChildren = countOfChildren;
    }

    public ChildGroup(Integer id, Kindergarten kindergarten, String name, Integer countOfChildren) {
        this.id = id;
        this.kindergarten = kindergarten;
        this.name = name;
        this.countOfChildren = countOfChildren;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Kindergarten getKindergarten() {
        return kindergarten;
    }

    public void setKindergarten(Kindergarten kindergarten) {
        this.kindergarten = kindergarten;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountOfChildren() {
        return countOfChildren;
    }

    public void setCountOfChildren(Integer countOfChildren) {
        this.countOfChildren = countOfChildren;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", kindergarten=" + kindergarten +
                ", name='" + name + '\'' +
                ", countOfChildren=" + countOfChildren;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildGroup that = (ChildGroup) o;
        return Objects.equals(id, that.id) && Objects.equals(kindergarten, that.kindergarten) && Objects.equals(name, that.name) && Objects.equals(countOfChildren, that.countOfChildren);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kindergarten, name, countOfChildren);
    }
}
