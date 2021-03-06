import java.util.InputMismatchException;
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

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public static void fanClubMenu(Systema system) {
        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("1 - Add fan 2 - Change commission based on membership level 3 - Pay 4 - Reset payment status 5 - Back");
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
                    system.fans.add(fan);


                } else if (option == 2) {
                    if (system.fans.isEmpty()) System.out.println("Wait... There's no fan");
                    else {
                        System.out.println("Enter fan's email");
                        String email = input.next();
                        for (Fanclub object : system.fans) {
                            if (object.getEmail().equals(email)) {
                                System.out.println("Choose new classification 1 ELITE 2 SENIOR 3 JUNIOR");
                                object.type = input.nextInt();
                            }
                        }
                    }
                } else if (option == 3) {
                    System.out.println("Enter fan's email");
                    String email = input.next();
                    for (Fanclub object : system.fans) {
                        if (object.getEmail().equals(email)) {
                            System.out.println("Ok");
                            object.setPaid(true);
                        }
                    }
                } else if (option == 4) {
                    System.out.println("Enter fan's email");
                    String email = input.next();
                    for (Fanclub object : system.fans) {
                        if (object.getEmail().equals(email)) {
                            if (!object.isPaid()) {
                                System.out.println("Ok");
                                object.setPaid(false);
                            }
                        }
                    }
                } else if (option == 5) exit = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
        }
    }

    public static void fanclubReport (Systema system) {
        System.out.println("Fans:");

        if (system.fans.isEmpty()) System.out.println("Error");
        else {
            for (Fanclub object : system.fans) {
                System.out.println(object.toString());
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Contribution Value: " + this.tax + "\nStatus: " + paidToString(this.paid) + "\nRank: " + rankToString(type) + "\n";
    }

    public String paidToString(boolean paid) {
        if(paid) return "Paid";
        else return "Not paid";
    }

    public String rankToString (int type)
    {
        if(type == 3) return "Junior";
        else if(type == 2) return "Senior";
        else return "Elite";
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
        public FanclubBuilder setEmail(String email) { return (FanclubBuilder) super.setEmail(email); }

        @Override
        public FanclubBuilder setCpf(String cpf) {
            return (FanclubBuilder) super.setCpf(cpf);
        }

        @Override
        public FanclubBuilder setTelephone(String telephone) {
            return (FanclubBuilder) super.setTelephone(telephone);
        }

        public Fanclub build() {
            return new Fanclub(this);
        }

    }

}
