package BTTL;

import java.util.Scanner;
public class Bai4
{
       public static void main(String[] args)
       {
            CheckString();
       }

       public static void CheckString()
       {
           Scanner sc = new Scanner(System.in);
           System.out.println("Nhap chuoi x: ");
           String x = sc.nextLine();
           System.out.println("Nhap chuoi y: ");
           String y = sc.nextLine();
           System.out.println("Chieu dai cua chuoi la: " + x.length());

           System.out.println("3 ki tu dau tien cua chuoi x: " + x.substring(0, Math.min(x.length(),3)));

           System.out.println("3 ki tu cuoi cua chuoi x: " + x.substring( Math.max(x.length()-3,0 )));

           if (x.length() >= 6) {
               System.out.println("Ki tu thu 6 của chuoi x: " + x.charAt(5));
           } else {
               System.out.println("Chuoi x khong du ki tu de lay ki tu thu 6");
           }

           String z = x.substring(0, Math.min(x.length(),3)) + y.substring( Math.max(y.length()-3,0 ));
           System.out.println("Chuoi moi: " + z);

           if (x.equals(y)) {
               System.out.println("2 chuoi x va y bang nhau (phan biet chu hoa , thuong)");
           } else {
               System.out.println("2 chuoi x va y khong bang nhau (phan biet chu hoa , thuong)");
           }

           if (x.equalsIgnoreCase(y)) {
               System.out.println("2 chuoi x va y bang nhau ( khong phan biet chu hoa , thuong)");
           } else {
               System.out.println("2 chuoi x va y khong bang nhau ( khong phan biet chu hoa , thuong)");
           }

           int vitri = x.indexOf(y);
           if(vitri == -1 )
           {
               System.out.println("Khong tim thay chuoi y trong chuoi x");
           }
           else
           {
               System.out.println("Tim thay chuoi y trong chuoi x tai vi tri : " + vitri);
           }

           int vitri2 = 0;
           while (vitri2 < x.length() && (vitri2 = x.indexOf(y, vitri2)) != -1) {
               System.out.println("Chuoi y xuat hien trong chuoi x tai vi tri: " + vitri2);
               vitri2++;
           }
       }
}
