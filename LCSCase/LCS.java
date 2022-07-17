package LCSCase;

import java.util.ArrayList;

public class LCS {
    public static void main(String[] args) {
        char[] x = {'A', 'B', 'C', 'B', 'D', 'A','B'};
        char[] y = {'B', 'D', 'C', 'A', 'B', 'A'};

        ArrayList z = findLCS(x,y);

        
    }

    static ArrayList findLCS(char[] x, char[] y){
        int m = x.length;
        int n = y.length;
        int[][] c = new int[m+1][n+1];
        String[][] b = new String[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            c[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            c[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(x[i-1] == y[j-1]){
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = "^\\";

                } else if(c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = "^|";

                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = "<|";
                }
            }
        }
        print(c);
        print(b);
        return new ArrayList<>();
    }
    static void print(int[][] p){
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                System.out.print(p[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void print(String[][] p){
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                System.out.print(p[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
