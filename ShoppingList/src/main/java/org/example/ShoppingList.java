package org.example;

import java.util.ArrayList;

public class ShoppingList {
    public ArrayList<ShoppingItem> item_list = new ArrayList<>();

    public ShoppingList(){

    }

    public void addItem(ShoppingItem item1){
        item_list.add(item1);
    }

    public ArrayList getItems(){
        return item_list;
    }
}
