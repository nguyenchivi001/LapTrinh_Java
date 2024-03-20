package BTTL;
import java.util.Scanner;
import BTTL.Bai1;
import BTTL.Bai2;
import BTTL.Bai3;
import BTTL.Bai4;
import BTTL.Bai5;
public class Bai6
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int chon;
        do {
            System.out.println("##################################");
            System.out.println("1. Bài 1");
            System.out.println("2. Bài 2");
            System.out.println("3. Bài 3");
            System.out.println("4. Bài 4");
            System.out.println("5. Bài 5");
            System.out.println("6. Thoát");
            System.out.println("##################################");
            System.out.print("Chọn chức năng: ");
            chon = scanner.nextInt();

            switch (chon) {
                case 1:
                    Bai1.TinhChuVi();
                    break;
                case 2:
                    Bai2.DivideAndPrint();
                    break;
                case 3:
                    Bai3.PhanSo();
                    break;
                case 4:
                    Bai4.CheckString();
                    break;
                case 5:
                    Bai5.TinhTienDien();
                    break;
                case 6:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Chọn không hợp lệ. Hãy chọn lại.");
            }
        } while (chon != 6);

        scanner.close();
    }
}
