package item86;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

    public static void main(String[] args) {

        /*User user = new User("가나다", 30);

        String fileName = "user.ser";

        try(
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(user);
        }catch (IOException e){
            e.printStackTrace();
        }*/

        String fileName = "user.ser";

        try(
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream (fis);
        ) {
            User deserializedUser = (User)ois.readObject();
            System.out.println(deserializedUser);

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
