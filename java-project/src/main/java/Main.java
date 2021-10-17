public class Main {

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("specify argument!");
            return;
        }
        ShoppingApplication app = new ShoppingApplication("../store");
        app.printShoppingList();
        app.addToShoppingList(args[0], 1);
        app.printShoppingList();
    }
}
