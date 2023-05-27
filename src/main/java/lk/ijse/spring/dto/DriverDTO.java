package lk.ijse.spring.dto;

import lk.ijse.spring.embeded.Name;
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
    private Name driverName;;
    private String driverContactNum;
    private String driverEmail;
    private String driverAddress;
    private String driverLicense;
    private String driverNic;
    private String driverPassword;
}
