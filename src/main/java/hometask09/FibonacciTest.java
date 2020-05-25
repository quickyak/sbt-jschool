package hometask09;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

//проверка выполнения в 1 поток
public class FibonacciTest {
    public static void main(String[] args) {
        ArrayList<Integer> tokens = new ArrayList<Integer>();

        ReadFileLineByLine readFileLineByLine = new ReadFileLineByLine();
        tokens = readFileLineByLine.readFileTest();
        System.out.println(tokens);

        AtomicLong fibResult = new AtomicLong();
        for (Integer token : tokens) {
            FibonacciNumbers fibonacciNumbers = new FibonacciNumbers(token);
            fibResult = fibonacciNumbers.calc();
//            System.out.println(String.format("%d - "%d",  token ,fib));
            System.out.print(token + " - ");
            System.out.println(df(fibResult));
        }
    }

    //разделитель 123 46 для больших чисел
    public static String df(AtomicLong n) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
// вот тут устанавливаем разделитель он и так по умолчанию пробел,
// но в этом примере я решил это сделать явно
        symbols.setGroupingSeparator(' ');
        DecimalFormat df = new DecimalFormat();
        df.setDecimalFormatSymbols(symbols);
// указываем сколько символов в группе
        df.setGroupingSize(3);

        Long nn=n.get();
        return df.format(n.get());
    }
}

