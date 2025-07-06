package demoSpringBoot_2.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentsPk {

	private Integer id;
	private String email;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}