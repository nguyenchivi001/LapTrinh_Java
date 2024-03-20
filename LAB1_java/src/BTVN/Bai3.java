package BTVN;
import java.util.Scanner;
public class Bai3
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tu so: ");
        int ts = scanner.nextInt();
        int ms;
        do {
            System.out.println("Nhap mau so: ");
            ms = scanner.nextInt();
            if (ms == 0) System.out.println("Mau so phai khac 0!");
        } while (ms == 0);

        System.out.println("Phan so truoc khi don gian: " + ts + "/" + ms);
        int ucln = UCLN(ts, ms);
        if (ucln == 1)
        {
            System.out.println("Phan so " + ts + "/" + ms + " la phan so toi gian!");
        }
        else
        {
            ts = ts / ucln;
            ms = ms / ucln;
            System.out.println("Phan so sau khi don gian: " + ts + "/" + ms);
        }
    }
    public static int UCLN(int a, int b)
    {
        if(b == 0)
            return a;
        return UCLN(b,a%b);
    }
}
