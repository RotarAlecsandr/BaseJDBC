package model;

public class AddressUser {
    private int id;
    private String city;
    private String street;
    private int house;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public AddressUser(int id, String city, String street, int house) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @Override
    public String toString() {
        return "AddressUser{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                '}';
    }
}
