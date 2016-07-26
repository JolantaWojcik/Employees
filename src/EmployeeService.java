import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeService {
	/*  		
	 * 		- List<Employee> getAllFromCompany(String company, List<Employee> source)
		 * - List<Employee> getAllFromPosition(...)
		 * - Employee getEmpWithHighestSalary(...)
		 * - List<String> getAllCompanies(...)//ROZNE!
		 * - List<String> getAllPosistion(...) //ROZNE!
		 * - double averageSalary(...) //srednia pensja dla pracownikow na liscie
		 * - double averageSalaryForPosition(position, ...) //srednia pensja dla pracownikow na danym stanowisku
		 */
	
	public List<Employee> getAllFromCompany(String company, List<Employee> source){
		return source.stream().filter(c -> c.getCompany().equals(company)).collect(Collectors.toList());
	}
	
	public Employee getEmpWithHighestSalary(List<Employee> source) {
		return source.stream().collect(Collectors.maxBy((a, b) -> (int) a.getSalary()- (int) b.getSalary())).get();
	}
	
	public List<String> getAllCompanies(List<Employee> source){
		Set<String> companies = source.stream().map(p -> p.getCompany()).collect(Collectors.toSet());
		return companies.stream().collect(Collectors.toList());
		
	}
	
	//	Set<String> names = new HashSet<>(); //LinkedHashSet, TreeSet
	public List<String> getAllPosition(List<Employee> source){
		Set<String> positions = source.stream().map(p -> p.getPosition()).collect(Collectors.toSet());
		return positions.stream().collect(Collectors.toList());
	}
	
	public double avarageSalary(List<Employee> source){
		//public static <T> Collector<T,?,Optional<T>> maxBy(Comparator<? super T> comparator)
		//public static <T> Collector<T,?,Double> averagingDouble(ToDoubleFunction<? super T> mapper)
		return source.stream().collect(Collectors.averagingDouble(n->n.getSalary()));
	}
	
	public double averageSalaryForPosition(String position, List<Employee> source){
		return source.stream().filter(c -> c.getPosition().equals(position)).collect(Collectors.averagingDouble(n->n.getSalary()));
	}
}
