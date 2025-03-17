import java.util.*;

class CardCollectionSystem {
    private static final Map<String, List<String>> cardCollection = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void addCard(String symbol, String card) {
        cardCollection.computeIfAbsent(symbol, k -> new ArrayList<>()).add(card);
    }

    public static void searchCardsBySymbol() {
        System.out.print("Enter card symbol to search (e.g., Hearts, Spades): ");
        String symbol = scanner.nextLine();
        List<String> cards = cardCollection.get(symbol);
        if (cards != null && !cards.isEmpty()) {
            System.out.println("Cards of " + symbol + ": " + cards);
        } else {
            System.out.println("No cards found for symbol: " + symbol);
        }
    }

    public static void main(String[] args) {
        addCard("Hearts", "Ace");
        addCard("Hearts", "King");
        addCard("Spades", "Queen");
        addCard("Diamonds", "Jack");
        addCard("Clubs", "10");
        
        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Search Cards by Symbol");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> searchCardsBySymbol();
                case 2 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
