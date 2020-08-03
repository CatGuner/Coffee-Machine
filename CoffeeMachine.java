package machine;

import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Machine machine1 = new Machine(400, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            TypeOfRequest request = TypeOfRequest.valueOf(action.toUpperCase());
            switch (request) {
                case BUY:
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String typeCoffee = scanner.next();
                    Option option = Option.findOption(typeCoffee);
                    if (!option.equals(Option.BACK)) {
                        machine1.buy(option);
                    }
                    break;
                case FILL:
                    System.out.println("Write how many ml of water do you want to add:");
                    int water = scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    int milk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    int coffeeBeans = scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    int cups = scanner.nextInt();
                    machine1.fill(water, milk, coffeeBeans, cups);
                    break;
                case TAKE:
                    machine1.take();
                    break;
                case REMAINING:
                    System.out.println("\nThe coffee machine has:\n" + machine1.toString() + "\n");
                    break;
                case EXIT:
                    return;

            }
        }
    }
}
