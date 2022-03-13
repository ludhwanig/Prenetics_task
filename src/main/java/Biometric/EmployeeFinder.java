package Biometric;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EmployeeFinder {

	public JSONArray getEmployeeDetails(JSONArray employeesData, String empName) {
		JSONArray resultant = new JSONArray();
		for (int i = 0; i < employeesData.size(); i++) {
			JSONObject emp = (JSONObject) employeesData.get(i);
			String emp_name = (String) emp.get("employeName");
			if (emp_name.equalsIgnoreCase(empName)) {
				resultant.add(emp);
			}
		}
		return resultant;
	}
}
