package BTVN;
import java.util.Scanner;
public class Bai4
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so nguyen duong n: ");
        int n;
        do {
            n = scanner.nextInt();
            if(n <= 0)
                System.out.println("Ban da nhap sai! Hay nhap lai!");
        }while(n <= 0);
        System.out.println("Cac uoc so cua " + n + " la: ");
        for (int i = 1; i <= n; i++)
        {
            if(n%i == 0) System.out.print(i + " ");
        }
    }
}
