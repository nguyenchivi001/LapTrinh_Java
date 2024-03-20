package BTVN;
import java.util.Scanner;
import java.util.Arrays;

public class Bai7
{
    public static void main(String[] args)
    {
        Bai7 B7 = new Bai7();
        Scanner s = new Scanner(System.in);
        System.out.println("Nhap so dong cua mang A: ");
        int n = s.nextInt();
        System.out.println("Nhap so cot cua mang A: ");
        int m = s.nextInt();
        int[][] A = new int[n][m];
        System.out.println("Nhap cac phan tu cua mang A: ");
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                System.out.printf("A[%d][%d] = ", i, j);
                A[i][j] = s.nextInt();
            }
        }

        int Max = A[0][0];
        int Max_Dong = 0;
        int Max_Cot = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(A[i][j] > Max)
                {
                    Max = A[i][j];
                    Max_Dong = i;
                    Max_Cot = j;
                }
            }
        }
        System.out.println("Phan tu lon nhat la: " + Max + " tại vị trí [" + Max_Dong + "][" + Max_Cot + "].");

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if( CheckSNT(A[i][j]))
                {
                    System.out.printf("%d ", A[i][j]);
                }
                else System.out.printf("%d ", 0);
            }
            System.out.println();
        }
        B7.printArraySortByColumn(A , n , m);
    }

    public static boolean CheckSNT(int n)
    {
        if (n <= 0) return false;
        if (n == 1) return true;
        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void XuatMang(int[][] A , int n , int m)
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                System.out.printf("%d ", A[i][j]);
            }
            System.out.println();
        }
    }
    public void printArraySortByColumn(int[][] A, int n, int m) {
        //Bai7 bai7 = new Bai7();
        System.out.println("Mang chua sap xep: ");
        this.XuatMang(A, n, m);
        System.out.println("Mang sap xep tang dan theo cot: ");
        int []tmpArr = new int[n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                tmpArr[j] = A[j][i];
            }
            Arrays.sort(tmpArr);
            for (int j = 0; j < n; j++) {
                A[j][i] = tmpArr[j];
            }
        }
        this.XuatMang(A, n, m);
    }
}
