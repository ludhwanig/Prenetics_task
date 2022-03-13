package BiometricTest;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Biometric.EmployeeFinder;

public class EmployeeFinderTest {

	EmployeeFinder empf = new EmployeeFinder();
	JSONArray employeesData;

	@Before
	public void setUp() throws Exception {
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(".\\Json_Files\\AttendanceRegister.json");
		Object obj = jsonparser.parse(reader);
		employeesData = (JSONArray) obj;
	}

	@Test
	public void test_getEmployeeDetails_return_EmployeeDetails() {
		String empName = "Test1";
		JSONArray ans = empf.getEmployeeDetails(employeesData, empName);
		String expected = "{\"date\":\"2022-03-01\",\"checkinTime\":\"9:00\",\"employeName\":\"Test1\",\"dept\":\"QA\",\"checkouttime\":\"10:00\"}";
		String actual = ans.get(0).toString();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_getEmployeeDetails_caseSenstive_return_EmployeeDetails() {
		String empName = "test6";
		JSONArray ans = empf.getEmployeeDetails(employeesData, empName);
		String expected = "{\"date\":\"2022-03-01\",\"checkinTime\":\"14:00\",\"employeName\":\"Test6\",\"dept\":\"Admin\",\"checkouttime\":\"15:00\"}";
		String actual = ans.get(0).toString();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_getEmployeeDetails_incorrectresult() {
		String empName = "Test1";
		JSONArray ans = empf.getEmployeeDetails(employeesData, empName);
		String expected = "{\"date\":\"2022-03-01\",\"checkinTime\":\"9:30\",\"employeName\":\"Test1\",\"dept\":\"QA\",\"checkouttime\":\"10:00\"}";
		String actual = ans.get(0).toString();
		Assert.assertNotEquals(expected, actual);
	}

	@Test
	public void test_getEmployeeDetails_incorrectEmployee() {
		String empName = "xyz";
		JSONArray ans = empf.getEmployeeDetails(employeesData, empName);
		Assert.assertTrue(ans.size() == 0);
	}

}
