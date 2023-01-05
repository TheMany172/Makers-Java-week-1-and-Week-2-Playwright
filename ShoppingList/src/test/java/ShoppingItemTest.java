import org.example.ShoppingItem;
import org.example.ShoppingList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingItemTest {

    @Test
    public void add_to_list_and_return_list() {
        ShoppingItem shoppingitem1 = new ShoppingItem("Cat Food", 5.99);
        assertEquals("Cat Food", shoppingitem1.name);
        assertEquals(5.99, shoppingitem1.price);
    }
}
