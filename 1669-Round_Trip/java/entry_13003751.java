import java.util.*;
import java.io.*;

public class entry_13003751 {
    static ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Boolean> visitedArray = new ArrayList<Boolean>();
    static ArrayList<Integer> parentArray = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
      DataInputStream din = new DataInputStream(System.in);
      byte[] buffer = new byte[din.available()];
      din.readFully(buffer); 
      String[] tokens = new String(buffer).trim().split("\\s+");
      int numberOfCities = Integer.parseInt(tokens[0]);
      int numberOfRoads = Integer.parseInt(tokens[1]);
      for(int i = 0; i <= numberOfCities; i++){
        array.add(new ArrayList<Integer>());
      }
      for(int i = 0; i <= numberOfCities; i++){
        visitedArray.add(false);
      }
      for(int i = 0; i <= numberOfCities; i++){
        parentArray.add(-1000);
      }
      int count = 2;
      for(int i = 1; i <= numberOfRoads; i++){
        int node1 = Integer.parseInt(tokens[count]);
        count++;
        int node2 = Integer.parseInt(tokens[count]);
        count++;
        array.get(node1).add(node2);
        array.get(node2).add(node1);
      }
      for(int i = 1; i <= numberOfCities; i++){
        ArrayList<Integer> asteroid = HelperFunction(i, 0);
        if(asteroid.size() != 0){
          asteroid.add(asteroid.get(0));
          System.out.println(asteroid.size());
          printAllElementsInsideMyArray(asteroid);
          return;
        }
      }
      System.out.println("IMPOSSIBLE");
  }

  static ArrayList<Integer> HelperFunction(int node, int parent){
    if(visitedArray.get(node) == true){
      return new ArrayList<Integer>();
    }
    parentArray.set(node, parent);
    for(int i = 0; i <= array.get(node).size() - 1; i++){
      if(parentArray.get(array.get(node).get(i)) >= 0 && array.get(node).get(i) != parent){
        return findCyclicPathway(node, parent, array.get(node).get(i));
      }
      if(parentArray.get(array.get(node).get(i)) < 0){
        ArrayList<Integer> outcome = HelperFunction(array.get(node).get(i), node);
        if(outcome.size() != 0){
          return outcome;
        }
      }
    }
    visitedArray.set(node, true);
    parentArray.set(node, -1000);
    return new ArrayList<Integer>();
  }

  static ArrayList<Integer> findCyclicPathway(int node, int parent, int start){
    if(node == start){
      ArrayList<Integer> edge = new ArrayList<Integer>();
      edge.add(node);
      return edge;
    }
    ArrayList<Integer> list = findCyclicPathway(parent, parentArray.get(parent), start);
    list.add(node);
    return list;
  }

  static void printAllElementsInsideMyArray(ArrayList<Integer> array){
    for(int i = 0; i <= array.size() - 1; i++){
      System.out.print(array.get(i) + " ");
    }
  }
}