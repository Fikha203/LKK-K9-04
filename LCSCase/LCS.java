package LCSCase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String perintah = "";
        do{
            System.out.println("==================================================");
            System.out.println("Program mencari LCS dari dua buah string");
            System.out.println("==================================================");
            System.out.println("Selamat datang di program kami!!!");
            System.out.println("Silahkan mengisi data-data berikut ini\n");

            System.out.print("Masukkan String pertama : ");
            String s1 = input.next();
            System.out.print("Masukkan String kedua : ");
            String s2 = input.next();

            System.out.println("\n----------Jawaban ditemukan----------");
            
            char[] x = s1.toCharArray();
            char[] y = s2.toCharArray();
            ArrayList z = findLCS(x,y);
            print(z);
            System.out.printf("LCS dari String \"%s\" dan String \"%s\" : ", s1, s2);

            print_LCS((String[][]) z.get(1) , x,x.length,y.length);
            System.out.println();
            
            System.out.println("----------------------------------------------------");
            System.out.println("Apakah anda ingin menggunakan program ini lagi?(Y/N)");
            System.out.println("----------------------------------------------------");
            perintah = input.next();
        } while(perintah.equalsIgnoreCase("Y"));
        System.out.println("==================================================");
        System.out.println("Terima kasih telah menggunakan program kami");
        


        
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
                    b[i][j] = "<-";
                }
            }
        }
        ArrayList temp = new ArrayList();
        temp.add(c);
        temp.add(b);

        return temp;
    }
    static void print_LCS(String[][] b, char[]x,int i,int j){
        if(i == 0 || j == 0){
            return ;
        }
        if(b[i][j].equals("^\\")){
            print_LCS(b, x, i-1, j-1);
            System.out.print(x[i-1]);

        } else if(b[i][j].equals("^|")){
            print_LCS(b, x, i-1, j);
        } else {
            print_LCS(b, x, i, j-1);
        }
    }
    

    static void print(ArrayList p){
        for (Object object : p) {
            if(object.getClass() == String[][].class){
                String[][] s = (String[][]) object;
                print(s);
            } else if (object.getClass() == int[][].class){
                int[][] s = (int[][]) object;
                print(s);
            }
        }
    }
    static void print(int[][] p){
        System.out.println("\n--------------");
        System.out.println("Matriks Angka");
        System.out.println("--------------");
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                System.out.print(p[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    static void print(String[][] p){
        System.out.println("--------------");
        System.out.println("Matriks Panah");
        System.out.println("--------------");
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                if(p[i][j] == null){
                    System.out.print(" - ");
                } else {
                    System.out.print(p[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
