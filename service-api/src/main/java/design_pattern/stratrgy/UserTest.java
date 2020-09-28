package design_pattern.stratrgy;

import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String strategy = in.next();
            StrategyService.handle(strategy);
        }
    }
}
