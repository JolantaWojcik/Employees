import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employee = new ArrayList<>();
		employee.add(new Employee("Ala", "sales manager", 5300.33, "UBS"));
		employee.add(new Employee("Ania", "sales manager", 5100.22, "UBS"));
		employee.add(new Employee("Adam", "accountant", 3100.55, "HSBC"));
		employee.add(new Employee("Kasia", "support specialist", 4100.66, "HSBC"));
		employee.add(new Employee("Bartek", "Internal Recruiter", 2800.99, "IBM"));
		employee.forEach(System.out::println);
		
		EmployeeService es = new EmployeeService();
		
		//roboczo to wyswietlania nazwy firmy, realnie pewnie gety i sety
		String company = "HSBC";
		List <Employee> fromTheSameComapny = es.getAllFromCompany(company, employee);
		System.out.println("All employees of company " + company + " are: "+ fromTheSameComapny);
		
		Employee withBestSalary = es.getEmpWithHighestSalary(employee);
		System.out.println("Employee with best salary: " + withBestSalary);
		
		double avarageSalary = es.avarageSalary(employee);
		System.out.println("Avarage salary for all employees is: " + avarageSalary);
		
		//roboczo to wyswietlania nazwy stanowiska, realnie pewnie gety i sety
		String position = "sales manager";
		double avarageSalaryOfComapny = es.averageSalaryForPosition(position, employee);
		System.out.println("Avarage salary for position " + position +" is: "+ avarageSalaryOfComapny);
	
		List<String >companies = es.getAllCompanies(employee);
		System.out.println("Set of companies " + companies);
		
		List<String >positions = es.getAllPosition(employee);
		System.out.println("Set of positions" + positions);
	}

}
