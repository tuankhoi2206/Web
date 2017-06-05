package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "batch", catalog = "springhibernatedemodb")
public class Batch implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer batchId;
	private String batchName;

	public Batch(Integer batchId) {
		super();
		this.batchId = batchId;
	}

	public Batch() {
	}

	public Batch(Integer batchId, String batchName) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BATCH_ID", unique = true, nullable = false)
	public Integer getBatchId() {
		return this.batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	@Column(name = "BATCH_NAME", length = 20)
	public String getBatchName() {
		return this.batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

}