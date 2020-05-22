Д.З.
Дан файл содержащий несколько случайных натуральных чисел от 1 до 50
Необходимо написать многопоточное приложение которое параллельно рассчитает 
и выведет в консоль факториал для каждого числа из файла.

ПРАВИЛА ОФОРМЛЕНИЯ ФАЙЛА README.MD НА GITHUB
http://webdesign.ru.net/article/pravila-oformleniya-fayla-readmemd-na-github.html

  File file = new File(getClass().getClassLoader().getResource("home09/home09_fibonacci_numbers.txt").getFile());
  
  
            XWPFDocument document = new XWPFDocument(OPCPackage.open(file));




//read from file
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class ReadFileLineByLine {
 
    // построчное считывание файла
    public static void main(String[] args) {
        try {
            File file = new File("/Users/prologistic/file.txt");
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



// работа с word документом в java
            File file = new File(getClass().getClassLoader().getResource("home09/home09_fibonacci_numbers.txt").getFile());
            XWPFDocument document = new XWPFDocument(OPCPackage.open(file));