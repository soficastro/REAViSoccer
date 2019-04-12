public class President {

    private String name;
    private String email;
    private String cpf;
    private String telephone;
    private int salary;
    private int juniorTax;
    private int seniorTax;
    private int eliteTax;

    private static President onlyInstance;

    public static President getInstance() {

        if (onlyInstance == null) {
            onlyInstance = new President();
        }
        return onlyInstance;
    }

    public President() {
        this.juniorTax = 100;
        this.seniorTax = 100;
        this.eliteTax = 1000;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + "; Email: " + email + "; Cpf: " + cpf + "; Telephone: " + telephone + "; Salary: " + salary + "\n";

    }

    public int getJuniorTax() {
        return juniorTax;
    }

    public void setJuniorTax(int juniorTax) {
        this.juniorTax = juniorTax;
    }

    public int getSeniorTax() {
        return seniorTax;
    }

    public void setSeniorTax(int seniorTax) {
        this.seniorTax = seniorTax;
    }

    public int getEliteTax() {
        return eliteTax;
    }

    public void setEliteTax(int eliteTax) {
        this.eliteTax = eliteTax;
    }

}
