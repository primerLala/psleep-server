package primer.pasleep.entity;

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
@Table(name = "t_nurse")
public class Nurse extends BaseEntity {
    @Id
    @Column(name = "nurse_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nurse_id;

    private String nurse_name;

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

}
