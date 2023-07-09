import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        /* Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий)
        во вновь созданную папку ./backup
        */

        String sourceDir = "C:\\Education\\Finally_work\\Home_core_5\\src";
        String backupDir = "C:\\Education\\Finally_work\\Home_core_5\\backup";

        try {
            FileBackup.createBackup(sourceDir, backupDir);
            System.out.println("Backup created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating backup: " + e.getMessage());
        }

        /* Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3],
         и представляют собой, например, состояния ячеек поля для игры в крестики-нолики,
         где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом,
         3 – резервное значение. Такое предположение позволит хранить в одном числе типа int
        всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.
        */

        int[] array = {1, 2, 0, 3, 3, 1, 2, 0, 3};

        try {
            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("output.txt"));

            for (int i = 0; i < array.length; i += 3) {
                int value = array[i];
                value = (value << 2) | array[i + 1];
                value = (value << 2) | array[i + 2];

                outputStream.writeByte(value);
            }

            outputStream.close();
            System.out.println("Values have been written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing values to file.");
            e.printStackTrace();
        }
    }

}
