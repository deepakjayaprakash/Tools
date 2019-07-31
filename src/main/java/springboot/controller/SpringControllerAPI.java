package springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springboot.dto.ResponseDTO;

import java.util.HashMap;

/**
 * @author deepak.jayaprakash
 */
@Controller
@RestController
@RequestMapping("/springapis")
@Slf4j
public class SpringControllerAPI {
    @GetMapping(value = "/getFirst")
    public ResponseDTO getFirst() {
        log.info("getFirst api hit");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(new HashMap<>().put("key", "value"));
        return responseDTO;
    }
}
