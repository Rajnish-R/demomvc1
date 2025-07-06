package demoSpringBoot_2.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Students {
	
	@Id
	@EmbeddedId
	private StudentsPk pk;
	@Column
	private String name;
	@Column
	private int age;
	
	//To retrieve the data and time for security purpose.
	@CreationTimestamp
	@Column(name="insert_time",updatable=false)
	private LocalDateTime dateTime;
	
	@UpdateTimestamp
	@Column(name="update_time",insertable=false)
	private LocalDateTime dateTime2;

	public StudentsPk getPk() {
		return pk;
	}

	public void setPk(StudentsPk pk) {
		this.pk = pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public LocalDateTime getDateTime2() {
		return dateTime2;
	}

	public void setDateTime2(LocalDateTime dateTime2) {
		this.dateTime2 = dateTime2;
	}
}
