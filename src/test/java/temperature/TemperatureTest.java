package temperature;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import primer.pasleep.PAsleepServer;
import primer.pasleep.entity.Temperature;
import primer.pasleep.service.TemperatureService;

/**
 * Created by primer on 17/10/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest(classes = PAsleepServer.class)
public class TemperatureTest {

    @Autowired
    private TemperatureService service;

    @Test
    public void testSave() {
        double value = 36.8;
        Temperature temperature = null;
        for (int i = 0; i < 75; i++) {
            temperature = new Temperature();
            temperature.setValue(value);
            temperature.setPatient_id(1);
            temperature.setPatient_name("aaa");
            temperature.setRecord_time(new Timestamp(System.currentTimeMillis()));
            service.save(temperature);
        }
    }
}
