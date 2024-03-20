package BTVN;
import java.util.Scanner;
public class Bai2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so a: ");
        int a = scanner.nextInt();
        System.out.println("Nhap so b: ");
        int b = scanner.nextInt();
        int bcnn = BCNN(a,b);

        System.out.println("BCNN cua " + a + " va " + b + " la : " + bcnn);
    }
    public static int UCLN(int a, int b)
    {
        if (b == 0)
            return a;
        return UCLN(b, a % b);
    }
    public static int BCNN(int a, int b)
    {
        int ucln = UCLN(a,b);
        return (a*b)/ucln;
    }
}

