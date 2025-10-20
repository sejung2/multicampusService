package com.seing.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@SequenceGenerator(
		name = "OWNER_SEQUENCE_GENERATOR", //자바에서 사용할 시퀀스제너레이터 명
		sequenceName = "OWNER_SEQUENCE" //DB에 생성해놓은 시퀀스 명
		)
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OWNER_SEQUENCE_GENERATOR")
	private Long ownerid;
	private String firstname, lastname;

	public Owner() {
	}

	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Car> cars;

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Long getOwnerid() {
		return ownerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}