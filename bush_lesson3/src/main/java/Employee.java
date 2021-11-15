import javax.annotation.processing.SupportedSourceVersion;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
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


    private Employee() {

    }

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
    public String getShortInfo(){
       return getGivenName() + " " + getSurname() + " " + getAge();
    }

    public static void firstExample(List<Employee> list) {
        //получим средний возраст женщин сотрудников, при этом печатаем их
        System.out.println("\n Women");
        Double averageAge = list.stream().filter(x -> x.getGender() == Gender.FEMALE)
                .peek(e -> System.out.println(e.getShortInfo()))
                .mapToInt(Employee::getAge).average().getAsDouble();
        System.out.println(averageAge);
        //Находим самого старшего сотрудника IT
        System.out.println("\n The oldest in IT");
        Employee oldestInIT = list.stream().filter(x -> x.getDept().equals("IT"))
                .max(Comparator.comparing(Employee::getAge)).get();
        System.out.println(oldestInIT.getShortInfo());

        //Находим самого младшего сотрудника IT
        System.out.println("\n The youngest in IT");
        Employee youngestInIT = list.stream().filter(x -> x.getDept()
                .equals("IT")).min(Comparator.comparing(Employee::getAge)).get();
        System.out.println(youngestInIT.getShortInfo());

        //Находим первого менеджера
        System.out.println("\n First manager");
        Employee emp = list.stream().filter(x -> x.getRole() == Role.MANAGER).findFirst().get();
        System.out.println(emp.getShortInfo());

        //Считаем количество сотрудников, которым не больше 30 и выводим их
        System.out.println("\nUnder 30");
        System.out.println(list.stream().filter(x -> x.getAge() < 30)
                .peek(e -> System.out.println(e.getGivenName() + " " + e.getSurname())).count());

        //Cчитаем сумму их зарплат
        System.out.println("\n SUM");
        System.out.println(list.stream().filter(x -> x.getAge() < 30).map(Employee::getRole).mapToInt(Role::getSalary).sum());
    }

    public static void secondExample(List<Employee> list) {
        //повышаем всем зарплату на 10%, выводим
        System.out.println("\nIncrease salary 10%!!!");
        System.out.println(list.stream().peek(e->e.increaseSalary(0.1))
                .map(Employee::getRole).mapToInt(Role::getSalary));
        //Находим первого сотрудника из Нью-Йорка
        System.out.println("\nFirst employee from New York ");
        System.out.println(list.stream().filter(x->x.city.equals("New York")).findFirst().get().getShortInfo());
        //Находим средний возраст мужчин-сотрудников, но через sum/count
        System.out.println("\nAverage age (men) ");
        Long numOfMen = list.stream().filter(x->x.getGender()==Gender.MALE).count();
        Integer sumOfAgesMen = list.stream().filter(x->x.getGender()==Gender.MALE).mapToInt(Employee::getAge).sum();
        Integer averageAge = Math.toIntExact(sumOfAgesMen / numOfMen);
        System.out.println(averageAge);
        //Приветсвие!
        System.out.println("\nSay Hello!");
        list.stream().forEach(e->System.out.println("Hello, "+e.getGivenName()+"!"));
        //Сортируем по возрасту сотрудников Retail
        System.out.println("\nSorting by age");
        list.stream().filter(x->x.getDept().equals("Retail"))
                .sorted(Comparator.comparing(Employee::getAge)).forEach(x->System.out.println(x.getShortInfo()));
        //Находим минимальную зарплату в IT отделе (потому что мы можем изменить реализацию,
        // где не будет фиксированной зарплаты у ролей)
        System.out.println("Min salary in IT");
        System.out.println(list.stream().filter(x->x.getDept().equals("IT")).map(x->x.getRole().getSalary()).min(Integer::compareTo).get().intValue());

    }
    void increaseSalary(Double procent){
        this.getRole().setSalary((int) (this.getRole().getSalary()*(1+procent)/100));
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
        ConsumerLambdaExpression<Employee> printInfoEmployee = e -> System.out.println("\nName: " +
                e.getGivenName() + "\nSurname: " + e.getSurname() + "\n Age: " + e.getAge() +
                "\n Role: " + e.getRole() + "\n Salary: " + e.getRole().getSalary());
        printInfoEmployee.accept(empMe);

        Predicate<Employee> employeePredicate = (emp) -> emp.getRole().equals(Role.STAFF);

        //Supplier
        SupplierLambdaExpression<Employee> supplier = () -> {
            System.out.println("Creating new employee");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Name: ");
            String name = scanner.next();
            System.out.println("Surname: ");
            String surname = scanner.next();
            System.out.println("Age: ");
            Integer age = scanner.nextInt();
            System.out.println("Gender: ");
            Gender gender = null;
            if (scanner.next().equals("Female")) {
                gender = Gender.FEMALE;
            } else gender = Gender.MALE;
            System.out.println("Role (Executive, Manager, Stuff): ");
            Role role = null;
            String roleStr = scanner.next().trim();
            if (roleStr.equals("Executive")) {
                role = Role.EXECUTIVE;
            } else if (roleStr.equals("Staff")) {
                role = Role.STAFF;
            } else {
                role = Role.MANAGER;
            }
            System.out.println("Department: ");
            String dept = scanner.next();
            System.out.println("State: ");
            String state = scanner.next();
            System.out.println("City: ");
            String city = scanner.next();
            System.out.println("Code: ");
            Long code = scanner.nextLong();
            System.out.println("Address: ");
            String address = scanner.next();
            System.out.println("Email: ");
            String email = scanner.next();
            System.out.println("Phone: ");
            String phone = scanner.next();
            return new Employee.EmployeeBuilder()
                    .setGivenName(name)
                    .setSurname(surname)
                    .setAge(age)
                    .setRole(role)
                    .setDepartment(dept)
                    .setGender(gender)
                    .setPhone(phone)
                    .setEmail(email)
                    .setCode(code)
                    .setCity(city)
                    .setState(state)
                    .setAddress(address).build();

        };
        printInfoEmployee.accept(supplier.get());
        //BiPredicate
        BiPredicateLambdaExpression<Employee, Employee> isOlder = (emp1, emp2) -> emp1.getAge() > emp2.getAge();
        System.out.println(isOlder.test(empMe, empYou));

        //Function

        FunctionLambdaExpression<Employee, Double> convertIntoEuro = (emp1) -> emp1.getRole().getSalary() / 1.16;
        for (Employee emp : createShortList()) {
            System.out.println(convertIntoEuro.apply(emp));
        }
    }

}
