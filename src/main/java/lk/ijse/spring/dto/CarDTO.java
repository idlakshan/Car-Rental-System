package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class CarDTO {

    String regId;
    String brand;
    String type;
    String passengers;
    String carPhoto;
    String transmission;
    String fuel;
    String waiver;
    String dayRate;
    String kmDay;
    String monthRate;
    String kmMonth;
}
