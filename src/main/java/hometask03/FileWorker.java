// основа взята из https://devcolibri.com/java-работа-с-файлами/

package hometask03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWorker {
    private static String dirName;
    private static String fileName;
    private static String text;


    public static String getDirName() {
        return dirName;
    }

    public static void setDirName(String dirName) {
        FileWorker.dirName = dirName;
    }


    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        FileWorker.fileName = fileName;
    }


    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        FileWorker.text = text;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //Запись в файл
        FileWorker.write(dirName + fileName, text);
    }

    public static void write(String fileName, String text) {
        //Определяем файл
        File file = new File(fileName);

        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст в файл
                out.print(text);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
