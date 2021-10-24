package dtomappers;

import entities.Person;

/**
 *
 * @author jobe
 */
public class PersonDTO {
    private long id;
    private String name;
    private int age;
    private String city;

    public PersonDTO(Person p) {
        this.name = p.getName();
        this.age = p.getAge();
        this.city = p.getCity();
    }

    public void setId(long id) {
        this.id = id;
    }

    public PersonDTO(long id, String name, int age) {
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
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
