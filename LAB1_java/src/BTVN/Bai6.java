package BTVN;
import java.util.Scanner;
import java.util.Arrays;
public class Bai6
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so luong phan tu trong mang A: ");
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0 ; i < n ; i++)
        {
            System.out.println("Nhap phan tu thu " + i + ":");
            A[i] = scanner.nextInt();
        }
        System.out.println("Nhap so luong phan tu trong mang B: ");
        int m = scanner.nextInt();
        int[] B = new int[m];
        System.out.println("Mang B duoc tao voi cac gia tri ngau nhien: ");
        for (int i = 0 ; i < m ; i++)
        {
            B[i] = (int) (Math.random() * 100);
            System.out.print(B[i] + " ");
        }
        System.out.println();
        int[] C = Arrays.copyOf(A,n);

        System.arraycopy(B, m - 3, C, 0, 3);
        Arrays.sort(C);
        System.out.println("mang C sau khi duoc thay the va sap xep:");
        System.out.println(Arrays.toString(C));
    }
}
