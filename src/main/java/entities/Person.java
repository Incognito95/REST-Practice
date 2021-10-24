package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;


@Entity
@NamedQueries({
//        @NamedQuery(name = "Person.deleteAllRows", query = "DELETE from Person"),
        @NamedQuery(name = "Person.getAllRows", query = "SELECT p FROM Person p")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String city;

    public Person() {
    }

    public Person(Long id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Syncronizing with address object


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
