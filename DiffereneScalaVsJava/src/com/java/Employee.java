package com.java;
public class Employee {
	final String name;
	final Integer age;
	final String company;

	public Employee(String name, Integer age, String company) {
		this.name = name == null ? "guest" : name;
		this.age = age == null ? 30 : age;
		this.company = company == null ? "DevCode" : company;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getCompany() {
		return company;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", company=" + company + "]";
	}

}