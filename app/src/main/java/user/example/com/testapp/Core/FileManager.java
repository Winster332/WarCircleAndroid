package user.example.com.testapp.Core;

import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import junit.framework.Assert;

import java.io.*;

/**
 * Created by User on 12/25/2016.
 */
public class FileManager {
    public static final String FILE_PATH = "Record.txt";
    public static boolean createFile(String name) {
        try {
            File file = new File(name);
            file.createNewFile();
            return true;
        } catch (Exception ex) {
            Log.d("error: ", ex.toString());
        }
        return false;
    }
    public static boolean write(String name, String value) {
        try {
            FileWriter writer = new FileWriter(name);
            writer.write(value);
            writer.close();
            return true;
        } catch (Exception ex) {
            Log.d("error: ", ex.toString());
        }
        return false;
    }
    public static String read(String name) {
        try {
            FileReader reader = new FileReader(name);
            char[] chars = new char[4024];
            reader.read(chars);
            reader.close();

            return String.valueOf(chars);
        } catch (Exception ex) {
            Log.d("error: ", ex.toString());
        }
        return "";
    }

    public static boolean exist(String name) {
        File file = new File(name);
        return file.exists();
    }
}
