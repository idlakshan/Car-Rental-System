package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AdminDTO {
    private String adminId;
    private String adminName;
    private String adminAddress;
    private String adminEmail;
    private String adminPassword;
}
