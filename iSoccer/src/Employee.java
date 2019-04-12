import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Person {
    private int salary;

    public Employee(EmployeeBuilder employeeBuilder) {
        super(employeeBuilder);
        this.salary = employeeBuilder.salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public static void employeeReport (Systema system) {
        System.out.println("Team:");
        System.out.println("Coach:");
        system.coach.toString();
        if (system.players.isEmpty()) System.out.println("Error");
        else {
            System.out.println("Team players:");
            for (Player object : system.players) {
                    System.out.println(object.toString());
                }
        }
        System.out.println("Service:");
        System.out.println("President:");
        System.out.println( system.president.toString());
        System.out.println("Doctor:");
        System.out.println( system.doctor.toString());
        if (system.lawyers.isEmpty()) System.out.println("Error");
        else {
            System.out.println("Lawyers:");
            for (Employee object : system.lawyers) {
                System.out.println(object.toString());
            }
        }
        if (system.personalTrainers.isEmpty()) System.out.println("Error");
        else {
            System.out.println("Personal Trainers:");
            for (Employee object : system.personalTrainers) {
                System.out.println(object.toString());
            }
        }
        if (system.cooks.isEmpty()) System.out.println("Error");
        else {
            System.out.println("Cooks:");
            for (Employee object : system.cooks) {
                System.out.println(object.toString());
            }
        }
        if (system.drivers.isEmpty()) System.out.println("Error");
        else {
            System.out.println("Drivers:");
            for (Rider object : system.drivers) {
                System.out.println(object.toString());
            }
        }

    }

    @Override
    public String toString() {
        return super.toString() + "Salary: $" + this.salary + "\n";
    }

    public static class EmployeeBuilder extends PersonBuilder {
        int salary;

        public EmployeeBuilder setSalary(int salary) {
           this.salary = salary;
           return this;
        }

        @Override
        public Employee.EmployeeBuilder setName(String name) {
            return (Employee.EmployeeBuilder)super.setName(name);
        }

        @Override
        public Employee.EmployeeBuilder setEmail(String email) {
            return (Employee.EmployeeBuilder)super.setEmail(email);
        }

        @Override
        public Employee.EmployeeBuilder setCpf(String cpf) {
            return (Employee.EmployeeBuilder)super.setCpf(cpf);
        }

        @Override
        public Employee.EmployeeBuilder setTelephone(String telephone) {
            return (Employee.EmployeeBuilder)super.setTelephone(telephone);
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
