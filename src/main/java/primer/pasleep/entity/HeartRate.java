package primer.pasleep.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by primer on 17/10/17.
 */
@Entity
@Table(name = "t_heartrate")
public class HeartRate extends BaseEntity{
    @Id
    @Column(name = "heartrate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer heartrate_id;

    private Integer value;
    private Integer patient_id;
    private String patient_name;
    private Timestamp record_time;

    public Integer getHeartrate_id() {
        return heartrate_id;
    }

    public void setHeartrate_id(Integer heartrate_id) {
        this.heartrate_id = heartrate_id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public Timestamp getRecord_time() {
        return record_time;
    }

    public void setRecord_time(Timestamp record_time) {
        this.record_time = record_time;
    }
}
