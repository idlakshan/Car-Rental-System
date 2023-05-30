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
public class Car {
    @Id
    String regId;
    String brand;
    String carType;
    String passengers;
    String carPhoto;
    String transmission;
    String fuelType;
    String waiver;
    String dayRate;
    String kmDay;
    String monthRate;
    String kmMonth;

}
