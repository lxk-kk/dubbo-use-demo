package test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test{
    private static HashMap<Object, Function<String, String>> map;
    // 配置 条件 -> 特定业务逻辑 之间的映射
    static{
        map = new HashMap<>();
        map.put("1", Service::handleOne);
        map.put("2", Service::handleTwo);
        map.put("3", Service::handleThir);
        map.put("4", Service::handleFour);
    }
    // 业务逻辑
    private static class Service{

        public static String handleOne(Object obj){
            System.out.println("1");
            return "1 - " + obj;
        }
        public static String handleTwo(Object obj){
            System.out.println("2");
            return "2 - " + obj;
        }
        public  static String handleThir(Object obj){
            System.out.println("3");
            return "3 - " + obj;
        }
        public static String handleFour(Object obj){
            System.out.println("4");
            return "4 - " + obj;
        }
    }

    // 根据条件，执行特定的业务逻辑
    private static String handle(String obj) {
        Function<String, String> function = map.get(obj);
        if (function != null) {
            // 执行业务逻辑
            return function.apply(obj);
        }
        return "no such function!";
    }

    // 测试
    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        List<Integer> arr = Arrays.stream(a).boxed().collect(Collectors.toList());
        

        System.out.println(handle("1"));;
        System.out.println(handle("2"));;
        System.out.println(handle("6"));;
    }
}
