package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import javax.persistence.*;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;


@Entity
@SequenceGenerator(name = "inventory_seq", sequenceName = "inventory_seq")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_seq")
    public long id;

    @Column(name = "dealer_id")
    public String dealerId;

    public String stock;

    // @Required
    public String year;
    //@Required
    public String make;
    public String model;
    // @Required
    public String vin;

    public String mileage;

    public String retailprice;

    public String color;

    public String transmission;

    public String options;

    public String bodytype;

    public String engine;

    public String location;

    public String vclass;

    // @Required
    public String equipment;
    // @Required
    public String downpayment;
    // @Required
    public String youpay;
    // @Required


    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", dealerId='" + dealerId + '\'' +
                ", stock='" + stock + '\'' +
                ", year='" + year + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", mileage='" + mileage + '\'' +
                ", retailprice='" + retailprice + '\'' +
                ", color='" + color + '\'' +
                ", transmission='" + transmission + '\'' +
                ", options='" + options + '\'' +
                ", bodytype='" + bodytype + '\'' +
                ", engine='" + engine + '\'' +
                ", location='" + location + '\'' +
                ", vclass='" + vclass + '\'' +
                ", equipment='" + equipment + '\'' +
                ", downpayment='" + downpayment + '\'' +
                ", youpay='" + youpay + '\'' +
                '}';
    }

    /**
     * Find a company by id.
     */

    public static List<Inventory> findAll() {
        Query query = JPA.em().createQuery("from Inventory");
        return (List<Inventory>) query.getResultList();
    }


//    /**
//     * Return a page of computer
//     *
//     * @param page Page to display
//     * @param pageSize Number of computers per page
//     * @param sortBy Computer property used for sorting
//     * @param order Sort order (either or asc or desc)
//     * @param filter Filter applied on the name column
//     */
//    public static Page page(int page, int pageSize, String sortBy, String order, String filter) {
//        if(page < 1) page = 1;
//        Long total = (Long)JPA.em()
//                .createQuery("select count(c) from Computer c where lower(c.name) like ?")
//                .setParameter(1, "%" + filter.toLowerCase() + "%")
//                .getSingleResult();
//        List<Computer> data = JPA.em()
//                .createQuery("from Computer c where lower(c.name) like ? order by c." + sortBy + " " + order)
//                .setParameter(1, "%" + filter.toLowerCase() + "%")
//                .setFirstResult((page - 1) * pageSize)
//                .setMaxResults(pageSize)
//                .getResultList();
//        return new Page(data, total, page, pageSize);
//    }
}
