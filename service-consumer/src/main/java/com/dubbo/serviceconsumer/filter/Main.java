package com.dubbo.serviceconsumer.filter;

import java.util.*;

public class Main {
    private static class Node{
        Integer val;

        Node(int val) {
            this.val = val;
        }
    }
    private static class Node1{
        Integer val;

        Node1(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return 0;
            }
        });

        HashMap<Integer, Node> test = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            Node node = new Node(i);
            System.out.println(node);
            test.put(i, node);
        }
        System.out.println(" ---- ");
        printMap(test);
        System.out.println(" ---- ");
        for (Map.Entry entry : test.entrySet()) {
            Node1 node = (Node1) entry.getValue();
            node.val = 0;
            System.out.println(node);
        }
        System.out.println(" ---- ");
        printMap(test);
    }

    private static void printMap(HashMap<Integer, Node>  map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + ((Node)entry.getValue()).val);
        }
    }
}
/*
1
10 2
3
1 2
4 5
8 8
2
1 4
6 8
* */