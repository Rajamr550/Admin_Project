package com.zensar.entity;

public class AdminEntity {
    private String name;
    private String password;
    private String email;
    private long phNumber;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public long getPhNumber() {
	return phNumber;
    }

    public void setPhNumber(long phNumber) {
	this.phNumber = phNumber;
    }
}
