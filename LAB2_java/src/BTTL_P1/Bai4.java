package BTTL_P1;
import java.util.ArrayList;
import java.util.Scanner;

class Xe
{
    private String tenChuXe;
    private String loaiXe;
    private int triGiaXe;
    private int dungTichXyLanh;

    public Xe(String tenChuXe, String loaiXe, int triGiaXe, int dungTichXyLanh)
    {
        this.tenChuXe = tenChuXe;
        this.loaiXe = loaiXe;
        this.triGiaXe = triGiaXe;
        this.dungTichXyLanh = dungTichXyLanh;
    }
    public String GetTenChuXe() {
        return tenChuXe;
    }

    public void SetTenChuXe(String tenChuXe) {
        this.tenChuXe = tenChuXe;
    }

    public String GetLoaiXe() {
        return loaiXe;
    }

    public void SetLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public int GetTriGiaXe() {
        return triGiaXe;
    }

    public void SetTriGiaXe(int triGiaXe) {
        this.triGiaXe = triGiaXe;
    }

    public int GetDungTichXyLanh() {
        return dungTichXyLanh;
    }

    public void SetDungTichXyLanh(int dungTichXyLanh) {
        this.dungTichXyLanh = dungTichXyLanh;
    }
    public double TinhThue() {
        double thue;
        if (dungTichXyLanh < 100) {
            thue = triGiaXe * 0.01;
        } else if (dungTichXyLanh >= 100 && dungTichXyLanh <= 175) {
            thue = triGiaXe * 0.03;
        } else {
            thue = triGiaXe * 0.05;
        }
        return thue;
    }

    public String toString()
    {
        return "Ten chu xe: " + tenChuXe + ", Loai xe: " + loaiXe + ", Tri gia xe: " + triGiaXe + ", Dung tich xy lanh: " + dungTichXyLanh + ", Thue phai dong: " + TinhThue();
    }
}

public class Bai4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Xe> danhSachXe= new ArrayList<>();
        System.out.println("Nhap thong tin xe (nhap ten chu xe rong de ket thuc): ");
        while (true)
        {
            System.out.print("Nhap ten chu xe: ");
            String tenChuXe = sc.nextLine();
            if (tenChuXe.isEmpty())
            {
                break;
            }
            System.out.print("Nhap loai xe: ");
            String loaiXe = sc.nextLine();
            System.out.print("Nhap tri gia xe: ");
            int triGiaXe = sc.nextInt();
            System.out.print("Nhap dung tich xy lanh: ");
            int dungTichXyLanh = sc.nextInt();

            sc.nextLine();

            danhSachXe.add(new Xe(tenChuXe, loaiXe, triGiaXe, dungTichXyLanh));
        }
        System.out.println("Bang ke khai tien thue phai dong cua cac xe trong danh sach:");
        for (int i=0; i< danhSachXe.size(); i++)
        {
            System.out.println(danhSachXe.get(i));
        }

    }
}
