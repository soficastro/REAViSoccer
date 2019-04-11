public class Player extends Employee {
    private String position;
    private boolean apt;

    public Player(PlayerBuilder playerBuilder) {
        super(playerBuilder);
        this.position = playerBuilder.position;
        this.apt = playerBuilder.apt;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isApt() {
        if (apt) System.out.println("They are apt to play!");
        else System.out.println("They are NOT apt to play at the moment");
        return apt;
    }

    public void setApt(boolean apt) {
        this.apt = apt;
    }


    public static class PlayerBuilder extends EmployeeBuilder {
        String position;
        boolean apt;

        public PlayerBuilder() {

        }

        public PlayerBuilder setPosition(String position) {
            this.position = position;
            return this;
        }

        public PlayerBuilder setApt(boolean apt) {
            this.apt = apt;
            return this;
        }

        @Override
        public Player.PlayerBuilder setSalary(int salary) {
            return (Player.PlayerBuilder)super.setSalary(salary);
        }

        @Override
        public Player.PlayerBuilder setName(String name) {
            return (Player.PlayerBuilder)super.setName(name);
        }

        @Override
        public Rider.RiderBuilder setEmail(String email) {
            return (Rider.RiderBuilder)super.setName(email);
        }

        @Override
        public Player.PlayerBuilder setCpf(String cpf) {
            return (Player.PlayerBuilder)super.setName(cpf);
        }

        @Override
        public Player.PlayerBuilder setTelephone(String telephone) {
            return (Player.PlayerBuilder)super.setName(telephone);
        }

        public Player build(){
            return new Player(this);
        }

    }
}
