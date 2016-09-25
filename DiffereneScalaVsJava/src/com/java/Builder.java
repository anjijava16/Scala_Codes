package com.java;
public class Builder {
	String name, company;
	Integer age;

	Builder(String name) {
		this.name = name;

	}

	Employee build() {
		return new Employee(name, age, company);
	}

	Builder age(Integer age) {
		this.age = age;
		return this;
	}

	Builder company(String company) {
		this.company = company;
		return this;
	}
}