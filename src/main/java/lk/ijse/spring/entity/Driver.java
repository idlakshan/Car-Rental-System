package lk.ijse.spring.entity;

import lk.ijse.spring.embeded.Name;
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
    private Name driverName;
    private String driverContactNum;
    private String driverEmail;
    private String driverAddress;
    private String driverLicense;
    private String driverNic;
    private String driverPassword;
}
