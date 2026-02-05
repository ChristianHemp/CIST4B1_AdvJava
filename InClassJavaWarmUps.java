// example warmup file for the github assignment

public class SyntaxPractice {
    public static void main(String[] args) {
        printNumber(12345);
    }

    public static void printNumber(int num) {
        if(num < 10) {
            System.out.println(num);
        } else if (num > 10) {
            printNumber(num / 10);
            System.out.println(num % 10);
        }
    }
