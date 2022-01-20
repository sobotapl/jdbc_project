import java.io.Serializable;
import java.time.LocalDateTime;

public class Contact implements Serializable {
    private int id;
    private String name;
    private String age;
    private String city;
    private String number;
    private LocalDateTime localDate;

    public Contact(int id, String name, String age, String city, String number) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.number = number;
        localDate = Utils.dateGeneration();
    }

    public Contact(String name, String age, String city, String number) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.number = number;
        localDate = Utils.dateGeneration();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", number=" + number +
                '}';
    }
}
