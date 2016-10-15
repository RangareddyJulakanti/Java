package com.cts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComputerCustomerSolution {

	private static int runCustomerSimulation(int numberOfComputers,
			String seqOfCustomers) {
		int customersLeftWithoutUsingComputer = 0;
		List<Character> customersUsingComputer = new ArrayList<Character>();
		
		char[] customers = seqOfCustomers.toCharArray();

		for (Character customer : customers) {
			if (customersUsingComputer.contains(customer))
				customersUsingComputer.remove(customer);
			else if (customersUsingComputer.size() < numberOfComputers)
				customersUsingComputer.add(customer);
			else
				customersLeftWithoutUsingComputer++;
		}

		return customersLeftWithoutUsingComputer / 2;
	}

	public static void main(String[] args) {
		int numberOfComputers = 3;
		String seqOfCustomers = "GACCBDDBAGEE";
		
		System.out.println("Number of customers left without using computer : "
				+ runCustomerSimulation(numberOfComputers, seqOfCustomers));
		new HashMap<>();
		
	}

}
