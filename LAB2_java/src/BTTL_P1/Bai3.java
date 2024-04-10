package BTTL_P1;
import java.util.Scanner;

class SinhVien
{
    private String hoTen;
    private int mssv;
    private float diemLT , diemTH;

    public SinhVien()
    {
        this.hoTen = "";
        this.mssv = 0;
        this.diemLT = 0;
        this.diemTH = 0;
    }
    public SinhVien(String hoTen, int mssv, float diemLT, float diemTH)
    {
        this.hoTen = hoTen;
        this.mssv = mssv;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }
    public String GetHoTen()
    {
        return hoTen;
    }
    public void SetHoTen(String hoTen)
    {
        this.hoTen = hoTen;
    }
    public int Getmssv()
    {
        return mssv;
    }
    public void Setmssv(int mssv)
    {
        this.mssv = mssv;
    }
    public float GetdiemLT()
    {
        return diemLT;
    }
    public void SetdiemLT(float diemLT)
    {
        this.diemLT = diemLT;
    }
    public float GetdiemTH()
    {
        return diemTH;
    }
    public void SetdiemTH(float diemTH)
    {
        this.diemTH = diemTH;
    }
    public float TinhDiemTB() {
        return (diemLT + diemTH) / 2;
    }

    public String toString() {
        return "Ma SV: " + mssv + ", Ho ten: " + hoTen + ", Diem LT: " + diemLT + ", Diem TH: " + diemTH + ", Diem TB: " + TinhDiemTB();
    }
}

public class Bai3
{
    public static void main(String[] args)
    {
        SinhVien sv1 = new SinhVien("Vi", 22521656, 10, 10);
        SinhVien sv2 = new SinhVien("Sua", 22521267, 8, 7);
        SinhVien sv3 = new SinhVien("Tin", 22521482, 9, 8);

        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println(sv3);
    }
}
