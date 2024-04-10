package BTVN;
import java.util.*;
class KhachHang
{
    protected String maKhachHang;
    protected String tenKhachHang;
    protected String ngayHoaDon;
    protected double soLuongDien;
    protected double donGia;
    public KhachHang()
    {
        this.maKhachHang = "";
        this.tenKhachHang = "";
        this.ngayHoaDon = "";
        this.soLuongDien = 0;
        this.donGia = 0;
    }

    public KhachHang(String maKhachHang, String tenKhachHang, String ngayHoaDon, double soLuongDien, double donGia)
    {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngayHoaDon = ngayHoaDon;
        this.soLuongDien = soLuongDien;
        this.donGia = donGia;
    }

    public double TinhThanhTien()
    {
        return 0;
    }
    public void InThongTin() {
        // In thông tin chung của khách hàng
        System.out.println("Ma khach hang: " + maKhachHang);
        System.out.println("Ten khach hang: " + tenKhachHang);
        System.out.println("Ngay hoa don: " + ngayHoaDon);
        System.out.println("So luong dien: " + soLuongDien);
        System.out.println("Don gia: " + donGia);
    }
}

class KhachHangSinhHoat extends KhachHang
{
    private double dinhMuc;

    public KhachHangSinhHoat()
    {
        super();
        this.dinhMuc = 0;
    }

    public KhachHangSinhHoat(String maKhachHang, String tenKhachHang, String ngayHoaDon, double soLuongDien, double donGia, double dinhMuc)
    {
        super(maKhachHang, tenKhachHang, ngayHoaDon, soLuongDien, donGia);
        this.dinhMuc = dinhMuc;
    }

    public double TinhThanhTien()
    {
        if (soLuongDien <= dinhMuc)
        {
            return soLuongDien * donGia;
        }
        else
        {
            return soLuongDien * donGia + (soLuongDien - dinhMuc) * donGia * 2;
        }
    }
    public void InThongTin()
    {
        super.InThongTin();
        System.out.println("Loai khach hang: Sinh hoat");
        System.out.println("Dinh muc: " + dinhMuc);
        System.out.println("Thành tiền: " + TinhThanhTien());
    }
}

class KhachHangKinhDoanh extends KhachHang
{
    public KhachHangKinhDoanh()
    {
        super();
    }
    public KhachHangKinhDoanh(String maKhachHang, String tenKhachHang, String ngayHoaDon, double soLuongDien, double donGia)
    {
        super(maKhachHang, tenKhachHang, ngayHoaDon, soLuongDien, donGia);
    }
    public double TinhThanhTien()
    {
        if (soLuongDien > 400)
        {
            return soLuongDien * donGia * 1.05;
        }
        else
        {
            return soLuongDien * donGia;
        }
    }
    public void InThongTin() {
        super.InThongTin();
        System.out.println("Loai khach hang: Kinh doanh");
        System.out.println("So luong dien: " + soLuongDien);
        System.out.println("Thanh tien: " + TinhThanhTien());
    }
}

class KhachHangSanXuat extends KhachHang
{
    private String loaiDien;
    public KhachHangSanXuat()
    {
        super();
        loaiDien = "";
    }
    public KhachHangSanXuat(String maKhachHang, String tenKhachHang, String ngayHoaDon, double soLuongDien, double donGia, String loadDien)
    {
        super(maKhachHang, tenKhachHang, ngayHoaDon, soLuongDien, donGia);
        this.loaiDien = loadDien;
    }
    public double tinhThanhTien()
    {
        double thanhTien = soLuongDien * donGia;
        if (loaiDien.equals("2 pha"))
        {
            if (soLuongDien > 200)
            {
                thanhTien *= 0.98;
            }
        }
        else if (loaiDien.equals("3 pha"))
        {
            if (soLuongDien > 150)
            {
                thanhTien *= 0.97;
            }
        }
        return thanhTien;
    }
    public void InThongTin()
    {
        super.InThongTin();
        System.out.println("Loai khach hang: San xuat");
        System.out.println("Loai dien: " + loaiDien);
        System.out.println("Số lượng điện: " + soLuongDien);
        System.out.println("Thanh tien: " + tinhThanhTien());
    }
}

public class Bai1
{
    private static Scanner scanner = new Scanner(System.in);
    public static ArrayList<KhachHang> nhapKhachHang()
    {
        ArrayList<KhachHang> danhSachKhachHang = new ArrayList<>();
        System.out.println("Nhap danh sach khach hang!");
        while (true)
        {
            System.out.println("Nhap ma khach hang (nhap rong de ket thuc) : ");
            String maKhachHang = scanner.nextLine();
            if (maKhachHang.isEmpty()) {
                break;
            }
            System.out.println("Loai khach hang (sinh hoat / kinh doanh / san xuat): ");
            String loaiKhachHang = scanner.nextLine();

            System.out.println("Nhap ten khach hang: ");
            String tenKhachHang = scanner.nextLine();

            System.out.println("Nhap ngay hoa don: ");
            String ngayHoaDon = scanner.nextLine();

            System.out.println("Nhap so luong dien: ");
            double soLuongDien = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Nhap don gia: ");
            double donGia = scanner.nextDouble();

            if (loaiKhachHang.equalsIgnoreCase("sinh hoat"))
            {
                System.out.println("Nhap dinh muc: ");
                double dinhMuc = scanner.nextDouble();
                KhachHangSinhHoat khachHangSinhHoat = new KhachHangSinhHoat(maKhachHang, tenKhachHang, ngayHoaDon, soLuongDien, donGia, dinhMuc);
                danhSachKhachHang.add(khachHangSinhHoat);
            }
            else if (loaiKhachHang.equalsIgnoreCase("kinh doanh"))
            {
                KhachHangKinhDoanh khachHangKinhDoanh = new KhachHangKinhDoanh(maKhachHang, tenKhachHang, ngayHoaDon, soLuongDien, donGia);
                danhSachKhachHang.add(khachHangKinhDoanh);
            }
            else if (loaiKhachHang.equalsIgnoreCase("san xuat"))
            {
                System.out.println("Nhap loai dien (2 pha / 3 pha): ");
                String loaiDien = scanner.nextLine();
                KhachHangSanXuat khachHangSanXuat = new KhachHangSanXuat(maKhachHang, tenKhachHang, ngayHoaDon, soLuongDien, donGia, loaiDien);
                danhSachKhachHang.add(khachHangSanXuat);
            }
            scanner.nextLine();
        }
        return danhSachKhachHang;
    }
    public static void main(String[] args)
    {
        ArrayList<KhachHang> danhSachKhachHang = nhapKhachHang();

        System.out.println("Nhap thang va nam hoa don (vd: 04/2022): ");
        String thangNamHoaDon = scanner.nextLine();

        System.out.println("Danh sach hoa don tien dien trong thang " + thangNamHoaDon + ":");
        for (KhachHang khachHang : danhSachKhachHang)
        {
            if (khachHang.ngayHoaDon.startsWith(thangNamHoaDon))
            {
                khachHang.InThongTin();
            }
        }
    }
}
