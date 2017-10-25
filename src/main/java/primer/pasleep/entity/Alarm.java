package primer.pasleep.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by primer on 17/10/23.
 */
@Entity
@Table(name = "t_alarm")
public class Alarm {
    @Id
    @Column(name = "alarm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer alarm_id;

    private Integer patient_id;
    private Integer hour;
    private Integer minute;
    private Boolean is_shock;
    private String repeat_content;
    private Boolean is_on;

    public Integer getAlarm_id() {
        return alarm_id;
    }

    public void setAlarm_id(Integer alarm_id) {
        this.alarm_id = alarm_id;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Boolean getIs_shock() {
        return is_shock;
    }

    public void setIs_shock(Boolean is_shock) {
        this.is_shock = is_shock;
    }

    public String getRepeat_content() {
        return repeat_content;
    }

    public void setRepeat_content(String repeat_content) {
        this.repeat_content = repeat_content;
    }

    public Boolean getIs_on() {
        return is_on;
    }

    public void setIs_on(Boolean is_on) {
        this.is_on = is_on;
    }
}
