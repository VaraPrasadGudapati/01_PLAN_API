package in.prasadit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class PlanEntity {
@Id
@GeneratedValue
private Integer planId;
private String planName;
private LocalDate planStartDate;
private LocalDate planEndDate;
private String acitiveSw;
private String createdBy;
private String updatedBy;
@Column(name="CreatedDate",updatable=false)
@CreationTimestamp
private LocalDate createdDate;
@Column(name="UpdatedDate",insertable=false)
@UpdateTimestamp
private LocalDate updatedDate;

}
