import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String empId, name; int age; double salary;

    public Employee(String empId, String name, int age, double salary) {
        this.empId = empId; this.name = name; this.age = age; this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getSalary() {
        return salary;
    }
}

class EmployeeDatabase {
    private ArrayList<Employee> employees;

    public EmployeeDatabase() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}

public class assignment_lab04 {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        EmployeeDatabase dbase = new EmployeeDatabase();
        dbase.addEmployee(new Employee("161E90", "Raman", 41, 56000));
        dbase.addEmployee(new Employee("161F91", "Himadri", 38, 67500));
        dbase.addEmployee(new Employee("161F99", "Jaya", 51, 82100));
        dbase.addEmployee(new Employee("171E20", "Tejas", 30, 55000));
        dbase.addEmployee(new Employee("171G30", "Ajay", 45, 44000));
        displayMenu(dbase);
    }

    private static void displayMenu(EmployeeDatabase dbase){
        System.out.println("Choose a search option:");
        System.out.println("1. Search by Age(>, <, <=, >=): ");
        System.out.println("2. Search by Salary(>, <, <=, >=): ");
        System.out.println("3. Search by Employee ID");
        System.out.println("4. Quit Program");
        int choice = sc.nextInt();
        UserChoice(choice,dbase);
    }

    private static void UserChoice(int choice,EmployeeDatabase dbase){
        switch (choice) {
            case 1:{
                System.out.print("Enter age value: ");
                int ageValue = sc.nextInt();
                System.out.print("Enter age criteria (>, <, <=, >=): ");
                String ageOperator = sc.next();
                searchByAge(dbase, ageOperator, ageValue);
                break;
            }
            case 2:{
                System.out.print("Enter salary value: ");
                double salaryValue = sc.nextDouble();
                System.out.print("Enter salary criteria (>, <, <=, >=): ");
                String salaryOperator = sc.next();
    
                searchBySalary(dbase, salaryOperator, salaryValue);
                break;
            }
            case 3:{
                System.out.print("Enter Employee ID: ");
                String empId = sc.next();
                searchByEmployeeID(dbase, empId);
                break;
            }
            case 4:{
                System.out.println("Thank you for running this program!");
                break;
            }
            default:{
                System.out.println("Invalid choice!");
                displayMenu(dbase);
            }
                
        }
        sc.close();
    }

    private static void searchByAge(EmployeeDatabase dbase, String operator, int ageValue) {
        ArrayList<Employee> employees = dbase.getEmployees();
        System.out.println("Results for Age " + operator + " " + ageValue + ":");
        for (Employee employee : employees) {
            int age = employee.getAge();
            boolean match = false;
            switch (operator) {
                case ">":
                    match = age > ageValue;
                    break;
                case "<":
                    match = age < ageValue;
                    break;
                case ">=":
                    match = age >= ageValue;
                    break;
                case "<=":
                    match = age <= ageValue;
                    break;
            }
            if (match) {
                printEmployeeInfo(employee);
            }
        }
        System.out.println("No more records found!");
        System.out.println("Would u like to continue?(y/n)");
        char res = sc.next().charAt(0);
        if(res=='y' || res=='Y'){
            displayMenu(dbase);
        } else if(res=='n' || res=='N'){
            System.out.println("Thank you for running this program!");
        }

    }

    private static void searchBySalary(EmployeeDatabase dbase, String operator, double salaryValue) {
        ArrayList<Employee> employees = dbase.getEmployees();
        System.out.println("Results for Salary " + operator + " " + salaryValue + ":");
        for (Employee employee : employees) {
            double salary = employee.getSalary();
            boolean match = false;
            switch (operator) {
                case ">":
                    match = salary > salaryValue;
                    break;
                case "<":
                    match = salary < salaryValue;
                    break;
                case ">=":
                    match = salary >= salaryValue;
                    break;
                case "<=":
                    match = salary <= salaryValue;
                    break;
            }
            if (match) {
                printEmployeeInfo(employee);
            }
        }
        System.out.println("No more records found!");
        System.out.println("Would u like to continue?(y/n)");
        char res = sc.next().charAt(0);
        if(res=='y' || res=='Y'){
            displayMenu(dbase);
        } else if(res=='n' || res=='N'){
            System.out.println("Thank you for running this program!");
        }
    }

    private static void searchByEmployeeID(EmployeeDatabase dbase, String empId) {
        ArrayList<Employee> employees = dbase.getEmployees();
        System.out.println("Results for Employee ID " + empId + ":");
        for (Employee employee : employees) {
            if (employee.getEmpId().equals(empId)) {
                printEmployeeInfo(employee);
            }else{
                System.out.println("No matching Employee ID found.");
            }
        }
        System.out.println("Would u like to continue?(y/n)");
        char res = sc.next().charAt(0);
        if(res=='y' || res=='Y'){
            displayMenu(dbase);
        } else if(res=='n' || res=='N'){
            System.out.println("Thank you for running this program!");
        }
    }

    private static void printEmployeeInfo(Employee employee) {
        System.out.println("-------------------------");
        System.out.println("Employee ID: " + employee.getEmpId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("-------------------------");
    }
}
