package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class User {
    @Id
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
