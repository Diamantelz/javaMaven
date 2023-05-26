package lesson16;

import java.time.LocalDateTime;
import java.util.Objects;

public class Person {
    private String gender;
    private String name;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private LocalDateTime date;
    private int age;
    private String email;
    private String username;
    private String password;

    public Person() {
    }

    public Person(String gender, String name, String lastName, String city, String state, String country,
                  LocalDateTime date, int age, String email, String username, String password) {
        this.gender = gender;
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.date = date;
        this.age = age;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (!Objects.equals(gender, person.gender)) return false;
        if (!Objects.equals(name, person.name)) return false;
        if (!Objects.equals(lastName, person.lastName)) return false;
        if (!Objects.equals(city, person.city)) return false;
        if (!Objects.equals(state, person.state)) return false;
        if (!Objects.equals(country, person.country)) return false;
        if (!Objects.equals(date, person.date)) return false;
        if (!Objects.equals(email, person.email)) return false;
        if (!Objects.equals(username, person.username)) return false;
        return Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        int result = gender != null ? gender.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", date=" + date +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
