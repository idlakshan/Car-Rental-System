package lk.ijse.spring.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class ResponseUtil {
    private String code;
    private String message;
    private Object data;
}
