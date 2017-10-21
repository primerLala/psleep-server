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
@Table(name = "t_patient")
public class Patient extends BaseEntity{
    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_id;

    private String patient_name;
    private Integer room_num;
    private Integer stage_num;
    private Integer bed_num;
    private Timestamp checkin_time;

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

    public Integer getRoom_num() {
        return room_num;
    }

    public void setRoom_num(Integer room_num) {
        this.room_num = room_num;
    }

    public Integer getStage_num() {
        return stage_num;
    }

    public void setStage_num(Integer stage_num) {
        this.stage_num = stage_num;
    }

    public Integer getBed_num() {
        return bed_num;
    }

    public void setBed_num(Integer bed_num) {
        this.bed_num = bed_num;
    }

    public Timestamp getCheckin_time() {
        return checkin_time;
    }

    public void setCheckin_time(Timestamp checkin_time) {
        this.checkin_time = checkin_time;
    }
}
