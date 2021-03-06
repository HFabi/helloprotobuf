import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ProtobufApplication {

    Shopping.ShoppingList.Builder shoppingList;
    String filePath;

    ProtobufApplication(String filePath) {
        this.shoppingList = Shopping.ShoppingList.newBuilder();
        this.filePath = filePath;
        try {
            this.shoppingList.mergeFrom(new FileInputStream(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.  Creating a new file.");
        }
    }

    void addToShoppingList(String item, int amount) throws FileNotFoundException {
        this.shoppingList.addItems(Shopping.Item.newBuilder().setAmount(amount).setName(item).build());
        FileOutputStream output = new FileOutputStream(this.filePath);
        this.shoppingList.build().writeTo(output);
    }

    void printShoppingList() {
        System.out.println(this.shoppingList.toString());
    }
}
