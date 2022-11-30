package rabbitMq;

import lombok.Data;

@Data
public class UsrDTO {
    private String email;
    private String password;

    public UsrDTO() {
    }

    public UsrDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
