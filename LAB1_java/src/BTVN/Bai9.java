package BTVN;
import java.util.Scanner;
public class Bai9
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap chuoi:");
        String chuoi = scanner.nextLine();

        if (isPalindrome(chuoi)) {
            System.out.println("Chuoi \"" + chuoi + "\" la palindrome.");
        } else {
            System.out.println("Chuoi \"" + chuoi + "\" khong phai la palindrome.");
        }
    }
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
