package hometask09;

public class Main {
    public static void main(String[] args) {
        String fileName = "home09/home09_fibonacci_numbers.txt";
        ReadFileLineByLine readFileLineByLine = new ReadFileLineByLine();
        readFileLineByLine.readFile(fileName);

        int n;
        long result;

        n=60;
        for (int i=3; i<n+1;i++) {
            result = fibCycle(i);
            System.out.println("input = " + i + "  result = " + result);
        }
    }

    public static long fibCycle(int n) {
        long n0=1;
        long n1=1;
        long n2=1;

        for (int i=3; i<n+1;i++) {
            n2=n0+n1;
            n0=n1;
            n1=n2;
        }
        return n2;
    }


}


