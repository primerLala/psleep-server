package primer.pasleep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primer.pasleep.entity.Patient;
import primer.pasleep.mapper.PatientMapper;
import tk.mybatis.mapper.entity.Example;

/**
 * Created by primer on 17/10/17.
 */
@Service
public class PatientService {
    @Autowired
    private PatientMapper patientMapper;

    public Patient getById(Integer patientId) {
        return patientMapper.selectByPrimaryKey(patientId);
    }

    public void save(Patient patient) {
        if (patient.getPatient_id() != null) {
            patientMapper.updateByPrimaryKey(patient);
        } else {
            patientMapper.insert(patient);
        }
    }

    public List<Patient> listAll() {
        return patientMapper.selectAll();
    }

    public List<Patient> listByStage(Integer stage) {
        Example example = new Example(Patient.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("stage_num", stage);
        return patientMapper.selectByExample(example);
    }

    public List<Patient> listByRoom(Integer room) {
        Example example = new Example(Patient.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("room_num", room);
        return patientMapper.selectByExample(example);
    }

    public void deleteById(Integer patientId) {
        patientMapper.deleteByPrimaryKey(patientId);
    }
}
