package BTTL;

import java.util.Scanner;
public class Bai5
{
    public static void main(String[] args)
    {
        TinhTienDien();
    }
    public static void TinhTienDien()
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap so dien su dung: ");
        int sodien = s.nextInt();
        int a = sodien - 100;
        int b = sodien - 50;
        int TienDien = 0;
        if(a > 0)
        {
            TienDien = 50*2000 + b*3500;
        }
        else
        {
            if(b > 0)
            {
                TienDien = 50*2000 + b*2500;
            }
            else
            {
                TienDien = sodien*2000;
            }
        }
        System.out.println("Tien dien su dung la: " + TienDien);
    }
}
