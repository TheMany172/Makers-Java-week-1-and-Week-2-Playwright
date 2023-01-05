import org.example.ShoppingItem;
import org.example.ShoppingList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingListTest {
//    @Test
//    public void add_to_list_and_return_list() {
//        ShoppingList shoppinglist1 = new ShoppingList();
//        shoppinglist1.addItem("Cat Food");
//        shoppinglist1.addItem("Ketchup");
////        assertTrue(shoppinglist1.item_list.equals(item_list));
//        assertEquals(Arrays.asList("Cat Food", "Ketchup"), shoppinglist1.getItems());
//    }

    @Test
    public void add_to_list_and_return_list() {
        ShoppingList shoppinglist1 = new ShoppingList();
        shoppinglist1.addItem(new ShoppingItem("HP sauce", 4.99));
        shoppinglist1.addItem(new ShoppingItem("Ketchup", 3.99));
        assertEquals(Arrays.asList("Cat Food", "Ketchup"), shoppinglist1.getItems());
    }
}
