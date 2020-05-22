package hometask09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {
    //private  String fileName;

    public static void main(String[] args) {
            ReadFileLineByLine readFileLineByLine = new ReadFileLineByLine();
            readFileLineByLine.readFile("home09/home09_fibonacci_numbers.txt");
    }


    // построчное считывание файла
    public  void readFile(String fileNme) {
        try {
            File file = new File(getClass().getClassLoader().getResource(fileNme).getFile());

            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}