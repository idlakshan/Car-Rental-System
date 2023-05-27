package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Driver {
    @Id
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
