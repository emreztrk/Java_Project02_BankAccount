package Project02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {
        Scanner scStr = new Scanner(System.in);
        Scanner scInt=new Scanner(System.in);

        String word;

        do {
            System.out.print("Enter username=");
            String user=scStr.nextLine();
            System.out.print("Enter password=");
            String pass=scStr.nextLine();

            word=confirmUsernameAndPassword(user,pass);

        }while (!word.contains("Successful"));

        int userChoice;
        List<String> acc = new ArrayList<>(Arrays.asList("1234", "5678", "9999"));
        List<Integer> fnd = new ArrayList<>(Arrays.asList(200, 1000, 5000));
        do {
            List<String> actions = new ArrayList<>(Arrays.asList("Cash Deposit", "Withdraw", "Transfer", "Exit"));
            System.out.println("Select the action you want to do");
            for (int i = 0; i < actions.size(); i++) {
                System.out.println(actions.get(i) + " - " + (i + 1));
            }
            userChoice = scInt.nextInt();

            switch (userChoice) {
                case 1: {
                    System.out.println("This ATM is temporarily disabled for deposits... Sorry.");
                }
                break;
                case 2: {
                    System.out.println("Which account do you want to withdraw money from?");
                    System.out.println("1234");
                    System.out.println("5678");
                    System.out.println("9999");
                    String account=scStr.nextLine();

                    for (int i = 0; i < acc.size(); i++) {

                        if (account.equals(acc.get(i))) {
                            System.out.println("Chosen Account: " + acc.get(i));
                            System.out.println("How much do you want to withdraw? ");
                            int withdrew = scInt.nextInt();
                            if (fnd.get(i)>withdrew)
                                withdraw(acc, fnd, acc.get(i), withdrew);
                            else
                                System.out.println("Insufficient Balance");
                            break;
                        }
                        else
                            System.out.println("You Have Entered Incorrectly");
                        break;
                    }
                }
                break;
                case 3: {
                    System.out.println("We are not able to perform this operation at the moment...");
                }
                break;
                case 4:
                    System.exit(1);

                default: {
                    System.out.println("You didn't make a successful choice...");
                }

            }
        }while (userChoice!=6);


    }
    private static void withdraw(List<String> accounts, List<Integer> funds, String chosenAccount, int amountToWithdraw) {
        int sAccount;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).equals(chosenAccount)){
                sAccount=funds.get(i)-amountToWithdraw;
                funds.set(i,sAccount);
            }
        }
        System.out.println("Account Latest Status=");
        for (int i = 0; i < funds.size(); i++) {
            System.out.println((i+1)+". Account="+ funds.get(i));

        }
    }
    public static String confirmUsernameAndPassword(String u, String p) {
        String definition = "";

        List<String> usernames = new ArrayList<>(Arrays.asList("user1", "user2", "user3"));
        List<String> passwords = new ArrayList<>(Arrays.asList("password1", "password2", "password3"));
        List<String> digits = new ArrayList<>(Arrays.asList("1234", "5678", "9999"));
        List<Integer> money = new ArrayList<>(Arrays.asList(200, 1000, 5000));

        for (int i = 0; i < usernames.size(); i++) {

            if (u.equals(usernames.get(i)) && p.equals(passwords.get(i))) {
                definition = "You have Successfully logged in";
                System.out.println(definition);

                break;
            } else {
                definition = "No such user was found in the system, please try again";
                System.out.println(definition);

                break;
            }
        }
        return definition;
    }
}
