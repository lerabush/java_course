import java.io.*;
import java.time.LocalDateTime;

public class Task2 {


    public static void fillCart(ShoppingCart myCart,Item[] items) {
        for (Item item : items) {
            myCart.putItem(item);
        }
    }
    public static void serialize(ShoppingCart cart,String path){
        try(FileOutputStream fileOut = new FileOutputStream(path)){
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            LocalDateTime dateTime = LocalDateTime.now();
            out.writeObject(cart);
            out.writeObject(dateTime);
            out.close();
            fileOut.close();
            System.out.println("Объект сериализован");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static ShoppingCart deserialize(String path){
        try(FileInputStream fileIn = new FileInputStream(path)){
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ShoppingCart cartDeserialized  = (ShoppingCart) in.readObject();
            LocalDateTime time = (LocalDateTime) in.readObject();
            int totalSum = 0;
            for(Item item: cartDeserialized.getItems()){
                totalSum+=item.getCost();
            }
            cartDeserialized.setCartTotal(totalSum);
            cartDeserialized.setItemCount(cartDeserialized.getItems().size());
            in.close();
            fileIn.close();
            System.out.println("Дата сериализации: "+time);
            return cartDeserialized;
        }catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            return  null;
        }
    }
    public static void main(String[] args){
        ShoppingCart myCart = new ShoppingCart();
        Item[] itemsToPut = new Item[]{
                new Item(1L, "milk", 30),
                new Item(2L, "apples", 100),
                new Item(3L, "bread", 25),
                new Item(4L, "magazines", 160),
                new Item(5L, "cheese", 120),
                new Item(6L, "meat", 250),
                new Item(7L, "bubblegum", 30),
                new Item(8L, "boots", 500),
                new Item(9L, "tomatoes", 89)
        };
        fillCart(myCart,itemsToPut);
        serialize(myCart,"bush_lesson6/src/main/resources/serialize.txt");
        ShoppingCart copyCart = deserialize("bush_lesson6/src/main/resources/serialize.txt");
        copyCart.printCard();
    }

}

