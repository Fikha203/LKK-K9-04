package MCMCase;

import java.util.ArrayList;
import java.util.Arrays;

public class MCM {

    public static void main(String[] args) {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        ArrayList<int[][]> hasil = MatrixChainOrder(p);
        print(hasil);
    }

    static ArrayList<int[][]> MatrixChainOrder(int[] p) {
        int n = p.length - 1;

        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }

        int j = 0;
        int q = 0;

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                    print(m);
                    print(s);
                }
            }
        }
        return new ArrayList<>(Arrays.asList(m, s));
    }

    static void print(ArrayList<int[][]> p) {
        for (int[][] a : p) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("\n");
        }
    }

    static void print(int[][] p) {
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                System.out.print(p[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}

