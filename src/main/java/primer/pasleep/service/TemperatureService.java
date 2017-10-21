package primer.pasleep.service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primer.pasleep.entity.Temperature;
import primer.pasleep.mapper.TemperatureMapper;
import tk.mybatis.mapper.entity.Example;

/**
 * Created by primer on 17/10/17.
 */
@Service
public class TemperatureService {
    @Autowired
    private TemperatureMapper temperatureMapper;

    public void save(Temperature temperature) {
        if (temperature.getTemperature_id() != null) {
            temperatureMapper.updateByPrimaryKey(temperature);
        } else {
            temperatureMapper.insert(temperature);
        }
    }

    public List<Temperature> listByTime(Integer patientId, Timestamp startTime, Timestamp endTime) {
        Example example = new Example(Temperature.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("patient_id", patientId);
        criteria.andBetween("record_time", startTime, endTime);
        example.orderBy("record_time");

        return temperatureMapper.selectByExample(example);
    }

    public List<Temperature> listByLastNum(Integer patientId, Integer lastNum) {
        Example example = new Example(Temperature.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("patient_id", patientId);
        example.setOrderByClause("record_time limit " + lastNum);

        return temperatureMapper.selectByExample(example);
    }
}
