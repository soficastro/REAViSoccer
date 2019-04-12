public class Rider extends Employee{
    private int license;

    public Rider(RiderBuilder riderBuilder) {
        super(riderBuilder);
        this.license = license;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Driver license: " + this.license + '\n';
    }

    public static class RiderBuilder extends EmployeeBuilder {
        int license;

        public RiderBuilder setLicense(int license) {
            this.license = license;
            return this;
        }

        @Override
        public Rider.RiderBuilder setSalary(int salary) {
            return (Rider.RiderBuilder)super.setSalary(salary);
        }

        @Override
        public Rider.RiderBuilder setName(String name) {
            return (Rider.RiderBuilder)super.setName(name);
        }

        @Override
        public Rider.RiderBuilder setEmail(String email) {
            return (Rider.RiderBuilder)super.setEmail(email);
        }

        @Override
        public Rider.RiderBuilder setCpf(String cpf) {
            return (Rider.RiderBuilder)super.setCpf(cpf);
        }

        @Override
        public Rider.RiderBuilder setTelephone(String telephone) {
            return (Rider.RiderBuilder)super.setTelephone(telephone);
        }

        public Rider build(){
            return new Rider(this);
        }
    }
}
