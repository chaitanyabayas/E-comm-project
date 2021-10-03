package ec.com.exceptionhandling;


import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class UserErrorResponse {
    private long timestamp;

    private String message;

    private int status;
}
