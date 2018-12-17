package superMarktPackage;

import superMarktPackage.counterPackage.Counter;
import superMarktPackage.counterPackage.counterController;
import superMarktPackage.groceriesPackage.Groceries;
import superMarktPackage.shoppingCartPackage.ShoppingCart;

public class Main {

    public static void main(String[] args) {

        Counter counter = new Counter("Mohamad");

        String [] groceriesListOne = {"Robijn","Brinta","Chinese vegetables","Yoghurt","Diapers"};
        int[] groceriesQuantitiesOne = {2,3,1,2,8};

        for(int i = 0 ; i<groceriesListOne.length;i++){
            ShoppingCart.addingGrocery(new Groceries(groceriesListOne[i],groceriesQuantitiesOne[i]));
        }
        // removing the quantities of the first item
        ShoppingCart.removingGrocery(0,2);

        counterController.shoppingList(ShoppingCart.shoppingList,100.00,counter);

    }
}
