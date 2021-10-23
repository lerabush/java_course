import java.util.List;
import java.util.function.Predicate;

/** Пока что мы очень коварные и у всех одинаковая зарплата - 3000$
 *
 */
public class Accountant {
    public void paySalary(Employee employee){
        System.out.println("Payed "+employee.getRole().getSalary()+ "$ to employee "+employee.toString());
    }
    public void payPremium(Employee employee){
        if(employee.getRole()==Role.STAFF){
            System.out.println("Payed "+employee.getRole().getSalary()*employee.getRole().getPercent()+ "$ to employee "+employee.toString());
        }
        else if(employee.getRole()==Role.MANAGER){
            System.out.println("Payed "+employee.getRole().getSalary()*employee.getRole().getPercent()+ "$ to employee "+employee.toString());
        }
        else if(employee.getRole()==Role.EXECUTIVE){
            System.out.println("Payed "+employee.getRole().getSalary()*employee.getRole().getPercent()+ "$ to employee "+employee.toString());
        }
    }
    public static void main(String[] args){
        List<Employee> employees = Employee.createShortList();
        Accountant  accountant = new Accountant();
        //predicates
        Predicate<Employee> womenOnly = p->(p.getGender()==Gender.FEMALE);
        Predicate<Employee> staffOnly = p->(p.getRole()==Role.STAFF);
        Predicate<Employee>managersOnly = p->(p.getRole()==Role.MANAGER);
        Predicate<Employee>onlyUXUi = p->(p.getDept().equals("UX/UI"));
        Predicate<Employee>onlyRetail = p->(p.getDept().equals("Retail"));
        Predicate<Employee>onlyIT = p->(p.getDept().equals("IT"));
        Predicate<Employee>onlyOver30 = p->(p.getAge()>30);

        //women premium
        System.out.println("Women premiums");
        employees.stream()
                .filter(womenOnly)
                .forEach(accountant::payPremium);
        //salaries to UX/UI department
        System.out.println("UX/UI salaries");
        employees.stream()
                .filter(onlyIT)
                .forEach(accountant::paySalary);
        //premiums to over 30 and to Retail department
        System.out.println("Over 30 & Retail");
        employees.stream()
                .filter(onlyRetail)
                .filter(onlyOver30)
                .forEach(accountant::payPremium);
        //salaries to managers
        System.out.println("Managers salaries");
        employees.stream()
                .filter(managersOnly)
                .forEach(accountant::paySalary);
        //premiums to staff
        System.out.println("Premiums staff");
        employees.stream()
                .filter(staffOnly)
                .forEach(accountant::payPremium);
    }
}
