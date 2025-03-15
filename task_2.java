//Task 2
import java.util.HashMap;
import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> stockPrices = new HashMap<>();
        HashMap<String, Integer> portfolio = new HashMap<>();
        double balance = 10000.0; // Starting balance

        // Initializing stock prices
        stockPrices.put("AAPL", 150.0);
        stockPrices.put("GOOGL", 2800.0);
        stockPrices.put("TSLA", 900.0);
        stockPrices.put("AMZN", 3400.0);

        while (true) {
            System.out.println("\n1. View Stock Prices\n2. Buy Stock\n3. Sell Stock\n4. View Portfolio\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nStock Prices:");
                    for (String stock : stockPrices.keySet()) {
                        System.out.println(stock + ": $" + stockPrices.get(stock));
                    }
                    break;
                case 2:
                    System.out.print("\nEnter stock symbol to buy: ");
                    String buyStock = scanner.next().toUpperCase();
                    if (stockPrices.containsKey(buyStock)) {
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        double cost = quantity * stockPrices.get(buyStock);
                        if (cost <= balance) {
                            balance -= cost;
                            portfolio.put(buyStock, portfolio.getOrDefault(buyStock, 0) + quantity);
                            System.out.println("Bought " + quantity + " shares of " + buyStock);
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Invalid stock symbol.");
                    }
                    break;
                case 3:
                    System.out.print("\nEnter stock symbol to sell: ");
                    String sellStock = scanner.next().toUpperCase();
                    if (portfolio.containsKey(sellStock) && portfolio.get(sellStock) > 0) {
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        if (quantity <= portfolio.get(sellStock)) {
                            double earnings = quantity * stockPrices.get(sellStock);
                            balance += earnings;
                            portfolio.put(sellStock, portfolio.get(sellStock) - quantity);
                            System.out.println("Sold " + quantity + " shares of " + sellStock);
                        } else {
                            System.out.println("Not enough shares to sell.");
                        }
                    } else {
                        System.out.println("You don't own this stock.");
                    }
                    break;
                case 4:
                    System.out.println("\nYour Portfolio:");
                    double totalValue = 0;
                    for (String stock : portfolio.keySet()) {
                        if (portfolio.get(stock) > 0) {
                            double stockValue = portfolio.get(stock) * stockPrices.get(stock);
                            totalValue += stockValue;
                            System.out.println(stock + ": " + portfolio.get(stock) + " shares ($" + stockValue + ")");
                        }
                    }
                    System.out.println("Total Portfolio Value: $" + totalValue);
                    System.out.println("Available Balance: $" + balance);
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

