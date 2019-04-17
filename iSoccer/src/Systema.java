import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Systema {

    //login
    private String login = "ys";
    private String password = "2006";

    protected President president;
    protected Employee coach;
    protected Doctor doctor;
    protected ArrayList<Player> players;
    protected ArrayList<Rider> drivers;
    protected ArrayList<Employee> personalTrainers;
    protected ArrayList<Employee> cooks;
    protected ArrayList<Employee> lawyers;

    protected ArrayList<Fanclub> fans;

    protected TrainingCenter trainingCenter;
    protected Stadium stadium;
    protected ArrayList<Bus> vehicles;

    private static Systema onlyInstance;

    public static Systema getInstance() {

        if (onlyInstance == null) {
            onlyInstance = new Systema();
        }
        return onlyInstance;
    }

    public Systema() {
        this.players = new ArrayList<Player>();
        this.drivers = new ArrayList<Rider>();
        this.personalTrainers = new ArrayList<Employee>();
        this.cooks = new ArrayList<Employee>();
        this.lawyers = new ArrayList<Employee>();
        this.fans = new ArrayList<Fanclub>();
        this.vehicles = new ArrayList<Bus>();
    }

    public boolean menu() {
        boolean exit = false;
        Test.cadastrar(this);
        while(!exit) {
            try {
                System.out.println("Welcome to iSoccer\n 1 - Login 2 - Show report 3 - Exit");
                Scanner input = new Scanner(System.in);
                int option = input.nextInt();
                if (option == 1) {
                    menuAdmin();
                } else if (option == 2) {
                    showReport();
                } else if (option == 3) {
                    exit = true;
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input");
            }

        }
        return exit;
    }

    public boolean menuAdmin() {
        boolean exit = false;
        while(!exit) {
            System.out.print("Enter login ");
            Scanner input = new Scanner(System.in);
            String login = input.next();
            String pass;
            if (login.equals(this.login)) {
                System.out.print("Enter password ");
                pass = input.next();
                if (pass.equals(this.password))
                {
                    newLogin();
                    return true;
                }
                else {
                    System.out.println("Try again later");
                    exit = true;
                }
            } else {
                System.out.println("Try again later");
                exit = true;
            }
        }
        return exit;
    }

    public void newLogin() {
        boolean exit = false;
        while(!exit) {
            try {
                System.out.println("1 - Employee 2 - Fans 3 - Resources 4 - Logout");
                Scanner input = new Scanner(System.in);
                int option = input.nextInt();
                if (option == 1) {

                    employeeMenu();

                } else if (option == 2) {

                    Fanclub.fanClubMenu(this);

                } else if (option == 3) {

                    resourcesMenu();

                } else if (option == 4) exit = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }

        }
    }

    public void employeeMenu(){
        boolean exit = false;
        while(!exit) {
            try {
                System.out.println("1 - Add employee 2 - Edit player capacity 3 - Back");
                Scanner input = new Scanner(System.in);
                int option = input.nextInt();
                if (option == 1) {
                    try {
                        String name, email, cpf, phone;
                        int salary;

                        System.out.println("1 - President 2 - Doctor 3 - Player 4 - Rider 5 - Coach 6 - Personal trainer 7 - Cook 8 - Lawyer");
                        int option1 = input.nextInt();

                        System.out.println("Enter name");
                        name = input.next();
                        System.out.println("Enter email");
                        email = input.next();
                        System.out.println("Enter CPF");
                        cpf = input.next();
                        System.out.println("Enter telephone");
                        phone = input.next();
                        System.out.println("Enter salary");
                        salary = input.nextInt();
                        if (option1 == 1) {
                            President newPresident = President.getInstance();

                            newPresident.setName(name);
                            newPresident.setEmail(email);
                            newPresident.setCpf(cpf);
                            newPresident.setTelephone(phone);
                            newPresident.setSalary(salary);

                        } else if(option1 == 2) {
                            String crm;
                            System.out.println("Enter CRM");
                            crm = input.next();
                            this.doctor = new Doctor.DoctorBuilder().setCRM(crm).setName(name).setEmail(email).setCpf(cpf).setTelephone(phone).setSalary(salary).build();

                        } else if (option1 == 3) {
                            String position;
                            int apt;
                            boolean b = false;
                            System.out.println("Enter player's position");
                            position = input.next();
                            System.out.println("Is player apt to play? 1-Y 2-N");
                            apt = input.nextInt();
                            if (apt == 1) b = true;

                            this.players.add(new Player.PlayerBuilder().setPosition(position).setApt(b).setName(name).setEmail(email).setTelephone(phone).setCpf(cpf).setSalary(salary).build());
                        } else if (option1 == 4) {
                            int license;
                            System.out.println("Enter license plaque (numeric value)");
                            license = input.nextInt();

                            this.drivers.add(new Rider.RiderBuilder().setLicense(license).setName(name).setEmail(email).setCpf(cpf).setTelephone(phone).setSalary(salary).build());
                        } else if (option1 == 5) {
                            this.coach = new Employee.EmployeeBuilder().setCpf(cpf).setEmail(email).setSalary(salary).setTelephone(phone).setName(name).build();
                        } else if (option1 == 6) {
                            this.personalTrainers.add( new Employee.EmployeeBuilder().setCpf(cpf).setEmail(email).setSalary(salary).setTelephone(phone).setName(name).build());
                        } else if (option == 7) {
                            this.cooks.add( new Employee.EmployeeBuilder().setCpf(cpf).setEmail(email).setSalary(salary).setTelephone(phone).setName(name).build());
                        } else if (option1 == 8) {
                            this.lawyers.add( new Employee.EmployeeBuilder().setCpf(cpf).setEmail(email).setSalary(salary).setTelephone(phone).setName(name).build());
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input");
                    }

                } else if (option == 2) {
                    boolean done = false;
                    if(players.isEmpty()) System.out.println("Wait... There's no player");

                    else {
                        System.out.println("Enter player's email");
                        String email = input.next();
                        for(Player object : players){
                            if(object.getEmail().equals(email)){
                                if(object.isApt()){
                                    int change = 0;
                                    System.out.println("To change this press 1");
                                    change = input.nextInt();
                                    if(change == 1) object.setApt(false);
                                    done = true;
                                } else {
                                    int change = 0;
                                    System.out.println("To change this press 1");
                                    change = input.nextInt();
                                    if(change == 1) object.setApt(true);
                                    done = true;
                                }
                            }
                        } if (!done) { System.out.println("We couldn't find them");}
                    }
                } else if (option == 3) exit = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }

        }
    }

    public void resourcesMenu() {
        boolean exit = false;
        while(!exit) {
            try {
                System.out.println("1 - Add resource 2 - Back");
                Scanner input = new Scanner(System.in);
                int option = input.nextInt();
                if (option == 1) {

                    String license;

                    System.out.println("1 - Bus 2 - Training Center 3 - Stadium");
                    int option1 = input.nextInt();

                    if (option1 == 1) {

                        System.out.println("Enter license plate");
                        license = input.next();

                        Bus newBus = new Bus(true, license);
                        vehicles.add(newBus);

                    } else if(option1 == 2) {
                        int capacity;
                        System.out.println("Enter number of dorms");
                        capacity = input.nextInt();

                        TrainingCenter newTrainingCenter = new TrainingCenter(true, capacity);

                    } else if (option1 == 3) {
                        int capacity, numberToilets, numberSnacks;
                        System.out.println("Enter capacity");
                        capacity = input.nextInt();
                        System.out.println("Enter number of toilets");
                        numberToilets = input.nextInt();
                        System.out.println("Enter number of cafeterias");
                        numberSnacks = input.nextInt();

                        Stadium newStadium = new Stadium(true, capacity, numberToilets, numberSnacks);
                    }
                } else if (option == 2) exit = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
        }
    }

    public void showReport() {
        boolean exit = false;
        while(!exit) {
            try {
                System.out.println("Show report of 1 - Employee 2 - Fans 3 - Resources 4 - All of it");
                Scanner input = new Scanner(System.in);
                int option = input.nextInt();
                if (option == 1) {

                    Employee.employeeReport(this);

                    exit = true;

                } else if (option == 2) {

                    Fanclub.fanclubReport(this);
                    exit = true;

                } else if (option == 3) {

                    Resource.resourcesReport(this);
                    exit = true;

                } else if (option == 4) {

                    Employee.employeeReport(this);
                    Fanclub.fanclubReport(this);
                    Resource.resourcesReport(this);

                    exit = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
        }
    }

}
