package BaiTapVeNha;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberExercise {

    public static ArrayList<Integer> EnterData(ArrayList<Integer> numbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
            numbers.add(scanner.nextInt());
        }
        return numbers;
    }

    public static void printData(ArrayList<Integer> numbers) {
        System.out.println("phan tu: " + numbers);
    }

    public static Integer findMax2(ArrayList<Integer> arrays) {
        if (arrays.size() < 2) {
            System.out.println("Mang phai co it nhat 2 phan tu.");
            return null;
        }

        int max1 = Math.max(arrays.get(0), arrays.get(1));
        int max2 = Math.min(arrays.get(0), arrays.get(1));

        for (int i = 2; i < arrays.size(); i++) {
            if (arrays.get(i) > max1) {
                max2 = max1;
                max1 = arrays.get(i);
            } else if (arrays.get(i) > max2 && arrays.get(i) != max1) {
                max2 = arrays.get(i);
            }
        }

        if (max1 == max2) {
            System.out.println("Mang khong co phan tu lon thu 2.");
            return null;
        }

        return max2;
    }

    public static ArrayList<Integer> deleteOddNumber(ArrayList<Integer> arrays) {
        ArrayList<Integer> newArray = new ArrayList<>();

        for (int number : arrays) {
            if (number % 2 == 0) {
                newArray.add(number);
            }
        }

        return newArray;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("Menu: ");
            System.out.println("1. Nhap du lieu");
            System.out.println("2. Xuat du lieu");
            System.out.println("3. Tim phan tu lon thu 2");
            System.out.println("4. Xoa cac phan tu le");
            System.out.println("0. Thoat");
            System.out.println();
            System.out.print("Nhap lua chon cua ban: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    numbers = EnterData(numbers);
                    break;
                case 2:
                    printData(numbers);
                    break;
                case 3:
                    Integer max2 = findMax2(numbers);
                    if (max2 != null) {
                        System.out.println("Phan tu lon thu 2 la: " + max2);
                    }
                    break;
                case 4:
                    numbers = deleteOddNumber(numbers);
                    System.out.println("Cac phan tu sau khi xoa phan tu le: " + numbers);
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai.");
                    break;
            }

        } while (choice != 0);
    }
}
