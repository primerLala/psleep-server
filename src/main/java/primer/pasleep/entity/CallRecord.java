package primer.pasleep.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by primer on 17/10/20.
 */
@Entity
@Table(name = "t_callrecord")
public class CallRecord {
    @Id
    @Column(name = "call_record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer call_record_id;

    private Integer patient_id;
    private String patient_name;
    private Integer nurse_id;
    private String nurse_name;
    private boolean status;

    public Integer getCall_record_id() {
        return call_record_id;
    }

    public void setCall_record_id(Integer call_record_id) {
        this.call_record_id = call_record_id;
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

    public Integer getNurse_id() {
        return nurse_id;
    }

    public void setNurse_id(Integer nurse_id) {
        this.nurse_id = nurse_id;
    }

    public String getNurse_name() {
        return nurse_name;
    }

    public void setNurse_name(String nurse_name) {
        this.nurse_name = nurse_name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
