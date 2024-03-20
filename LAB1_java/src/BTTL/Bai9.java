package BTTL;
import java.util.Scanner;
import java.util.Arrays;
public class Bai9
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so phan tu cua mang: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhap cac phan tu cua mang: ");
        for(int i = 0; i < n; i++)
        {
            System.out.printf("phan tu thu %d: ", i+1 );
            arr[i] = scanner.nextInt();
        }
        System.out.println("Xuat cac phan tu trong mang: " + Arrays.toString(arr));
        int max = arr[0];
        int min = arr[0];
        for(int i = 1; i < n; i++)
        {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        int x;
        System.out.println("Nhap vao so x can tim: ");
        x = scanner.nextInt();
        int vitri = -1;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == x)
            {
                vitri = i;
                break;
            }
        }
        if(vitri == -1) System.out.println(x + " khong co trong mang");
        else System.out.println(x + " co trong mang");
        System.out.println("Nhap vao so x can dem: ");
        x = scanner.nextInt();
        int dem = 0;
        for(int i=0; i < n; i++)
        {
            if(arr[i] == x)
                dem++;
        }
        System.out.println("co " + dem + " so " + x + " nam trong mang.");

        Arrays.sort(arr);
        System.out.println("Mảng sau khi sắp xếp tăng dần: " + Arrays.toString(arr));
    }
}
