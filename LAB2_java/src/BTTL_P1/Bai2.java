package BTTL_P1;

import java.util.Scanner;

class HCN
{
    private double cd,cr;
    public HCN(double cd, double cr)
    {
        this.cd = cd;
        this.cr = cr;
    }
    public double getCd()
    {
        return cd;
    }
    public double getCr()
    {
        return cr;
    }
    public void setCd(double cd)
    {
        this.cd = cd;
    }
    public void setCr(double cr)
    {
        this.cr = cr;
    }
    public double TinhDienTich()
    {
        return cd*cr;
    }
    public double TinhChuVi()
    {
        return 2*(cd+cr);
    }
    public String toString()
    {
        return "Chieu dai: " + cd + ", Chieu rong: " + cr + ", Chu vi: " + TinhChuVi() + ", Dien tich: " + TinhDienTich();
    }
}

public class Bai2
{
    public static void main(String[] args)
    {
        HCN hcn = new HCN(4,6);
        System.out.print(hcn);
    }
}
