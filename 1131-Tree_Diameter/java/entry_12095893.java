import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class entry_12095893 {

  static class MyIntList {
    private int[] arr;
    public int size;

    public MyIntList() {
      arr = new int[2];
      size = 0;
    }

    public void add(int value) {
      if (size == arr.length) {
        int[] newArr = new int[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
      }
      arr[size++] = value;
    }

    public int get(int index) {
      return arr[index];
    }
  }

  static class Node {
    int id;
    MyIntList neighbors;

    public Node(int id) {
      this.id = id;
      neighbors = new MyIntList();
    }
  }

  static class MyQueue {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public MyQueue(int capacity) {
      data = new int[capacity];
      front = 0;
      rear = 0;
      size = 0;
    }

    public void enqueue(int value) {
      data[rear] = value;
      rear = (rear + 1) % data.length;
      size++;
    }

    public int dequeue() {
      int value = data[front];
      front = (front + 1) % data.length;
      size--;
      return value;
    }

    public boolean isEmpty() {
      return size == 0;
    }
  }

  static int[] bfs(Node[] nodes, int start, int n) {
    int[] dist = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dist[i] = -1;
    }
    dist[start] = 0;
    MyQueue queue = new MyQueue(n);
    queue.enqueue(start);

    while (!queue.isEmpty()) {
      int current = queue.dequeue();
      MyIntList neigh = nodes[current].neighbors;
      for (int i = 0; i < neigh.size; i++) {
        int next = neigh.get(i);
        if (dist[next] == -1) {
          dist[next] = dist[current] + 1;
          queue.enqueue(next);
        }
      }
    }
    return dist;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine().trim());

    Node[] nodes = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
      nodes[i] = new Node(i);
    }

    for (int i = 1; i < n; i++) {
      String[] parts = br.readLine().split(" ");
      int a = Integer.parseInt(parts[0]);
      int b = Integer.parseInt(parts[1]);
      nodes[a].neighbors.add(b);
      nodes[b].neighbors.add(a);
    }

    int[] distFromOne = bfs(nodes, 1, n);
    int farthestNode = 1;
    for (int i = 1; i <= n; i++) {
      if (distFromOne[i] > distFromOne[farthestNode]) {
        farthestNode = i;
      }
    }

    int[] distFromFarthest = bfs(nodes, farthestNode, n);
    int diameter = 0;
    for (int i = 1; i <= n; i++) {
      diameter = Math.max(diameter, distFromFarthest[i]);
    }

    System.out.println(diameter);
  }
}