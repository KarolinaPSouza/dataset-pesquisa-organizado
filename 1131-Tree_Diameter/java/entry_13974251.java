import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}



public class entry_13974251 {

 static int Radius = 0;
 static class Node {
  private int farthestPoint = 0;
  private ArrayList<Integer> subordinates;
  public int lastVisited = -1;
  public int index;


  Node(int index) {
   this.index = index;
   this.subordinates = new ArrayList<Integer>();
  }

  public int getFarthestPoint() {
   return this.farthestPoint;
  }

  public ArrayList<Integer> getSubordinatesMap() {
   return this.subordinates;
  }
  public void setFarthestPoint(int count) {
   this.farthestPoint = count;
  }
 }
 public static int dfs(Node node, ArrayList<Node> employees) {
  int[] visited = new int[employees.size()];
  int[] processed = new int[employees.size()];


  Stack<Node> st = new Stack<>();
  visited[0] = 1;
  st.push(node);

  while(!st.isEmpty()) {
   Node n = st.peek();

   boolean allVisited = true;
   ArrayList<Integer> map = n.getSubordinatesMap();
   for(int i=n.lastVisited+1; i<map.size(); i++) {
    int e = map.get(i);
    if (visited[e] == 0) {
     st.push(employees.get(e));
     visited[e] = 1;
     n.lastVisited = i;
     allVisited = false;
     break;
    }
   }

   if (allVisited) {
    int size = n.getSubordinatesMap().size();
    int maxDis1 = -1;
    int maxDis2 = -1;
    int maxFreq = 0;

    ArrayList<Integer> EmployeeMap = n.getSubordinatesMap();

    for (int i = 0; i < size; i++) {
        int employee = EmployeeMap.get(i);
        if (processed[employee] == 1) {
            int distance = 1 + employees.get(employee).getFarthestPoint();

            if (distance > maxDis1) {
                maxDis2 = maxDis1;
                maxDis1 = distance;
                maxFreq = 1;
            } else if (distance == maxDis1) {
                maxFreq++;
            } else if (distance > maxDis2) {
                maxDis2 = distance;
            }
        }
    }


//    Collections.sort(distances);

    n = st.pop();
    processed[n.index] = 1;
    if (maxFreq > 1) {
     maxDis2 = maxDis1;
    }

    maxDis1 = Math.max(0, maxDis1);
    maxDis2 = Math.max(0, maxDis2);
//    if (size > 0) {
     n.setFarthestPoint(maxDis1);     
//    }
//    if (size >=1) {
//     Radius = Math.max(maxDis1, Radius);
//    }
//    if (size >= 2) {
     Radius = Math.max(maxDis1 + maxDis2, Radius);     
//    }

   }

  }
  return 0;


 }

 public static int bfs(Node node, ArrayList<Node> employees) {
  int answer = 0;

  ArrayList<Integer> map = node.getSubordinatesMap();

  for (int i : map) {
   answer = Math.max(answer, bfs(employees.get(i), employees));
  }

  return answer + 1;
 }
 public static void main(String[] args) {
  FastReader scan = new FastReader();
  int n = scan.nextInt();

  ArrayList<Node> employees = new ArrayList<Node>(n);


  for(int i=0; i<n;i++) {
   employees.add(new Node(i));
  }

  for (int i=1; i<n; i++) {
   int x = scan.nextInt();
   int y = scan.nextInt();
   employees.get(x-1).getSubordinatesMap().add(y-1);
   employees.get(y-1).getSubordinatesMap().add(x-1);
  }

  dfs(employees.get(0), employees);

  StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            sb.append(employees.get(i).getSubordinateCount()).append(" ");
//        }
  sb.append(Radius);
        System.out.println(sb.toString().trim());
 }
}