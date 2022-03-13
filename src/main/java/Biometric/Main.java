package Biometric;

import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {

		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(".\\Json_Files\\AttendanceRegister.json");
		Object obj = jsonparser.parse(reader);
		JSONArray employeesData = (JSONArray) obj;
		Scanner sc = new Scanner(System.in);
		char c;
		do {
			System.out.println("Enter the Employee Name:");
			String empName = sc.next();
			EmployeeFinder empf = new EmployeeFinder();
			JSONArray empDetails = empf.getEmployeeDetails(employeesData, empName);

			if (empDetails.size() == 0) {
				System.out.println("Could not find any details for the given employee");
			}
			for (int i = 0; i < empDetails.size(); i++) {
				System.out.println(empDetails.get(i));
			}
			System.out.println("Do you wish to continue(y/n)?");
			c = sc.next().charAt(0);
		} while (c == 'y' || c == 'Y');

		sc.close();

	}

}
