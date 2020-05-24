package hometask09;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class FibonacciMain {
    public static void main(String[] args) {
        ArrayList<Integer> tokens = new ArrayList<Integer>();

        ReadFileLineByLine readFileLineByLine = new ReadFileLineByLine();
        tokens = readFileLineByLine.readFileTest();
        System.out.println(tokens);

        for (Integer token : tokens) {
            Long fib;
            fib = FibonacciNumbers.calc(token);
//            System.out.println(String.format("%d - "%d",  token ,fib));
            System.out.print(token + " - ");
            System.out.println(df(fib));
        }
    }

    //разделитель 123 46 для больших чисел
    public static String df(Long n) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
// вот тут устанавливаем разделитель он и так по умолчанию пробел,
// но в этом примере я решил это сделать явно
        symbols.setGroupingSeparator(' ');
        DecimalFormat df = new DecimalFormat();
        df.setDecimalFormatSymbols(symbols);
// указываем сколько символов в группе
        df.setGroupingSize(3);
        return df.format(n);
    }
}

