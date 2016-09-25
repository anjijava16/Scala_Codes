package com.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimaps;

public class MapReduce {

	public static final void main(String[] args) {
		Employee guest = new Builder("Guest").build();
		Employee anna = new Builder("Anna").build();
		Employee thomas = new Builder("Thomas").age(41).build();
		Employee luke = new Builder("Luke").company("LucasArt").build();
		Employee yoda = new Builder("Yoda").age(800).company("LucasArt").build();

		Collection<Employee> employees = new ArrayList<Employee>();
		employees.add(guest);
		employees.add(anna);
		employees.add(thomas);
		employees.add(luke);
		employees.add(yoda);

		ImmutableListMultimap<String, Employee> personsGroupByCompany = Multimaps.index(employees,new Function<Employee, String>() {

					public String apply(Employee person) {
						return person.getCompany();
					}

				});

		ImmutableSet<String> companyNamesFromMap = personsGroupByCompany.keySet();

		List<Employee> averageAgeByCompany = new ArrayList<Employee>();

		for (String company : companyNamesFromMap) {
			List<Employee> employeesForThisCompany = personsGroupByCompany.get(company);
			int sum = 0;
			for (Employee employee : employeesForThisCompany) {
				sum += employee.getAge();
			}
			averageAgeByCompany.add(new Employee("average", sum / employeesForThisCompany.size(), company));
		}
		System.out.println("Result: " + averageAgeByCompany);

	}
}