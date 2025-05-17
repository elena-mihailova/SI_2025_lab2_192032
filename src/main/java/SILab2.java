import java.util.List;

class Item {
    String name;
    int quantity; //numerical
    int price;
    double discount;

    public Item(String name, int quantity, int price, double discount) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}


public class SILab2 {

    public static double checkCart(List<Item> allItems, String cardNumber){
        if (allItems == null){ // 1
            throw new RuntimeException("allItems list can't be null!"); // 2
        } // 3

        double sum = 0; // 4

        // i = 0 -> 5.1
        // i < allItems.size() -> 5.2
        // i ++ -> 5.3
        for (int i = 0; i < allItems.size(); i++){ // 5
            Item item = allItems.get(i); // 6
            if (item.getName() == null || item.getName().length() == 0){ // 7
                throw new RuntimeException("Invalid item!"); // 8
            } // 9

            if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10){ // 10
                sum -= 30; // 11
            } // 12

            if (item.getDiscount() > 0){ // 13
                sum += item.getPrice()*(1-item.getDiscount())*item.getQuantity(); // 14
            } // 15
            else { // 16
                sum += item.getPrice()*item.getQuantity(); // 17
            } // 18
        } // 19
        if (cardNumber != null && cardNumber.length() == 16) { // 20
            String allowed = "0123456789"; // 21
            char[] chars = cardNumber.toCharArray(); // 22
            // j = 0 -> 23.1
            // j < cardNumber.length() -> 23.2
            // j++ -> 23.3
            for (int j = 0; j < cardNumber.length(); j++) { // 23
                char c = cardNumber.charAt(j); // 24
                if (allowed.indexOf(c) == -1) { // 25
                    throw new RuntimeException("Invalid character in card number!"); // 26
                } // 27
            } // 28
        } // 29
        else{ // 30
            throw new RuntimeException("Invalid card number!"); // 31
        } // 32

        return sum; // 33

    } // 34
}