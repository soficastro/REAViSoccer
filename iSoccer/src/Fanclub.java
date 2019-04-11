import java.util.Scanner;

public class Fanclub extends Person {
    private int tax;
    private boolean paid;
    private String address;
    private int type; //3 - junior 2 - senior 1 - elite

    public Fanclub(FanclubBuilder fanclubBuilder) {
        super(fanclubBuilder);
        this.paid = false;
        this.type = fanclubBuilder.type;
        this.address = fanclubBuilder.address;
        if (type == 3) tax = 20;
        else if (type == 2) tax = 20;
        else if (type == 1) tax = 10000;

    }

    public static void fanClubMenu(Systema system) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1 - Add fan 2 - Edit status 3 - Change commission based on membership level 4 - Pay 5 -Back");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            if (option == 1) {

                String name, email, cpf, phone, address;

                System.out.println("1 - Elite 2 - Senior 3 - Junior");
                int type = input.nextInt();

                System.out.println("Enter name");
                name = input.next();
                System.out.println("Enter email");
                email = input.next();
                System.out.println("Enter CPF");
                cpf = input.next();
                System.out.println("Enter telephone");
                phone = input.next();
                System.out.println("Enter address");
                address = input.next();

                Fanclub fan = new Fanclub.FanclubBuilder().setAddress(address).setCpf(cpf).setEmail(email).setName(name).setTelephone(phone).setType(type).build();


            } else if (option == 2) {
                if (system.fans.isEmpty()) System.out.println("Wait... There's no fan");
                else {
                    System.out.println("Enter player's email");
                    String email = input.next();
                    for (Fanclub object : system.fans) {
                        if (object.getEmail().equals(email)) {
                            System.out.println("Choose new classification 1 ELITE 2 SENIOR 3 JUNIOR");
                            object.type = input.nextInt();
                        } else System.out.println("We couldn't find them");
                    }
                }
            } else if (option == 3) {
                System.out.println("Enter player's email");
                String email = input.next();
                for (Fanclub object : system.fans) {
                    if (object.getEmail().equals(email)) {
                        System.out.println("Choose new classification 1 ELITE 2 SENIOR 3 JUNIOR");
                        object.paid = true;
                    }

                }
            } else System.out.println("We couldn't find them");
        }
    }


    public static class FanclubBuilder extends Person.PersonBuilder {

        int type;
        String address;

        public FanclubBuilder() {
        }

        public FanclubBuilder setType(int type) {
            this.type = type;
            return this;
        }

        public FanclubBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public FanclubBuilder setName(String name) {
            return (FanclubBuilder) super.setName(name);
        }

        @Override
        public FanclubBuilder setEmail(String email) {
            return (FanclubBuilder) super.setName(email);
        }

        @Override
        public FanclubBuilder setCpf(String cpf) {
            return (FanclubBuilder) super.setName(cpf);
        }

        @Override
        public FanclubBuilder setTelephone(String telephone) {
            return (FanclubBuilder) super.setName(telephone);
        }

        public Fanclub build() {
            return new Fanclub(this);
        }

    }

}