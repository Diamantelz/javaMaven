package lesson22.serializing;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            // Сериализация
            ObjectOutputStream oos = new java.io.ObjectOutputStream(new java.io.FileOutputStream("state.txt"));
            oos.writeDouble(3.14159265D);
            oos.writeObject("The value of PI");
            oos.writeObject(new Point(10,253)); //запись объекта класса Point
            oos.flush();
            oos.close();

            // Десериализация
            ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream("state.txt"));
            System.out.println("Double: " + ois.readDouble());
            System.out.println("String: " + ois.readObject().toString());
            System.out.println("Point: " + (Point) ois.readObject());
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
