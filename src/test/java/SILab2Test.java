import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class SILab2Test {

    @Test
    public void everyStatementTest() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null, "1234567890123456");
        });
        assertEquals("allItems list can't be null!", exception.getMessage());

        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", 5, 200, 0));

        List<Item> finalItems = items;
        exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(finalItems, null);
        });
        assertEquals("Invalid card number!", exception.getMessage());

        List<Item> finalItems1 = items;
        exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(finalItems1, "123456");
        });
        assertEquals("Invalid card number!", exception.getMessage());

        items = new ArrayList<>();
        items.add(new Item("Item1", 15, 350, 0.1));
        items.add(new Item("Item2", 5, 200, 0.2));

        double expectedSum = (350 * 0.9 * 15 - 30) + (200 * 0.8 * 5 - 30);
        assertEquals(expectedSum, SILab2.checkCart(items, "1234567890123456"));
    }

    @Test
    public void multipleConditionTest() {
        String validCardNumber = "1234567890123456";
        List<Item> items = new ArrayList<>();

        items.clear();
        items.add(new Item("Item1", 10, 300, 0));
        double expectedSum = 300 * 10;
        assertEquals(expectedSum, SILab2.checkCart(items, validCardNumber));

        items.clear();
        items.add(new Item("Item2", 10, 301, 0));
        expectedSum = (301 * 10) - 30;
        assertEquals(expectedSum, SILab2.checkCart(items, validCardNumber));

        items.clear();
        items.add(new Item("Item3", 10, 300, 0.1));
        expectedSum = (300 * 0.9 * 10) - 30;
        assertEquals(expectedSum, SILab2.checkCart(items, validCardNumber));

        items.clear();
        items.add(new Item("Item4", 11, 300, 0));
        expectedSum = (300 * 11) - 30;
        assertEquals(expectedSum, SILab2.checkCart(items, validCardNumber));

        items.clear();
        items.add(new Item("Item5", 10, 301, 0.1));
        expectedSum = (301 * 0.9 * 10) - 30;
        assertEquals(expectedSum, SILab2.checkCart(items, validCardNumber));

        items.clear();
        items.add(new Item("Item6", 11, 301, 0));
        expectedSum = (301 * 11) - 30;
        assertEquals(expectedSum, SILab2.checkCart(items, validCardNumber));

        items.clear();
        items.add(new Item("Item7", 11, 300, 0.1));
        expectedSum = (300 * 0.9 * 11) - 30;
        assertEquals(expectedSum, SILab2.checkCart(items, validCardNumber));

        items.clear();
        items.add(new Item("Item8", 11, 301, 0.1));
        expectedSum = (301 * 0.9 * 11) - 30;
        assertEquals(expectedSum, SILab2.checkCart(items, validCardNumber));
    }
}

