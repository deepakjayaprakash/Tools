package springboot.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author deepak.jayaprakash
 */
@Data
public class ResponseDTO implements Serializable {
    private Object data;
}
