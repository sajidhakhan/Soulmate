package rabbitMq;

public class UserDTO {
    private String name;
    private int age;
    private String gender;
    private String city;
    private String email;
    private String password;
    private String picture;

    public UserDTO() {
    }

    public UserDTO(String name, int age, String gender, String city, String email, String password, String picture) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.email = email;
        this.password = password;
        this.picture = picture;
    }
}
