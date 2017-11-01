package primer.pasleep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primer.pasleep.entity.HeartRate;
import primer.pasleep.mapper.HeartRateMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by primer on 17/10/17.
 */
@Service
public class HeartRateService {
    @Autowired
    private HeartRateMapper heartRateMapper;

    public void save(HeartRate heartRate) {
        if (heartRate.getHeartrate_id() != null) {
            heartRateMapper.updateByPrimaryKey(heartRate);
        } else {
            heartRateMapper.insert(heartRate);
        }
    }

    public List<HeartRate> listByLastNum(Integer patientId, Integer lastNum) {
        Example example = new Example(HeartRate.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("patient_id", patientId);
        example.setOrderByClause("heartrate_id limit " + lastNum);

        return heartRateMapper.selectByExample(example);
    }

    public List<HeartRate> listByTimeSpace(Integer patientId, Integer timeSpace, Integer lastNum) throws Exception {
        Example example = new Example(HeartRate.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("patient_id", patientId);
        switch (timeSpace) {
            case 1:
                break;
            case 5:
                criteria.andCondition("minute % 5 = 0");
                break;
            case 15:
                criteria.andCondition("minute % 15 = 0");
                break;
            case 30:
                criteria.andCondition("minute % 30 = 0");
                break;
            case 60:
                criteria.andCondition("minute = 0");
                break;
            default:
                throw new Exception("time_space 只能为1，5，15，30，60");
        }
        example.setOrderByClause("heartrate_id desc limit " + lastNum);

        return heartRateMapper.selectByExample(example);
    }
}
