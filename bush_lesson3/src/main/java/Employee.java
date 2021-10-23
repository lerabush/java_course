import javax.annotation.processing.SupportedSourceVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {

    private String givenName;
    private String surname;
    private Integer age;
    private String dept;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private Long code;
    private Role role;
    private Gender gender;

    public Gender getGender() {
        return gender;
    }

    public String getDept() {
        return dept;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Employee: " + givenName + " " + surname + ",age: "
                + age + ",gender: " + gender + ", department: " + dept + ",role: " +
                role + ", email: " + email + ", phone: "
                + phone + ", address: " + address
                + ", " + city + ", " + state + ", " + code;
    }

    /**
     * Реализовываем паттерн Builder
     */
    public static class EmployeeBuilder {

        private Employee newEmployee;

        public EmployeeBuilder() {
            newEmployee = new Employee();
        }

        public EmployeeBuilder setGivenName(String name) {
            newEmployee.givenName = name;
            return this;
        }

        public EmployeeBuilder setSurname(String surname) {
            newEmployee.surname = surname;
            return this;
        }

        public EmployeeBuilder setAddress(String address) {
            newEmployee.address = address;
            return this;
        }

        public EmployeeBuilder setAge(Integer age) {
            newEmployee.age = age;
            return this;
        }

        public EmployeeBuilder setCity(String city) {
            newEmployee.city = city;
            return this;
        }

        public EmployeeBuilder setPhone(String phone) {
            newEmployee.phone = phone;
            return this;
        }

        public EmployeeBuilder setDepartment(String department) {
            newEmployee.dept = department;
            return this;
        }

        public EmployeeBuilder setEmail(String email) {
            newEmployee.email = email;
            return this;
        }

        public EmployeeBuilder setState(String state) {
            newEmployee.state = state;
            return this;
        }

        public EmployeeBuilder setCode(Long code) {
            newEmployee.code = code;
            return this;
        }

        public EmployeeBuilder setRole(Role role) {
            newEmployee.role = role;
            return this;
        }

        public EmployeeBuilder setGender(Gender gender) {
            newEmployee.gender = gender;
            return this;
        }

        public Employee build() {
            return newEmployee;
        }
    }

    public static List<Employee> createShortList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new EmployeeBuilder()
                .setGivenName("Mark")
                .setSurname("Brown")
                .setAge(37)
                .setDepartment("Retail")
                .setRole(Role.MANAGER)
                .setAddress("BlackWhite St 45")
                .setCity("Manchester")
                .setCode(123456L)
                .setPhone("45-627-272-72")
                .setEmail("markBrown@mail.com")
                .setGender(Gender.MALE)
                .setState("Manchester")
                .build());
        employees.add(new EmployeeBuilder()
                .setGivenName("Max")
                .setSurname("Black")
                .setAge(32)
                .setDepartment("Retail")
                .setRole(Role.EXECUTIVE)
                .setAddress("White St 45")
                .setCity("New York")
                .setCode(1233656L)
                .setPhone("98-627-236-72")
                .setEmail("max@mail.com")
                .setGender(Gender.MALE)
                .setState("New York")
                .build());
        employees.add(new EmployeeBuilder()
                .setGivenName("Jinny")
                .setSurname("Brown")
                .setAge(33)
                .setDepartment("UX/UI")
                .setRole(Role.STAFF)
                .setAddress("Green St 4")
                .setCity("Manchester")
                .setCode(123456L)
                .setPhone("45-627-222-32")
                .setEmail("JinnyBrown@mail.com")
                .setGender(Gender.FEMALE)
                .setState("Manchester")
                .build());
        employees.add(new EmployeeBuilder()
                .setGivenName("Alexa")
                .setSurname("Chain")
                .setAge(25)
                .setDepartment("IT")
                .setRole(Role.STAFF)
                .setAddress("Black St 45")
                .setCity("London")
                .setCode(324992L)
                .setPhone("45-627-263-98")
                .setEmail("Alexa@mail.com")
                .setGender(Gender.FEMALE)
                .setState("London")
                .build());
        employees.add(new EmployeeBuilder()
                .setGivenName("Easy")
                .setSurname("Bork")
                .setAge(31)
                .setDepartment("IT")
                .setRole(Role.MANAGER)
                .setAddress("Avenue Green 45")
                .setCity("Fenix")
                .setCode(939956L)
                .setPhone("24-277-272-72")
                .setEmail("bork@mail.com")
                .setGender(Gender.MALE)
                .setState("Arizona")
                .build());
        employees.add(new EmployeeBuilder()
                .setGivenName("Missy")
                .setSurname("BonDon")
                .setAge(24)
                .setDepartment("UX/UI")
                .setRole(Role.EXECUTIVE)
                .setAddress("Blacken schtrasse  45")
                .setCity("Munchen")
                .setCode(3737476L)
                .setPhone("75-627-232-72")
                .setEmail("mBonDOn@mail.com")
                .setGender(Gender.FEMALE)
                .setState("Bavaria")
                .build());
        employees.add(new EmployeeBuilder()
                .setGivenName("Danny")
                .setSurname("Deniro")
                .setAge(53)
                .setDepartment("Retail")
                .setRole(Role.MANAGER)
                .setAddress("Sunny St 45")
                .setCity("San-Fransisco")
                .setCode(5362346L)
                .setPhone("95-177-272-74")
                .setEmail("DeniroDan@mail.com")
                .setGender(Gender.MALE)
                .setState("California")
                .build());
        return employees;
    }

    public static void main(String[] args) {
        Employee empMe = new Employee.EmployeeBuilder()
                .setGivenName("Valery")
                .setSurname("Bushueva").setAge(20)
                .setDepartment("IT")
                .setRole(Role.MANAGER)
                .setAddress("Sunny St 45")
                .setCity("San-Fransisco")
                .setCode(5362346L)
                .setPhone("95-177-272-74")
                .setEmail("v.bushuyeva@gmail.com")
                .setGender(Gender.FEMALE)
                .setState("Moscow").build();
        Employee empYou = new Employee.EmployeeBuilder()
                .setGivenName("Mark")
                .setSurname("Green").setAge(40)
                .setDepartment("IT")
                .setRole(Role.EXECUTIVE)
                .setAddress("Sunny St 45")
                .setCity("San-Fransisco")
                .setCode(5362346L)
                .setPhone("95-177-272-74")
                .setEmail("markamark@gmail.com")
                .setGender(Gender.MALE)
                .setState("Moscow").build();

        //Consumer
        Integer addedSum = 5000;
        ConsumerLambdaExpression increase = (emp, sum) -> emp.getRole()
                .setSalary(emp.getRole().getSalary() + sum);
        increase.increaseSalary(empMe, addedSum);
        System.out.println(empMe.getRole().getSalary());

        //Supplier
        SupplierLambdaExpression supplier = () -> {
            List<Employee> employees = createShortList();
            return employees.stream().map(Employee::toString).collect(Collectors.toList());
        };
        System.out.println(supplier.getInfoAboutWorkers());

        //BiPredicate
        BiPredicateLambdaExpression isOlder = (emp1,emp2)->emp1.getAge()>emp2.getAge();
        System.out.println(isOlder.isOlder(empMe,empYou));

        //Function

        FunctionLambdaExpression convertIntoEuro = (emp1,sum)->emp1.getRole().getSalary()/sum;
        for(Employee emp:createShortList()){
            System.out.println(convertIntoEuro.getSalaryInEuro(emp,1.16));
        }
    }

}
