package com.sapient.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "theatre")
public class Theatre {
 @Id
 @Column(name="theatre_id")
 private long id;
 @Column(name="name")
 private String name;
 @Column(name="address")
 private String address;
 @Column(name="phone")
 private long phone;
 
 @ManyToOne(fetch = FetchType.EAGER, optional = false)
 @JoinColumn(name = "city_id", nullable = false)
 private City city;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public long getPhone() {
	return phone;
}

public void setPhone(long phone) {
	this.phone = phone;
}

public City getCity() {
	return city;
}

public void setCity(City city) {
	this.city = city;
}
 
 
}
