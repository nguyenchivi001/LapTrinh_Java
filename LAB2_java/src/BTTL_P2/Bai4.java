package BTTL_P2;
import java.util.*;

abstract class Xe
{
    protected double xang;
    protected double khoiLuongHang;

    public Xe(double xang)
    {
        this.xang = xang;
        this.khoiLuongHang = 0;
    }

    public void ThemHang(double khoiLuongThem)
    {
        this.khoiLuongHang += khoiLuongThem;
    }

    public void BotHang(double khoiLuongBot)
    {
        if (this.khoiLuongHang >= khoiLuongBot)
        {
            this.khoiLuongHang -= khoiLuongBot;
        }
        else
        {
            System.out.println("Khong du hang de bot");
        }
    }

    public void DoXang(double xangThem)
    {
        this.xang += xangThem;
    }

    protected double TinhLuongXangTieuThu(double quangDuong)
    {
        return 0;
    }
    public void ChoXeChay(double quangDuong)
    {
        if(xang > 0)
        {
            double xangTieuThu = TinhLuongXangTieuThu(quangDuong);
            if(xang >= xangTieuThu)
            {
                xang -= xangTieuThu;
                System.out.println("Xe da chay " + quangDuong + "Km");
            }
            else
            {
                System.out.println("Xe khong du xang de chay quang duong nay!");
            }
        }
        else
        {
            System.out.println("Xe da het xang");
        }
    }
    public double getXang()
    {
        return xang;
    }
    public boolean DaHetXang()
    {
        return xang <= 0;
    }

}

class XeMay extends Xe
{
    private double XangTieuThuKm = 2;
    private double XangTieuThuKg = 0.1;
    public XeMay(double xang)
    {
        super(xang);
    }

    protected double TinhLuongXangTieuThu(double quangDuong)
    {
        return (quangDuong / 100) * XangTieuThuKm + (khoiLuongHang/10) * XangTieuThuKg;
    }
}

class XeTai extends Xe
{
    private double XangTieuThuKm = 20;
    private double XangTieuThuKg = 1;
    public XeTai(double xang)
    {
        super(xang);
    }

    protected double TinhLuongXangTieuThu(double quangDuong)
    {
        return (quangDuong / 100) * XangTieuThuKm + (khoiLuongHang/100) * XangTieuThuKg;
    }
}
public class Bai4
{
    public static void main(String[] args)
    {
        XeMay xeMay = new XeMay(20);

        xeMay.ThemHang(20);

        xeMay.BotHang(10);

        xeMay.ChoXeChay(30);

        xeMay.DoXang(10);

        System.out.println("Xang con lai trong xe may: " + xeMay.getXang() + " lit");


        if(xeMay.DaHetXang())
        {
            System.out.println("Xe may da het xang!");
        }
        else
        {
            System.out.println("Xe may chua het xang!");
        }

        XeTai xeTai = new XeTai(50);

        xeTai.ThemHang(300);

        xeTai.BotHang(50);

        xeTai.ChoXeChay(1000);

        xeTai.DoXang(200);

        System.out.println("Xăng còn lại trong xe tải: " + xeTai.getXang() + " lit");

        if(xeTai.DaHetXang())
        {
            System.out.println("Xe tai da het xang!");
        }
        else
        {
            System.out.println("Xe tai chua het xang!");
        }
    }
}
