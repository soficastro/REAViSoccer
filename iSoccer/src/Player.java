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
        else System.out.println("They are at the medic ward at the moment");
        return apt;
    }

    public void setApt(boolean apt) {
        this.apt = apt;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Player position: " + this.position + '\n';
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
        public Player.PlayerBuilder setEmail(String email) {
            return (Player.PlayerBuilder)super.setEmail(email);
        }

        @Override
        public Player.PlayerBuilder setCpf(String cpf) {
            return (Player.PlayerBuilder)super.setCpf(cpf);
        }

        @Override
        public Player.PlayerBuilder setTelephone(String telephone) {
            return (Player.PlayerBuilder)super.setTelephone(telephone);
        }

        public Player build(){
            return new Player(this);
        }

    }
}
