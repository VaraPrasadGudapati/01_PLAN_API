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
public class PlanCat {
	@Id
	@GeneratedValue
	private Integer categoryId;
	private String categoryName;
	private String activeSw;
	private String createdBy;
	private String updatedBy;
	@Column(name="CreatedDate",updatable=false)
	@CreationTimestamp
	private LocalDate createdDate;
	@Column(name="UpdatedDate",insertable=false)
	@UpdateTimestamp
	private LocalDate updatedDate;

}
