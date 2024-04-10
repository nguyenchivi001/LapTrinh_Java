import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

abstract class HangHoa
{
    private String maHang;
    private String tenHang;
    private int tonKho;
    private double donGia;
    public HangHoa()
    {
        maHang = "";
        tenHang = "";
        tonKho = 0;
        donGia = 0;
    }
    public HangHoa(String maHang, String tenHang, int tonKho, double donGia)
    {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.tonKho = tonKho;
        this.donGia = donGia;
    }
    public void printInformation()
    {
        System.out.println("Ma hang: " + maHang);
        System.out.println("Ten hang: " + tenHang);
        System.out.println("Ton kho: " + tonKho);
        System.out.println("Don gia: " + donGia);
    }
    public double getDonGia()
    {
        return donGia;
    }
    public int getTonKho()
    {
        return tonKho;
    }
    public String getMaHang()
    {
        return maHang;
    }
    public String getTenHang()
    {
        return tenHang;
    }
    public abstract double thanhTien(int sl);
    public abstract String danhGia();
}

class DienMay extends HangHoa
{
    private String thuongHieu;
    private String loaiMay;
    private int baoHanh;
    public DienMay()
    {
        super();
        thuongHieu = "";
        loaiMay = "";
        baoHanh = 0;
    }
    public DienMay(String maHang, String tenHang, int tonKho, double donGia, String thuongHieu, String loaiMay, int baoHanh)
    {
        super(maHang, tenHang, tonKho, donGia);
        this.thuongHieu = thuongHieu;
        this.baoHanh = baoHanh;
        this.loaiMay = loaiMay;
    }
    public void printInformation()
    {
        super.printInformation();
        System.out.println("Thuong hieu: " + thuongHieu);
        System.out.println("Loai may: " + loaiMay);
        System.out.println("Thoi gian bao hanh: " + baoHanh);
        System.out.println("Danh gia: " + danhGia());
    }
    public String getThuongHieu()
    {
        return thuongHieu;
    }
    public String getLoaiMay()
    {
        return loaiMay;
    }
    @Override
    public double thanhTien(int sl)
    {
        return sl*getDonGia()*1.1;
    }
    @Override
    public String danhGia()
    {
        if (getTonKho() < 3) {
            return "Ban duoc";
        }
        return "";
    }
}

class ThucPham extends HangHoa
{
    private String ngaySX;
    private String ngayHH;
    private String nhaCungCap;
    public ThucPham()
    {
        super();
        ngaySX = "";
        ngayHH = "";
        nhaCungCap = "";
    }
    public ThucPham(String maHang, String tenHang, int tonKho, double donGia, String ngaySX, String ngayHH, String nhaCungCap)
    {
        super(maHang, tenHang, tonKho, donGia);
        this.ngaySX = ngaySX;
        this.ngayHH = ngayHH;
        this.nhaCungCap = nhaCungCap;
    }
    public void printInformation()
    {
        super.printInformation();
        System.out.println("Ngay san xuat: " + ngaySX);
        System.out.println("Ngay het hang: " + ngayHH);
        System.out.println("Nha cung cap: " + nhaCungCap);
        System.out.println("Danh gia: " + danhGia());
    }
    public boolean quaHSD()
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            return formatter.parse(ngayHH).before(date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public double thanhTien(int sl)
    {
        return getDonGia()*sl*1.05;
    }
    @Override
    public String danhGia()
    {
        if ((getTonKho() > 2) && (quaHSD()))
        {
            return "Kho ban";
        }
        return "";
    }
}

class GiaDung extends HangHoa
{
    private String nhaSX;
    private String ngayNhap;
    private String loai;
    public GiaDung()
    {
        super();
        nhaSX = "";
        ngayNhap = "";
        loai = "";
    }
    public GiaDung(String maHang, String tenHang, int tonKho, double donGia, String nhaSX, String ngayNhap, String loai)
    {
        super(maHang, tenHang, tonKho, donGia);
        this.nhaSX = nhaSX;
        this.ngayNhap = ngayNhap;
        this.loai = loai;
    }
    public void printInformation()
    {
        super.printInformation();
        System.out.println("Nha san xuat " + nhaSX);
        System.out.println("Ngay nhap: " + ngayNhap);
        System.out.println("Loai: " + loai);
        System.out.println("Danh gia: " + danhGia());
    }
    public int tgLuuKho()
    {
        Date currentDate = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date ngayNhapDate = null;
        try
        {
            ngayNhapDate = formatter.parse(ngayNhap);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        long diffInMillis = currentDate.getTime() - ngayNhapDate.getTime();
        int diffInDays = (int) (diffInMillis / (1000 * 60 * 60 * 24));
        return diffInDays;
    }
    @Override
    public double thanhTien(int sl)
    {
        return sl*getDonGia()*1.1;
    }
    @Override
    public String danhGia()
    {
        if ((getTonKho() > 10) && (tgLuuKho() > 20))
        {
            return "Ban cham";
        }
        return "";
    }
}

class XuLy
{
    public static void nhap(ArrayList<HangHoa> danhSachHangHoa)
    {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.print("Nhap ma hang (Nhap rong de ket thuc): ");
            String maHang = scanner.nextLine();
            if (maHang.isEmpty()) break;

            boolean daTonTai = false;
            for (HangHoa hangHoa : danhSachHangHoa)
            {
                if (hangHoa.getMaHang().equals(maHang))
                {
                    System.out.println("Ma hang da ton tai!");
                    daTonTai = true;
                    break;
                }
            }
            if (!daTonTai)
            {
                HangHoa hangHoa;
                System.out.print("Nhap ten hang: ");
                String tenHang = scanner.nextLine();
                System.out.print("Nhap so luong ton kho: ");
                int tonKho = scanner.nextInt();
                System.out.print("Nhap don gia: ");
                double donGia = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Nhap loai hang (dien may: d, thuc pham: t, gia dung: g): ");
                String type = scanner.nextLine();
                if (type.equals("d"))
                {
                    System.out.print("Nhap thuong hieu: ");
                    String thuongHieu = scanner.nextLine();
                    System.out.print("Nhap loai may: ");
                    String loaiMay = scanner.nextLine();
                    System.out.print("Nhap thoi gian bao hanh: ");
                    int baoHanh = scanner.nextInt();
                    hangHoa = new DienMay(maHang, tenHang, tonKho, donGia, thuongHieu, loaiMay, baoHanh);
                }
                else if (type.equals("t"))
                {
                    System.out.print("Nhap ngay san xuat: ");
                    String ngaySX = scanner.nextLine();
                    System.out.print("Nhap ngay het han: ");
                    String ngayHH = scanner.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.print("Nhap nha cung cap: ");
                    String nhaCungCap = scanner.nextLine();
                    try
                    {
                        if (formatter.parse(ngayHH).before(formatter.parse(ngaySX)))
                        {
                            System.out.println("Han su dung phai sau ngay san xuat.");
                            continue;
                        }
                    }
                    catch (ParseException e)
                    {
                        e.printStackTrace();
                    }
                    hangHoa = new ThucPham(maHang, tenHang, tonKho, donGia, ngaySX, ngayHH, nhaCungCap);
                }
                else if (type.equals("g"))
                {
                    System.out.print("Nhap nha san xuat: ");
                    String nhaSX = scanner.nextLine();
                    System.out.print("Nhap ngay nhap vao sieu thi: ");
                    String ngayNhap = scanner.nextLine();
                    System.out.print("Nhap loai: ");
                    String loai = scanner.nextLine();
                    hangHoa = new GiaDung(maHang, tenHang, tonKho, donGia, nhaSX, ngayNhap, loai);
                }
                else
                {
                    System.out.println("Nhap sai cu phap");
                    continue;
                }
                danhSachHangHoa.add(hangHoa);
                System.out.println("Them thanh cong hang hoa!");
                scanner.nextLine();
            }
        }
    }
    public static void xuat(ArrayList<HangHoa> danhSachHangHoa)
    {
        for (HangHoa hang : danhSachHangHoa)
        {
            System.out.println("Ma hang: " + hang.getMaHang());
            System.out.println("Ten hang: " + hang.getTenHang());
            System.out.println("So luong ton: " + hang.getTonKho());
            System.out.println("Danh gia: " + hang.danhGia());
            System.out.println("-------------------");
        }

    }
    public static void findDienMayBanDuoc(ArrayList<HangHoa> danhSachHangHoa)
    {
        for (HangHoa hang : danhSachHangHoa)
        {
            if (hang instanceof DienMay) {
                DienMay dm = (DienMay) hang;
                if (dm.danhGia().equals("Ban duoc"))
                {
                    System.out.println("Thuong hieu: " + dm.getThuongHieu());
                    System.out.println("Ten hang: " + dm.getTenHang());
                    System.out.println("Loai hang: " + dm.getLoaiMay());
                }
            }
        }
    }
    public static void main(String[] args)
    {
        ArrayList<HangHoa> danhSachHangHoa = new ArrayList<>();
        nhap(danhSachHangHoa);
        xuat(danhSachHangHoa);
        findDienMayBanDuoc(danhSachHangHoa);
    }
}
