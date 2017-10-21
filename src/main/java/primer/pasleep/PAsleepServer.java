package primer.pasleep;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by primer on 17/10/17.
 */
@RestController
@SpringBootApplication
@MapperScan(basePackages = "primer.pasleep.mapper")
@CrossOrigin
public class PAsleepServer {
    private static final Logger LOG = LoggerFactory.getLogger(PAsleepServer.class);

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        LOG.info("success return index");
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PAsleepServer.class, args);
    }
}
