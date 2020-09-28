package test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            in.nextInt();
        }
        System.out.println(n);
    }
}