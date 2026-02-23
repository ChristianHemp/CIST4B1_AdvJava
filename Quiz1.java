public class Quiz1 {
    public static void main(String[] args) {

        System.out.println(reverseString("testdf"));
        System.out.println(countOccurrences("haha", 'a'));
    }

    static String reverseString(String input) {
        if(input == null || input.length() <= 1) {
            return input;
        }
        else {
            return reverseString(input.substring(1)) + input.charAt(0);
        }
    }

    static int countOccurrences(String input, char character) {
        if(input == null || input.length() == 0) {
            return 0;
        }

        if(input.charAt(0) == character) {
            return 1 + countOccurrences(input.substring(1), character);
        } else {
            return countOccurrences(input.substring(1), character);
        }
    }
}
