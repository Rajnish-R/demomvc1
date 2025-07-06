package com.fitnessApplication.ww.entity;

import jakarta.persistence.*;

@Entity
public class Goals {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    private int kg;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public int getKg() {
		return kg;
	}

	public void setKg(int kg) {
		this.kg = kg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}