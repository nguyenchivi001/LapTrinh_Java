package BTTL;

import java.util.Scanner;

public class Bai1
{
    public static void main(String[] args)
    {
        TinhChuVi();
    }

    public static void TinhChuVi()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ban kinh cua duong tron: ");
        double bankinh = scanner.nextDouble();
        double chuvi = 2 * Math.PI * bankinh;
        System.out.println("chu vi cua duong tron la: " + chuvi);
    }
}