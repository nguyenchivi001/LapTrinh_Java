package BTTL;
import java.util.Scanner;
public class Bai7
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n;
        do {
            System.out.println("Nhap so nguyen duong: ");
            n = s.nextInt();
            if(n > 0) break;
            else System.out.println("Ban da nhap sai! Hay nhap lai!");
        }while(n <= 0);
        if(n == 1)
        {
            System.out.println(n + " la so nguyen to");
        }
        else
        {
            boolean snt = true;
            for (int i = 2; i <= n/2; i++)
            {
                if(n % i == 0)
                {
                    snt = false;
                    break;
                }
            }
            if(snt)
            {
                System.out.println(n + " la so nguyen to!");
            }
            else
            {
                System.out.println(n + " khong la so nguyen to!");
            }
        }
    }
}
