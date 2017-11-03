package primer.pasleep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primer.pasleep.entity.CallRecord;
import primer.pasleep.mapper.CallRecordMapper;

/**
 * Created by primer on 17/11/3.
 */
@Service
public class CallRecordService {
    @Autowired
    CallRecordMapper mapper;

    public void save(CallRecord callRecord) {
        if (callRecord.getCall_record_id() != null) {
            mapper.updateByPrimaryKey(callRecord);
        } else {
            mapper.insert(callRecord);
        }
    }

    public CallRecord getById(Integer callRecordId) {
        return mapper.selectByPrimaryKey(callRecordId);
    }
}
