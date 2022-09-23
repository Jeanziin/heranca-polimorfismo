package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Employee;
import Entities.OutSourcedEmployee;

public class program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();

		for (int i = 1; i < n; i++) {
			System.out.print("Employee #" + i + " data:");

			System.out.print("Outsourced (y/n)? ");
			char ch = sc.next().charAt(0);

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Hours: ");
			Integer hours = sc.nextInt();

			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();

			if (ch == 'y') {
				System.out.print("Additional charge: ");
				Double additionalCharge = sc.nextDouble();
				Employee emp = new OutSourcedEmployee(name, hours, valuePerHour, additionalCharge);
				list.add(emp);

			} else {
				Employee emp = new Employee(name, hours, valuePerHour);
				list.add(emp);
			}
			System.out.println();
			System.out.println("PAYMENTS: ");

			for (Employee emp : list) {
				System.out.println(emp.getName() + " - $" + String.format("%.2f", emp.payment()));
			}
		}
		sc.close();
	}

}
