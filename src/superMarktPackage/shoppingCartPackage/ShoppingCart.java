package superMarktPackage.shoppingCartPackage;

import superMarktPackage.groceriesPackage.Groceries;

import java.util.ArrayList;

public class ShoppingCart {

    // shopping lisr array
    public static ArrayList<Groceries> shoppingList = new ArrayList<>();

    // adding groceries to shopping cart list
    public static void addingGrocery (Groceries product)
    {
        shoppingList.add(product);
    }

    // removing Qty of the item from the shopping cart list
    public static void removingGrocery (int index,int qty){
        int newQty = (shoppingList.get(index).getQuantity()-qty);
        shoppingList.get(index).setQuantity(newQty);
    }

}

