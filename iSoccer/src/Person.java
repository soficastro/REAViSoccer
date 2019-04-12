public class Person {

    private String name;
    private String email;
    private String cpf;
    private String telephone;

    public Person(PersonBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.cpf = builder.cpf;
        this.telephone = builder.telephone;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Name: " + name + "; Email: " + email + "; Cpf: " + cpf + "; Telephone: " + telephone + "\n";

    }

    public static class PersonBuilder {
        private String name, email, cpf, telephone;

        public PersonBuilder(){
        }

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public PersonBuilder setCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public PersonBuilder setTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }
}
