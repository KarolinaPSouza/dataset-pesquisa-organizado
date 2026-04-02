//package building.roads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Node {
 public int city, nextCity;

 public Node(int city) {
  this.city = city;
 }
}

public class entry_10302070 {

 public static boolean isFinished() {

  return true;
 }

 public static boolean isValid() {

  return false;
 }

 public static void visit(int city, int group) {
  visited[city] = group;
 }

 public static void dfs(int startingCity) {
  if (visited[startingCity] != 0) {
   return;
  }

  currentGroup++;

  Stack<Node> stack = new Stack<Node>();
  Node current = new Node(startingCity);
  stack.push(current);

  while (!stack.isEmpty()) {
   current = stack.pop();
   visit(current.city, currentGroup);

   for (Integer neighbour: roads[current.city]) {
    if (visited[neighbour] == 0) {
     stack.push(new Node(neighbour));
    }
   }
  }

  result.add(startingCity);
 }

 private static int numberOfCities, numberOfRoads;
 private static ArrayList<Integer>[] roads;
 private static int[] visited;
 private static int currentGroup = 0;
 private static ArrayList<Integer> result = new ArrayList<Integer>();

 public static void main(String[] args) throws Exception {
//  BufferedReader reader = new BufferedReader(new FileReader(new File("input/building-roads.txt")));
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  String line = reader.readLine();
  String[] inputs = line.split(" ");

  numberOfCities = Integer.parseInt(inputs[0]);
  numberOfRoads = Integer.parseInt(inputs[1]);
  visited = new int[numberOfCities + 1];

  roads = new ArrayList[numberOfCities + 1];
  for (int i = 1; i <= numberOfCities; i++) {
//   roads.put(i, new ArrayList<Integer>());
   roads[i] = new ArrayList<Integer>();
  }

  for (int i = 1; i <= numberOfRoads; i++) {
   line = reader.readLine();
   inputs = line.split(" ");

   int a = Integer.parseInt(inputs[0]);
   int b = Integer.parseInt(inputs[1]);
   roads[a].add(b);
   roads[b].add(a);
  }

  for (int i = 1; i <= numberOfCities; i++) {
   dfs(i);
  } 

  System.out.println(currentGroup - 1);
  if (currentGroup > 1) {
   int previous = -1;
   for (int item: result) {
    if (previous != -1) {
     System.out.println(previous + " "+item);
    }

    previous = item;
   }
  }

 }

}