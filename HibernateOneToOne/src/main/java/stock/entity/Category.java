package stock.entity;

// Generated Sep 6, 2016 9:21:28 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "testdb")
public class Category implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int categoryId;
	private String name;
	private String desc;

	public Category() {
	}

	public Category(int categoryId) {
		this.categoryId = categoryId;
	}

	public Category(int categoryId, String name, String desc) {
		this.categoryId = categoryId;
		this.name = name;
		this.desc = desc;
	}

	public Category(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	@Id
	@Column(name = "category_id", unique = true, nullable = false)
	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "name", length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "catedesc")
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
