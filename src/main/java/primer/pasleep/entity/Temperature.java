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
@Table(name = "t_temperature")
public class Temperature extends BaseEntity{
    @Id
    @Column(name = "temperature_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer temperature_id;

    private Double value;
    private Integer patient_id;
    private String patient_name;
    private Timestamp record_time;

    public Integer getTemperature_id() {
        return temperature_id;
    }

    public void setTemperature_id(Integer temperature_id) {
        this.temperature_id = temperature_id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
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
