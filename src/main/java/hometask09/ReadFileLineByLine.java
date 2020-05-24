package hometask09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        ReadFileLineByLine readFileLineByLine = new ReadFileLineByLine();
        readFileLineByLine.readFileTest();
//        readFileLineByLine.readFileTestFib();
    }

    // построчное считывание файла
    // ?куда будем считывать в массив
    public ArrayList<Integer> readFile(String fileName) {
        ArrayList<Integer> tokens = new ArrayList<Integer>();

        try {
            //File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
            File file = new File(fileName);

            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);

            String line;
            Integer intLine;

            line = reader.readLine(); // считаем первую строку
            while (line != null) {
//                System.out.println(line);
                intLine = Integer.valueOf(line);
                tokens.add(intLine); //?проверку на Integer

                line = reader.readLine(); // считаем следующую строку - чтобы потом была проверка на null
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return tokens;
    }

    public ArrayList<Integer> readFileTest() {
        String fileName;
//        String fileResource = "home09/home09_fibonacci_numbers.txt"; //доступно для File file = new File(getClass().getClassLoader().getResource(fileName).getFile());

        fileName = "src/main/resources/home09/home09_fibonacci_numbers.txt";
        return readFileTest(fileName);
    }

    public ArrayList<Integer> readFileTest(String fileName) {
        ReadFileLineByLine readFileLineByLine = new ReadFileLineByLine();
        return readFileLineByLine.readFile(fileName);
    }
}