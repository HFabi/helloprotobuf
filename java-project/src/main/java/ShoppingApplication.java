import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ShoppingApplication {
    Shopping.ShoppingList.Builder shoppingList;
    String filePath;

    ShoppingApplication(String filePath) {
        System.out.println("constructor");
        this.shoppingList = Shopping.ShoppingList.newBuilder();
        this.filePath = filePath;
        try {
            this.shoppingList.mergeFrom(new FileInputStream(filePath));
        } catch (IOException e) {
            System.out.println("File not found.  Creating a new file.");
        }
    }

    void addToShoppingList(String item, int amount) {
        this.shoppingList.addItems(Shopping.Item.newBuilder().setAmount(amount).setName(item).build());
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(this.filePath);
            this.shoppingList.build().writeTo(output);
        } catch (IOException e) {
            System.out.println("File not found.  Creating a new file.");
        }
    }

    void printShoppingList() {
        System.out.println(this.shoppingList.toString());
    }
}
