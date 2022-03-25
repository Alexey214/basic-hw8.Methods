package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Задание №1:");
        sum1(2021);

        System.out.println("Задание №2:");
        sum2(2022, 1);                             //0 — iOS, 1 — Android

        System.out.println("Задание №3:");
        sum3(999);

        System.out.println("Задание №4:");
        sum4("asda");

        System.out.println("Задание №5:");
        sum5(new int[]{3, 2, 1, 6, 5});

        System.out.println("Задание №6:");
        int[] arr = generateRandomArray();
        averageMonthlyCalc(arr);
    }

    public static void sum1(int year) {
        //Scanner scanner = new Scanner(System.in);
        //int input = scanner.nextInt();
        //scanner.close();
        boolean leaYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;      //для сканнера заменить year на input(параметр метода удалить)
        if (leaYear) {
            System.out.println(year + " год является високосным");
        } else {
            System.out.println(year + " год не является високосным");
        }
    }

    public static void sum2(int clientDeviceYear, int clientOS) {
        int currentYear = LocalDate.now().getYear();
        if (clientOS == 1 && clientDeviceYear >= currentYear) {
            System.out.println("Установите версию приложения для Android по ссылке");
        } else if (clientOS == 1 && clientDeviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        } else if (clientOS == 0 && clientDeviceYear >= currentYear) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        } else if (clientOS == 0 && clientDeviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        } else {
            System.out.println("К сожалению для вашей ОС существует только web версия сервиса");
        }
    }

    public static void sum3(int deliveryDistance) {
        int distanceCount = 40;             // 20 - 1 день, далее от x до y, от x+40 до y+40 и т.д.
        double deliveryTime = Math.ceil((deliveryDistance - 19) / distanceCount);
        if (deliveryDistance < 20) {
            System.out.println("Потребуется дней: " + 1);
        } else {
            System.out.printf("Потребуется дней: %.0f\n", (deliveryTime + 1));
        }
    }

    public static void sum4(String sortString) {
        char[] chars = sortString.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < sortString.length() - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                System.out.println("В строке имеется дубль символа: " + chars[i]);
                break;
            }
        }
        System.out.println("Проверка 4го задания завершена");
    }

    public static void sum5(int[] arr) {
        int a, b;
        int count = arr.length - 1;
        int arrMid = (int) Math.floor(arr.length / 2);
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j <= arrMid; j++) {
            a = arr[j];
            b = arr[count];
            arr[j] = b;
            arr[count] = a;
            count--;
        }
        System.out.println(Arrays.toString(arr));
    }

    //Задача №6:
    public static void averageMonthlyCalc(int[] arr) {
        System.out.printf("Компания в месяц тратит %,d рублей\n", sum(arr));
        System.out.printf("Средняя сумма трат за месяц составила %,.2f рублей\n", meanInDay(arr, sum(arr)));
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static double meanInDay(int[] arr, int sum) {
        double d = sum * 1.0 / arr.length;
        return d;
    }

    public static int[] generateRandomArray() {
        Random random = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}

