package BTVN;
import java.util.Scanner;
public class Bai1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so a: ");
        int a = scanner.nextInt();
        System.out.println("Nhap so b: ");
        int b = scanner.nextInt();
        int ucln = UCLN(a,b);
        System.out.println("UCLN cua " + a + " va " + b + " la : " + ucln);
    }
    public static int UCLN(int a, int b)
    {
        if(b == 0)
            return a;
        return UCLN(b,a%b);
    }
}
