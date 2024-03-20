package BTTL;

import java.util.Scanner;

public class Bai3
{
    public static void main(String[] args)
    {
        PhanSo();
    }
    public static void PhanSo()
    {
        class PhanSo
        {
            private int ts;
            private int ms;

            public PhanSo()
            {
                ts = 0;
                ms = 1;
            }
            public PhanSo NhapPhanSo()
            {
                PhanSo ps = new PhanSo();
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap tu so: ");
                ps.ts = sc.nextInt();
                System.out.println("Nhap mau so: ");
                ps.ms = sc.nextInt();
                return ps;
            }
            public void XuatPhanSo() {
                System.out.println(ts + "/" + ms);
            }

            public PhanSo Cong(PhanSo other)
            {
                PhanSo kq =  new PhanSo();
                kq.ts = ts*other.ms + ms*other.ts;
                kq.ms = ms*other.ms;
                return kq;
            }
            public PhanSo Tru(PhanSo other)
            {
                PhanSo kq =  new PhanSo();
                kq.ts = ts*other.ms - ms*other.ts;
                kq.ms = ms*other.ms;
                return kq;
            }
            public PhanSo Nhan(PhanSo other)
            {
                PhanSo kq =  new PhanSo();
                kq.ts = ts*other.ts;
                kq.ms = ms*other.ms;
                return kq;
            }
            public PhanSo Chia(PhanSo other)
            {
                PhanSo kq =  new PhanSo();
                kq.ts = ts*other.ms;
                kq.ms = ms*other.ts;
                return kq;
            }

        }

        System.out.println("Nhap phan so thu nhat");
        PhanSo ps1 = new PhanSo().NhapPhanSo();
        System.out.println("Nhap phan so thu hai");
        PhanSo ps2 = new PhanSo().NhapPhanSo();
        PhanSo Tong = ps1.Cong(ps2);
        PhanSo Hieu = ps1.Tru(ps2);
        PhanSo Tich = ps1.Nhan(ps2);
        PhanSo Thuong = ps1.Chia(ps2);
        System.out.println("Tong 2 phan so la: ");
        Tong.XuatPhanSo();
        System.out.println("Hieu 2 phan so la: ");
        Hieu.XuatPhanSo();
        System.out.println("Tich 2 phan so la: ");
        Tich.XuatPhanSo();
        System.out.println("Thuong 2 phan so la: ");
        Thuong.XuatPhanSo();
    }
}