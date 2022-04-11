public class Address {

    private String addressId;
    private String street;
    private String apt;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private Boolean isDefault;

    public Address(String addressId, String street, String apt, String city, String state, String country, String zipCode, Boolean isDefault) {
        this.addressId = addressId;
        this.street = street;
        this.apt = apt;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.isDefault = isDefault;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public String getApt() {
        return apt;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", street='" + street + '\'' +
                ", apt='" + apt + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }
}
