package ua.lviv.iot.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "Payment")
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "amount_of_remuneration")
    private Integer amountOfRemuneration;
    @Column(name = "date_of_pay")
    private Date dateOfPay;

    @ManyToOne
    @JoinColumn(name = "worker_id", nullable = false)
    private Worker worker;

    public Payment() {
    }

    public Payment(Worker worker, Integer salary, Integer amountOfRemuneration, Date dateOfPay) {
        this.worker = worker;
        this.salary = salary;
        this.amountOfRemuneration = amountOfRemuneration;
        this.dateOfPay = dateOfPay;
    }

    public Payment(Integer id, Worker worker, Integer salary, Integer amountOfRemuneration, Date dateOfPay) {
        this.id = id;
        this.worker = worker;
        this.salary = salary;
        this.amountOfRemuneration = amountOfRemuneration;
        this.dateOfPay = dateOfPay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAmountOfRemuneration() {
        return amountOfRemuneration;
    }

    public void setAmountOfRemuneration(Integer amountOfRemuneration) {
        this.amountOfRemuneration = amountOfRemuneration;
    }

    public Date getDateOfPay() {
        return dateOfPay;
    }

    public void setDateOfPay(Date dateOfPay) {
        this.dateOfPay = dateOfPay;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", worker=" + worker +
                ", salary=" + salary +
                ", amountOfRemuneration=" + amountOfRemuneration +
                ", dateOfPay=" + dateOfPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(worker, payment.worker) && Objects.equals(salary, payment.salary) && Objects.equals(amountOfRemuneration, payment.amountOfRemuneration) && Objects.equals(dateOfPay, payment.dateOfPay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, worker, salary, amountOfRemuneration, dateOfPay);
    }
}
