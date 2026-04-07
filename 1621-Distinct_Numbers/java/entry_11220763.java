//package org.example.cses_search_and_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class entry_11220763 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            s.add(Integer.parseInt(inputs[i]));
        }
        System.out.println(s.size());
    }
}