public class Doctor extends Employee {
    private String CRM;

    private Doctor(DoctorBuilder doctorBuilder) {
        super(doctorBuilder);
        this.CRM = doctorBuilder.CRM;
    }

    public String getCRM() {
        return CRM;
    }

    public static class DoctorBuilder extends EmployeeBuilder{
        String CRM;

        public DoctorBuilder() {
        }

        public DoctorBuilder setCRM(String CRM) {
            this.CRM = CRM;
            return this;
        }

        @Override
        public Doctor.DoctorBuilder setSalary(int salary) {
            return (DoctorBuilder)super.setSalary(salary);
        }


        @Override
        public Doctor.DoctorBuilder setName(String name) {
            return (Doctor.DoctorBuilder)super.setName(name);
        }

        @Override
        public Doctor.DoctorBuilder setEmail(String email) {
            return (Doctor.DoctorBuilder)super.setName(email);
        }

        @Override
        public Doctor.DoctorBuilder setCpf(String cpf) {
            return (Doctor.DoctorBuilder)super.setName(cpf);
        }

        @Override
        public Doctor.DoctorBuilder setTelephone(String telephone) {
            return (Doctor.DoctorBuilder)super.setName(telephone);
        }

        public Doctor build(){
            return new Doctor(this);
        }
    }

}
