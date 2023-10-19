import java.util.ArrayList;
import java.util.Scanner;

class Items {
    private String name;
    private double price;
    private int quantity;

    public Items(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

public class InteractiveApplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int optionChoice;
        int checkOutChoice;
        MenuSettings menuSettings = new MenuSettings();

        do {
            System.out.println("Options: [1]: Place Order, [2]: Check Out, [3]: Add Items, [0]: Exit");
            optionChoice = scan.nextInt();

            switch (optionChoice) {
                case 1:
                    menuSettings.order();
                    break;
                case 2:
                    menuSettings.checkOut();
                    do {
                        System.out.println("[1]: Finish Order and Pay  [2]: Return to order menu");
                        checkOutChoice = scan.nextInt();
                        if (checkOutChoice == 1) {
                            System.out.println("Payment Successful, Thank you for your patronage");
                            return;
                        } else if (checkOutChoice == 2) {
                            break;
                        } else {
                            System.out.println("Invalid option");
                        }
                    }while (true);
                    break;
                case 3:
                    menuSettings.addItem();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (optionChoice != 0);
    }
}

class MenuSettings {
    private Scanner scan = new Scanner(System.in);
    private ArrayList<Items> menu = new ArrayList<>();
    private ArrayList<Items> addOns = new ArrayList<>();
    private ArrayList<Items> orderedItems = new ArrayList<>();
    private double dollarToPeso = 56.83;

    public MenuSettings() {
        menu.add(new Items("C1", 100.00));
        menu.add(new Items("C2", 150.00));
        menu.add(new Items("C3", 200.00));

        addOns.add(new Items("R1", 50.00));
        addOns.add(new Items("R2", 60.00));
    }

    public void menu() {
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            Items item = menu.get(i);
            System.out.println(i + 1 + " " + item.getName() + " - Php " + item.getPrice());
        }
    }

    public void addOns() {
        System.out.println("Add Ons:");
        for (int i = 0; i < addOns.size(); i++) {
            Items item = addOns.get(i);
            System.out.println(i + 1 + " " + item.getName() + " - Php " + item.getPrice());
        }
    }

    public void order() {
        int selection;
        int selectedItem;
        do {
            System.out.println("Select [1]: Menu  [2]: Add Ons [0]: Exit");
            selection = scan.nextInt();
            switch (selection) {
                case 1:
                    do {
                        System.out.print("[0: Exit] ");
                        menu();
                        selectedItem = scan.nextInt();
                        if (selectedItem >= 1 && selectedItem <= menu.size()) {
                            int index = selectedItem - 1;
                            System.out.print("Enter the quantity to order: ");
                            int quantity = scan.nextInt();
                            if (index < 0 || index >= menu.size()) {
                                System.out.println("Invalid menu item selection.");
                                continue;
                            }
                            Items orderedItem = new Items(menu.get(index).getName(), menu.get(index).getPrice());
                            orderedItem.setQuantity(quantity);
                            orderedItems.add(orderedItem);
                            System.out.println(menu.get(index).getName() + " (Quantity: " + quantity + ") Added to Order");
                        } else if (selectedItem != 0) {
                            System.out.println("Invalid menu item selection.");
                        }
                    } while (selectedItem != 0);
                    break;
                case 2:
                    do {
                        System.out.print("[0: Exit] ");
                        addOns();
                        selectedItem = scan.nextInt();
                        if (selectedItem >= 1 && selectedItem <= addOns.size()) {
                            int index = selectedItem - 1;
                            System.out.print("Enter the quantity to order: ");
                            int quantity = scan.nextInt();
                            if (index < 0 || index >= addOns.size()) {
                                System.out.println("Invalid add-on selection.");
                                continue;
                            }
                            Items orderedItem = new Items(addOns.get(index).getName(), addOns.get(index).getPrice());
                            orderedItem.setQuantity(quantity);
                            orderedItems.add(orderedItem);
                            System.out.println(addOns.get(index).getName() + " (Quantity: " + quantity + ") Added to Order");
                        } else if (selectedItem != 0) {
                            System.out.println("Invalid add-on selection.");
                        }
                    } while (selectedItem != 0);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } while (selection != 0);
    }

    public void addItem() {
        int addItemChoice;
        String addItemName;
        double addItemPrice;

        do {
            System.out.println("Select category to add item [1]: Menu  [2]: Add Ons  [0]: Exit");
            addItemChoice = scan.nextInt();
            switch (addItemChoice) {
                case 1:
                    System.out.println("[Menu] Name of Product: ");
                    addItemName = scan.next();
                    System.out.println("[Menu] Price of Product: ");
                    addItemPrice = scan.nextDouble();
                    menu.add(new Items(addItemName, addItemPrice));
                    break;
                case 2:
                    System.out.println("[Add Ons] Name of Product: ");
                    addItemName = scan.next();
                    System.out.println("[Add Ons] Price of Product: ");
                    addItemPrice = scan.nextDouble();
                    addOns.add(new Items(addItemName, addItemPrice));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (addItemChoice != 0);
    }

    public void checkOut() {
        System.out.println("\nOrdered Items: ");
        double total = 0;

        for (Items orderedItem : orderedItems) {
            System.out.println(orderedItem.getName() + " (Quantity: " + orderedItem.getQuantity() + ") - Php " + orderedItem.getTotalPrice());
            total += orderedItem.getTotalPrice();
        }

        double dollarTotal = total / dollarToPeso;
        System.out.println("Current dollar to peso: Php " + dollarToPeso);
        System.out.println("Total to pay: Php " + total);
        System.out.println("Total to pay in dollars: $ " + dollarTotal + "\n");
    }
}
