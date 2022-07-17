package MCMCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MCM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // String perintah yang nantinya untuk menentukan apakah loop berhenti atau tidak
        String perintah = "";
        do{
            System.out.println("==================================================");
            System.out.println("Program mencari jumlah perkalian minimum matriks");
            System.out.println("==================================================");
            System.out.println("Selamat datang di program kami!!!");
            System.out.println("Silahkan mengisi data-data berikut ini\n");
            System.out.print("Masukkan jumlah matriks : ");
            int n = input.nextInt();

            // ArrayList dari matriks-matriks yang diinputkan
            ArrayList<Integer> matriks[] = new ArrayList[n+1];
            for (int i = 0; i < matriks.length; i++) {
                matriks[i] = new ArrayList<Integer>();
            }
            int[] p = new int[n+1];

            System.out.println("Masukkan data baris dan kolom tiap-tiap matriks (baris<spasi>kolom)");
            System.out.println("Matriks 1 : ");
            p[0] = input.nextInt();
            p[1] = input.nextInt();
            matriks[1].add(p[0]);
            matriks[1].add(p[1]);
            for(int i = 2; i<= n; i++){
                System.out.println("Matriks " + i + " : ");
                int baris = input.nextInt();
                int kolom = input.nextInt();
                p[i] = kolom;
                matriks[i].add(baris);
                matriks[i].add(kolom);
            }
            System.out.println("\n----------Jawaban ditemukan----------");
            
            ArrayList<int[][]> hasil = findMCM(p);
            print(hasil);

            do{
                System.out.println("==================================================");
                System.out.println("\nData matriks : \n");

                for (int i = 1; i <= n; i++) {
                    System.out.printf("Matriks ke-%d : %d X %d\n", i,matriks[i].get(0),matriks[i].get(1));
                }

                System.out.println("\nPilih matriks awal dan tujuan untuk dihitung");
                System.out.print("Matriks awal : " );
                int i = input.nextInt();
                System.out.print("Matriks tujuan : " );
                int j = input.nextInt();

                System.out.printf("\nSolusi optimal perkalian matriks dari matriks ke-%d sampai matriks ke-%d adalah : \n",i,j);

                System.out.printf("Jumlah cost minimum perkalian : %d\n", hasil.get(0)[i][j]);

                System.out.print("Pengukurungan perkalian matriks yang optimal : ");
                print_Optimal(hasil.get(1), i, j);

                System.out.println("\n#note : M1 = Matriks ke-1");

                System.out.println("----------------------------------------------");
                System.out.println("Apakah anda ingin memilih matriks ulang?(Y/N)");
                System.out.println("----------------------------------------------");
                perintah = input.next();
                
            } while(perintah.equals("Y"));
            
            System.out.println("\n ");
            System.out.println("----------------------------------------------");
            System.out.println("Apakah anda ingin menggunakan program ini lagi?(Y/N)");
            System.out.println("----------------------------------------------");
            perintah = input.next();
            
        } while(perintah.equalsIgnoreCase("Y"));
        System.out.println("==================================================");
        System.out.println("Terima kasih telah menggunakan program kami");
    
    }
    
    static ArrayList<int[][]> findMCM(int[] p) {
        int n = p.length;

        int i,j,k,l,q;
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];

        for (i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        for (l = 2; l < n; l++) {
            for (i = 1; i < n - l + 1; i++) {
                j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        return new ArrayList<>(Arrays.asList(m, s));
    }

    static void print_Optimal(int[][] s, int i, int j){
        if(i == j){
            System.out.print("M" + i);
        } else {
            System.out.print("(");
            print_Optimal(s, i, s[i][j]);
            print_Optimal(s, s[i][j]+1, j);
            System.out.print(")");
        }
    }

    static void print(ArrayList<int[][]> p) {
        for (int[][] a : p) {
            System.out.print(" |");
            for(int j = 1;j< a.length ; j++){
                System.out.printf("%d\t|",j);
            }
            for (int i = a.length-1; i >= 1; i--) {
                System.out.println("\n--------------------------------------------------");
                System.out.printf("%d|",i);
                for (int j = 1;j< a[i].length ; j++) {
                    System.out.printf("%d\t|",a[j][i]);
                    
                }
            }
            System.out.println("\n\n");
        }
    }

    static void print(int[][] p) {
        for (int i = p.length-1; i >= 1; i--) {
            for (int j = 1; j < p[i].length; j++) {
                System.out.print(p[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

}

