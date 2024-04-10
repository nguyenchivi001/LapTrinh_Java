package BTTL_P2;
import java.util.Scanner;
import java.util.ArrayList;

abstract class ChuyenXe
{
    private String maSoChuyen;
    private String hoTenTaiXe;
    private String soXe;
    private double khoiLuongHangHoa;
    private double doanhThu;

    public ChuyenXe(String maSoChuyen, String hoTenTaiXe, String soXe, double khoiLuongHangHoa, double doanhThu)
    {
        this.maSoChuyen = maSoChuyen;
        this.hoTenTaiXe = hoTenTaiXe;
        this.soXe = soXe;
        this.khoiLuongHangHoa = khoiLuongHangHoa;
        this.doanhThu = doanhThu;
    }

    public String getMaSoChuyen()
    {
        return maSoChuyen;
    }

    public void setMaSoChuyen(String maSoChuyen)
    {
        this.maSoChuyen = maSoChuyen;
    }

    public String getHoTenTaiXe()
    {
        return hoTenTaiXe;
    }

    public void setHoTenTaiXe(String hoTenTaiXe)
    {
        this.hoTenTaiXe = hoTenTaiXe;
    }

    public String getSoXe()
    {
        return soXe;
    }

    public void setSoXe(String soXe)
    {
        this.soXe = soXe;
    }
    public double getKhoiLuongHangHoa()
    {
        return khoiLuongHangHoa;
    }
    public void setKhoiLuongHangHoa(double khoiLuongHangHoa)
    {
        this.khoiLuongHangHoa = khoiLuongHangHoa;
    }
    public double getDoanhThu()
    {
        return doanhThu;
    }
    public void setDoanhThu(double doanhThu)
    {
        this.doanhThu = doanhThu;
    }

    public void inThongTin()
    {
        System.out.println("Ma so chuyen: " + maSoChuyen);
        System.out.println("Ho ten tai xe: " + hoTenTaiXe);
        System.out.println("So xe: " + soXe);
        System.out.println("Khoi luong hang hoa: " + khoiLuongHangHoa);
        System.out.println("Doanh thu: " + doanhThu);
    }

}

class ChuyenXeNoiThanh extends ChuyenXe
{
    private double quangDuongDi;

    public ChuyenXeNoiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, double khoiLuongHangHoa, double quangDuongDi, double doanhThu)
    {
        super(maSoChuyen, hoTenTaiXe, soXe, khoiLuongHangHoa, doanhThu);
        this.quangDuongDi = quangDuongDi;
    }
    public double getQuangDuongDi()
    {
        return quangDuongDi;
    }
    public void setQuangDuongDi(double quangDuongDi)
    {
        this.quangDuongDi = quangDuongDi;
    }
    public void inThongTin()
    {
        super.inThongTin();
        System.out.println("Quang duong di: " + quangDuongDi);
    }
}

class ChuyenXeNgoaiThanh extends ChuyenXe
{
    private String noiDen;
    private double soNgayVanChuyen;

    public ChuyenXeNgoaiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, double khoiLuongHangHoa, String noiDen, double soNgayVanChuyen, double doanhThu)
    {
        super(maSoChuyen, hoTenTaiXe, soXe, khoiLuongHangHoa, doanhThu);
        this.noiDen = noiDen;
        this.soNgayVanChuyen = soNgayVanChuyen;
    }
    public String getNoiDen()
    {
        return noiDen;
    }
    public void setNoiDen(String noiDen)
    {
        this.noiDen = noiDen;
    }
    public double getSoNgayVanChuyen()
    {
        return soNgayVanChuyen;
    }
    public void setSoNgayVanChuyen(double soNgayVanChuyen)
    {
        this.soNgayVanChuyen = soNgayVanChuyen;
    }
    public void inThongTin()
    {
        super.inThongTin();
        System.out.println("Noi den: " + noiDen);
        System.out.println("So ngay van chuyen: " + soNgayVanChuyen);
    }
}


public class Bai2
{

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        ArrayList<ChuyenXe> danhSachChuyenXe = new ArrayList<>();
        NhapDanhSachChuyenXe(s, danhSachChuyenXe);

        System.out.println("Danh sach chuyen xe: ");
        for (int i = 0; i < danhSachChuyenXe.size(); i++) {
            danhSachChuyenXe.get(i).inThongTin();
            System.out.println();
        }

        double tongDoanhThuNoiThanh = 0;
        double tongDoanhThuNgoaiThanh = 0;
        for (int i = 0; i < danhSachChuyenXe.size(); i++) {
            if (danhSachChuyenXe.get(i) instanceof ChuyenXeNgoaiThanh) {
                tongDoanhThuNgoaiThanh += danhSachChuyenXe.get(i).getDoanhThu();
            } else {
                tongDoanhThuNoiThanh += danhSachChuyenXe.get(i).getDoanhThu();
            }
        }
        System.out.println("Tong doanh thu chuyen noi thanh: " + tongDoanhThuNoiThanh);
        System.out.println("Tong doanh thu chuyen ngoai thanh: " + tongDoanhThuNgoaiThanh);

        int IndexXeNoiThanh = -1;
        int IndexXeNgoaiThanh = -1;
        for (int i = 0; i < danhSachChuyenXe.size(); i++) {
            if (danhSachChuyenXe.get(i) instanceof ChuyenXeNoiThanh) {
                if (IndexXeNoiThanh == -1 || (danhSachChuyenXe.get(i).getDoanhThu() > danhSachChuyenXe.get(IndexXeNoiThanh).getDoanhThu())) {
                    IndexXeNoiThanh = i;
                }
            } else if (danhSachChuyenXe.get(i) instanceof ChuyenXeNgoaiThanh) {
                if (IndexXeNgoaiThanh == -1 || (danhSachChuyenXe.get(i).getDoanhThu() > danhSachChuyenXe.get(IndexXeNgoaiThanh).getDoanhThu())) {
                    IndexXeNgoaiThanh = i;
                }
            }
        }
        if (IndexXeNoiThanh != -1) {
            System.out.println("Chuyen xe noi thanh co doanh thu cao nhat: ");
            danhSachChuyenXe.get(IndexXeNoiThanh).inThongTin();
        }
        if (IndexXeNgoaiThanh != -1) {
            System.out.println("Chuyen xe ngoai thanh co doanh thu cao nhat: ");
            danhSachChuyenXe.get(IndexXeNgoaiThanh).inThongTin();
        }
    }
    private static void NhapDanhSachChuyenXe(Scanner s, ArrayList<ChuyenXe> danhSachChuyenXe)
    {
        boolean tieptuc = false;
        while (true)
        {
            System.out.println("Chon loai chuyen xe (1. Noi thanh / 2. Ngoai thanh / 0. Ket thuc):");
            int choose = s.nextInt();
            s.nextLine();
            switch(choose)
            {
                case 0:
                    System.out.println("Ket thuc nhap danh sach chuyen xe.");
                    tieptuc = true;
                    break;
                case 1:
                    System.out.println("Nhap thong tin chuyen xe noi thanh:");
                    System.out.print("Ma so chuyen: ");
                    String maSo1 = s.nextLine();
                    System.out.print("Ho ten tai xe: ");
                    String hoTenTaiXe1 = s.nextLine();
                    System.out.print("So xe: ");
                    String soXe1 = s.nextLine();
                    System.out.print("Khoi luong hang hoa: ");
                    double khoiLuongHangHoa1 = s.nextDouble();
                    s.nextLine();
                    System.out.print("Quang duong di: ");
                    double quangDuongDi = s.nextDouble();
                    System.out.print("Doanh thu: ");
                    double doanhThu1 = s.nextDouble();
                    s.nextLine();

                    danhSachChuyenXe.add(new ChuyenXeNoiThanh(maSo1, hoTenTaiXe1, soXe1, khoiLuongHangHoa1, quangDuongDi, doanhThu1));
                    break;
                case 2:
                    System.out.println("Nhap thong tin chuyen xe ngoai thanh:");
                    System.out.print("Ma so chuyen: ");
                    String maSo2 = s.nextLine();
                    System.out.print("Ho ten tai xe: ");
                    String hoTenTaiXe2 = s.nextLine();
                    System.out.print("So xe: ");
                    String soXe2 = s.nextLine();
                    System.out.print("Khoi luong hang hoa: ");
                    double khoiLuongHangHoa2 = s.nextDouble();
                    s.nextLine();
                    System.out.print("Noi den: ");
                    String noiDen = s.nextLine();
                    System.out.print("So ngay van chuyen: ");
                    double soNgayVanChuyen = s.nextDouble();
                    System.out.print("Doanh thu: ");
                    double doanhThu2 = s.nextDouble();
                    s.nextLine();

                    danhSachChuyenXe.add(new ChuyenXeNgoaiThanh(maSo2, hoTenTaiXe2, soXe2, khoiLuongHangHoa2, noiDen, soNgayVanChuyen, doanhThu2));
                    break;
                default:
                    System.out.println("Chon chuyen xe khong hop le.Vui long chon lai!");
                    break;
            }
            if (tieptuc) {
                break;
            }
        }
    }
}