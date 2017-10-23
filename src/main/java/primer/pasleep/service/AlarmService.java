package primer.pasleep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primer.pasleep.entity.Alarm;
import primer.pasleep.mapper.AlarmMapper;
import tk.mybatis.mapper.entity.Example;

/**
 * Created by primer on 17/10/23.
 */
@Service
public class AlarmService {
    @Autowired
    private AlarmMapper alarmMapper;

    public void save(Alarm alarm) {
        if (alarm.getAlarm_id() != null) {
            alarmMapper.updateByPrimaryKey(alarm);
        } else {
            alarmMapper.insert(alarm);
        }
    }

    public List<Alarm> listByPatientId(Integer patientId) {
        Example example = new Example(Alarm.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("patient_id", patientId);
        example.setOrderByClause("hour, minute");

        return alarmMapper.selectByExample(example);
    }

    public Alarm getById(Integer alarmId) {
        return alarmMapper.selectByPrimaryKey(alarmId);
    }

    public int deleteById(Integer alarmId) {
        return alarmMapper.deleteByPrimaryKey(alarmId);
    }
}
