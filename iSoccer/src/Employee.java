import java.util.ArrayList;

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
            return (Employee.EmployeeBuilder)super.setName(email);
        }

        @Override
        public Employee.EmployeeBuilder setCpf(String cpf) {
            return (Employee.EmployeeBuilder)super.setName(cpf);
        }

        @Override
        public Employee.EmployeeBuilder setTelephone(String telephone) {
            return (Employee.EmployeeBuilder)super.setName(telephone);
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
