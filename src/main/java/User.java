import java.util.List;

public abstract class User {
    private String userId;
    private String name;
    private String contactNumber;
    private List<Address> addresses;

    public User(String userId, String name, String contactNumber, List<Address> addresses) {
        this.userId = userId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.addresses = addresses;
    }
}
