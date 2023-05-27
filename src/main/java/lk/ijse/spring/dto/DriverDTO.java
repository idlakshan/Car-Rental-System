package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String driverId;
    private String driverFirstName;
    private String driverLastName;
    private String driverContactNum;
    private String driverEmail;
    private String driverAddress;
    private String drivingLicense;
    private String driverNic;
    private String driverPassword;
}
