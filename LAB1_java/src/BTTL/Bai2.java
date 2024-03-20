package BTTL;

import java.util.Scanner;
public class Bai2
{
    public static void main(String[] args)
    {
        DivideAndPrint();
    }
    public static void DivideAndPrint()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so a: ");
        double a = scanner.nextDouble();
        System.out.println("Nhap so b: ");
        double b = scanner.nextDouble();
        if(b != 0)
        {
            double div = a / b;
            System.out.print("a/b = ");
            System.out.printf("%.3f", div);
            System.out.println();
        }
        else System.out.println("Khong the chia cho 0");
    }
}
