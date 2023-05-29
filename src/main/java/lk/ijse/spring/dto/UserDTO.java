package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
    private String userId;
    private String idNo;
    private String idPath;
    private String licenseNo;
    private String licensePath;
    private String userName;
    private String contact;
    private String email;
    private String password;
}
