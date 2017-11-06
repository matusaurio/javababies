import models.Baby;
import models.Gift;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BabyRegister {

    public static ArrayList<Baby> babies = new ArrayList<>();

    public static void initialBabies() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");

        try {
            String b1n = "Santiago";
            String bday = "199108252005";
            Date b1b = dateFormat.parse(bday);
            char b1g = 'm';
            Baby b1 = new Baby(b1n, b1b, b1g);
            babies.add(b1);
        } catch (ParseException e) {
            System.out.println("Invalid date.");
        }

        try {
            String b2n = "John";
            String bday2 = "199201010000";
            Date b2b = dateFormat.parse(bday2);
            char b2g = 'm';
            Baby b2 = new Baby(b2n, b2b, b2g);
            babies.add(b2);
        } catch (ParseException e) {
            System.out.println("Invalid date.");
        }

        try {
            String b3n = "Cosmo";
            String bday3 = "199302030405";
            Date b3b = dateFormat.parse(bday3);
            char b3g = 'm';
            Baby b3 = new Baby(b3n, b3b, b3g);
            babies.add(b3);
        } catch (ParseException e) {
            System.out.println("Invalid date.");
        }
    }

    public static void sort(String type) {
        if (type == "age") {
            Collections.sort(babies, new Comparator<Baby>() {
                @Override
                public int compare(Baby o1, Baby o2) {
                    return o2.getName().compareTo(o1.getName());
                }
            });
        } else if (type == "name") {
            Collections.sort(babies, new Comparator<Baby>() {
                @Override
                public int compare(Baby o1, Baby o2) {
                    return o2.getBirthday().compareTo(o1.getBirthday());
                }
            });
        }
        printAll("babies");
    }

    public static void printAll(String type) {
        if (type == "babies") {
            for (Baby baby : babies) {
                System.out.println(baby);
            }
        } else if (type == "gifts") {
            for (Gift gift : gifts) {
                System.out.println(gift);
            }
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        String userCommand;
        String userCommandGift;

        System.out.println("Main Menu");
        System.out.println("Press 1 to add a new baby.");
        System.out.println("Press 2 to list babies by age.");
        System.out.println("Press 3 to list babies by name.");
        System.out.println("Press 4 to exit.");

        initialBabies();

        do {
            System.out.print("Enter an option: ");

            userCommand = scanner.next();

            switch (userCommand) {
                case "1":
                    System.out.print("Enter the name of the baby: ");
                    String name = scanner.next();
                    System.out.print("Enter the birthday of the baby (yyyyMMddHHmm): ");
                    Date birthday = new Date();

                    boolean validDate = false;
                    while (!validDate) {
                        try {
                            birthday = dateFormat.parse(scanner.next());
                            validDate = true;
                        } catch (ParseException e) {
                            System.out.println("Invalid date, type it again");
                            validDate = false;
                        }
                    }
                    System.out.print("Enter the gender of the baby (Male: m, Female: f): ");
                    char gender = scanner.next().charAt(0);

                    Baby baby = new Baby(name, birthday, gender);
                    babies.add(baby);
                    System.out.println(name + " was added.");

                    System.out.print("Do you want to add a gift for this baby? (yes/no): ");
                    userCommandGift = scanner.next();
                    if (userCommandGift.equals("yes")) {
                        System.out.print("Enter the name of the gift: ");
                        String giftName = scanner.next();
                        System.out.print("Enter a short description of the gift: ");
                        String giftDescription = scanner.next();
                        Date giftDate = new Date();

                        boolean validDateG = false;
                        while(!validDateG){
                            try{
                                giftDate = dateFormat.parse(scanner.next());
                                validDateG = true;
                            }catch(ParseException e){
                                System.out.println("Invalid date, type it again");
                                validDateG = false;
                            }
                        }
                        Gift gift = new Gift(giftName, giftDescription, giftDate);
                        baby.setGift(gift);
                        System.out.println("The gift was added.");
                    } else {
                        System.out.print("Do you want to list the gifts? (yes/no): ");
                        userCommandGift = scanner.next();
                        if (userCommandGift.equals("yes")) {
                            printAll("gifts");
                        }
                    }
                    break;
                case "2":
                    sort("age");
                    break;
                case "3":
                    sort("name");
                    break;
                    break;
                case "4":
                    break;
            }
        } while (!userCommand.equals("4"));
    }
}
