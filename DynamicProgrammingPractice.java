public class DynamicProgrammingPractice {
    public static void main(String[] args) {

        System.out.println(longestCommonSubsequence("DHJRETF", "JDGHTF"));
    }

    public static int fibRecursive(int n) {
        if(n < 2) {
            return n;
        } else {
            return fibRecursive(n - 1) + fibRecursive(n - 2);
        }
    }

    public static int fibDP(int n) {
        if(n<= 1) {
            return n;
        }

        int[] tab = new int[n + 1];

        tab[0] = 0;
        tab[1] = 1;

        for(int i = 2; i <= n; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }

        return tab[n];
    }

    public static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] matrix = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix[n][m];
    }
}

// fib(n) = fib(n-1) + fib(n-2)
// 0, 1, 1, 2, 3, 5, 8, 13...

// Given two sequences, find the length of their longest common subsequence, contiguity is not required but order is
// Ex: "DHJRET" and "JDGHTF" have the longest common subsequence of "DHT"
