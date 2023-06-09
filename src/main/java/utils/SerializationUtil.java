package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public final class SerializationUtil {

    private SerializationUtil() {

    }

    public static Object deserialize(File file) {
        try (
                FileInputStream fileStream = new FileInputStream(file);
                ObjectInputStream inputStream = new ObjectInputStream(fileStream)) {
            return inputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static void serialize(Object obj, File fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
