/*import java.util.* ;
import java.lang.* ;
import java.io.* ;
public class entry_13781726 {
    public static void main(String[] args) {
        String [] words = {"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"} ;
        System.out.println(longestPalindrome(words)) ;
    }
    public static int longestPalindrome(String[] words) {
        HashMap<String , Integer> map = new HashMap<>() ;
        for(int index = 0 ; index < words.length ; index++){
            String s = words[index] ;
            map.put(s , map.getOrDefault(s , 0) + 1) ;
        }
        HashSet<String> set = new HashSet<>() ;
        int len = 0 ;
        boolean isOneLen = false ;
        for(String key : map.keySet()){
            if(set.contains(key)){
                continue ;
            }
            if(key.charAt(0) == key.charAt(1)){
                if(map.get(key) == 1){
                    if(!isOneLen){
                        len += 2 ;
                        isOneLen = true ;
                    }
                }
                else{
                    len += 2*map.get(key) ;
                }
                set.add(key) ;
                continue ;
            }
            StringBuilder sb = new StringBuilder(key) ;
            sb.reverse() ;
            if(map.containsKey(sb.toString())){
                len += 4*map.get(key) ;
                set.add(key) ;
                set.add(sb.toString()) ;
            }
        }
        return len ;
    }
}*/
/*import java.util.* ;
import java.lang.* ;
import java.io.* ;
public class entry_13781726 {
    public static void main(String[] args) {
        String caption = "             M" ;
        System.out.println(generateTag(caption)) ;
    }
    public static String generateTag(String caption) {
        StringBuilder sb = new StringBuilder() ;
        sb.append('#') ;
        int index = 0 ;
        while(index < caption.length()){
            if(sb.length() == 100){
                break ;
            }
            boolean isSpaced = false ;
            while(index < caption.length() && caption.charAt(index) == ' '){
                ++index ;
                isSpaced = true ;
            }
            if(isSpaced && index < caption.length() && sb.length() < 100){
                char ch = caption.charAt(index) ;
                if(sb.length() == 1){
                    if(ch < 97){
                        sb.append((char)((ch - 'A') + 'a')) ;
                    }
                    else{
                        sb.append(ch) ;
                    }
                }
                else{
                    if(ch < 97){
                        sb.append(ch) ;
                    }
                    else{
                        sb.append((char)((ch - 'a') + 'A')) ;
                    }
                }
            }
            else if(index < caption.length() && sb.length() < 100){
                char ch = caption.charAt(index) ;
                if(ch < 97){
                    sb.append((char)((ch - 'A') + 'a')) ;
                }
                else{
                    sb.append(ch) ;
                }
            }
            ++index ;
        }
        return sb.toString() ;
    }
}*/
/*import org.w3c.dom.ls.LSOutput;
 import java.util.* ;
import java.lang.* ;
import java.io.* ;
public class entry_13781726 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        int n = input.nextInt() ;
        int m = input.nextInt() ;
        int k = input.nextInt() ;
        if((long)n*m <= k){
            System.out.println(n*m) ;
        }
    }
}*/
/*import java.util.* ;
import java.lang.* ;
import java.io.* ;
public class entry_13781726 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        int n = input.nextInt() ;
        input.nextLine() ;
        String s = input.next() ;
        input.nextLine() ;
        int d = input.nextInt() ;
        if(d >= 25){
            for(int index = 0 ; index < n ; index++){
                System.out.print((n-1 - index) + " ") ;
            }
            System.out.println() ;
            return ;
        }
        int [] freq = new int [26] ;
        for(int index = 0 ; index < s.length() ; index++){
            char ch = s.charAt(index) ;
            ++freq[ch - 'a'] ;
        }
        int [] res = new int [n] ;
        for(int index = 0 ; index < s.length() ; index++){
            char ch = s.charAt(index) ;
            int diff = ch - 'a' , count = 0 ;
            if(freq[diff] > 1){
                count += freq[diff] - 1 ;
            }
            int left = Math.max(0 , diff - d) ;
            int right = Math.min(25 , diff + d) ;
            while(left < diff){
                if(freq[left] > 0){
                    count += freq[left] ;
                }
                ++left ;
            }
            while(right > diff){
                if(freq[right] > 0){
                    count += freq[right] ;
                }
                --right ;
            }
            res[index] = count ;
            --freq[diff] ;
        }
        for(int index = 0 ; index < n ; index++){
            System.out.print(res[index] + " ") ;
        }
    }
}*/
/*import java.util.* ;
import java.lang.* ;
import java.io.* ;
class Pair{
    int first ;
    int second ;
    public Pair(int first , int second){
        this.first = first ;
        this.second = second ;
    }
}
public class entry_13781726 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        int n = input.nextInt() ;
        int m = input.nextInt() ;
        String [] arr = new String[n] ;
        char [][] grid = new char [n][m] ;
        input.nextLine() ;
        for(int i = 0 ; i < n ; i++){
            arr[i] = input.next() ;
        }
        for(int i = 0 ; i < n ; i++){
            grid[i] = arr[i].toCharArray() ;
        }
        int count = 0 ;
        int [][] vis = new int [n][m] ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '.' && vis[i][j] == 0){
                    bfs(i , j , grid , vis) ;
                    ++count ;
                }
            }
        }
        System.out.println(count) ;
    }
    public static void bfs(int x , int y , char [][] grid , int [][] vis){
        Queue<Pair> queue = new LinkedList<>() ;
        queue.offer(new Pair(x , y)) ;
        vis[x][y] = 1 ;
        while(!queue.isEmpty()){
            Pair rem = queue.remove() ;
            int a = rem.first , b = rem.second ;
            if(a > 0 && vis[a-1][b] == 0 && grid[a-1][b] == '.'){
                queue.offer(new Pair(a-1 , b)) ;
                vis[a-1][b] = 1 ;
            }
            if(b > 0 && vis[a][b-1] == 0 && grid[a][b-1] == '.'){
                queue.offer(new Pair(a , b-1)) ;
                vis[a][b-1] = 1 ;
            }
            if(a < grid.length - 1 && vis[a+1][b] == 0 && grid[a+1][b] == '.'){
                queue.offer(new Pair(a+1 , b)) ;
                vis[a+1][b] = 1 ;
            }
            if(b < grid[0].length - 1 && vis[a][b+1] == 0 && grid[a][b+1] == '.'){
                queue.offer(new Pair(a , b+1)) ;
                vis[a][b+1] = 1 ;
            }
        }
        return ;
    }
}*/
/*import java.util.*;
import java.lang.*;
import java.io.*;*/

/*class Pair {
    int first;
    int second;
     public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
 class Triplet {
    int first;
    int second;
    int num;
     public Triplet(int first, int second, int num) {
        this.first = first;
        this.second = second;
        this.num = num;
    }
}
 public class entry_13781726 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        char[][] grid = new char[n][m];
        String[] arr = new String[n];
        input.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = input.next();
        }
        for (int i = 0; i < n; i++) {
            grid[i] = arr[i].toCharArray();
        }
         int startRow = -1, startCol = -1, endRow = -1, endCol = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    startRow = i;
                    startCol = j;
                }
                if (grid[i][j] == 'B') {
                    endRow = i;
                    endCol = j;
                }
            }
        }
         int[][] vis = new int[n][m];
        Pair[][] parent = new Pair[n][m];
         int level = bfs(startRow, startCol, endRow, endCol, grid, vis, parent);
        if (level > 0 || (startRow == endRow && startCol == endCol)) {
            String path = pathFinder(startRow, startCol, endRow, endCol, parent);
            System.out.println("YES");
            System.out.println(level);
            System.out.println(path);
        } else {
            System.out.println("NO");
        }
    }
     public static int bfs(int startRow, int startCol, int endRow, int endCol, char[][] grid, int[][] vis, Pair[][] parent) {
        int m = grid.length, n = grid[0].length;
        Queue<Triplet> queue = new LinkedList<>();
        queue.offer(new Triplet(startRow, startCol, -1));
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Triplet rem = queue.remove();
                int x = rem.first, y = rem.second, num = rem.num;
                 if (x > 0 && (grid[x - 1][y] == '.' || grid[x - 1][y] == 'B') && vis[x - 1][y] == 0) {
                    int copy = num;
                    if (num == -1) copy = 1;
                    queue.offer(new Triplet(x - 1, y, copy));
                    vis[x - 1][y] = copy;
                    parent[x - 1][y] = new Pair(x, y);
                    if (x - 1 == endRow && y == endCol) return level + 1;
                }
                 if (y > 0 && (grid[x][y - 1] == '.' || grid[x][y - 1] == 'B') && vis[x][y - 1] == 0) {
                    int copy = num;
                    if (num == -1) copy = 2;
                    queue.offer(new Triplet(x, y - 1, copy));
                    vis[x][y - 1] = copy;
                    parent[x][y - 1] = new Pair(x, y);
                    if (x == endRow && y - 1 == endCol) return level + 1;
                }
                 if (x < grid.length - 1 && (grid[x + 1][y] == '.' || grid[x + 1][y] == 'B') && vis[x + 1][y] == 0) {
                    int copy = num;
                    if (num == -1) copy = 3;
                    queue.offer(new Triplet(x + 1, y, copy));
                    vis[x + 1][y] = copy;
                    parent[x + 1][y] = new Pair(x, y);
                    if (x + 1 == endRow && y == endCol) return level + 1;
                }
                 if (y < grid[0].length - 1 && (grid[x][y + 1] == '.' || grid[x][y + 1] == 'B') && vis[x][y + 1] == 0) {
                    int copy = num;
                    if (num == -1) copy = 4;
                    queue.offer(new Triplet(x, y + 1, copy));
                    vis[x][y + 1] = copy;
                    parent[x][y + 1] = new Pair(x, y);
                    if (x == endRow && y + 1 == endCol) return level + 1;
                }
            }
            ++level;
        }
        return 0;
    }
     public static String pathFinder(int startRow, int startCol, int endRow, int endCol, Pair[][] parent) {
        StringBuilder path = new StringBuilder();
        int x = endRow, y = endCol;
        while (x != startRow || y != startCol) {
            Pair p = parent[x][y];
            if (p == null) break;
            if (p.first == x - 1 && p.second == y) path.append('D');
            else if (p.first == x + 1 && p.second == y) path.append('U');
            else if (p.first == x && p.second == y - 1) path.append('R');
            else if (p.first == x && p.second == y + 1) path.append('L');
            x = p.first;
            y = p.second;
        }
        return path.reverse().toString();
    }
}*/
/*import java.io.*;
import java.util.*;
 class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
     public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            size.add(1);
            parent.add(i);
        }
    }
     public int findParent(int p) {
        if (parent.get(p) != p) {
            parent.set(p, findParent(parent.get(p))); // path compression
        }
        return parent.get(p);
    }
     public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) return;
         if (size.get(pu) >= size.get(pv)) {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        } else {
            parent.set(pu, pv);
            size.set(pv, size.get(pu) + size.get(pv));
        }
    }
}
 public class entry_13781726 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
         DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            ds.unionBySize(u, v);
        }
         HashSet<Integer> uniqueParents = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            uniqueParents.add(ds.findParent(i));
        }
         List<Integer> components = new ArrayList<>(uniqueParents);
        int numNewEdges = components.size() - 1;
         StringBuilder sb = new StringBuilder();
        sb.append(numNewEdges).append("\n");
         for (int i = 1; i < components.size(); i++) {
            sb.append(components.get(0)).append(" ").append(components.get(i)).append("\n");
        }
         System.out.print(sb.toString());
    }
}*/
/*import java.util.* ;
import java.lang.* ;
import java.io.* ;
public class entry_13781726 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)) ;
        StringTokenizer st = new StringTokenizer(input.readLine()) ;
        int n = Integer.parseInt(st.nextToken()) ;
        int m = Integer.parseInt(st.nextToken()) ;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>() ;
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>()) ;
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(input.readLine()) ;
            int u = Integer.parseInt(st.nextToken()) ;
            int v = Integer.parseInt(st.nextToken()) ;
            adj.get(u).add(v) ;
            adj.get(v).add(u) ;
        }
        int [] parent = new int [n+1] ;
        int level = bfs(adj , parent , n) ;
        if(level == 0){
            System.out.println("IMPOSSIBLE") ;
            return ;
        }
        System.out.println(level) ;
        List<Integer> list = new ArrayList<>() ;
        list.add(n) ;
        int num = parent[n] ;
        while(num != 0){
            list.add(num) ;
            num = parent[num] ;
        }
        Collections.reverse(list) ;
         for (Integer integer : list) {
            System.out.print(integer + " ") ;
        }
    }
    public static int bfs(ArrayList<ArrayList<Integer>> adj , int [] parent , int n){
        Queue<Integer> queue = new LinkedList<>() ;
        int [] vis = new int [n+1] ;
        queue.offer(1) ;
        vis[1] = 1 ;
        int level = 1 ;
        while(!queue.isEmpty()){
            int size = queue.size() ;
            for(int i = 0 ; i < size ; i++){
                int rem = queue.remove() ;
                for(int j = 0 ; j <  adj.get(rem).size() ; j++){
                    int num = adj.get(rem).get(j) ;
                    if(vis[num] == 0){
                        queue.offer(num) ;
                        vis[num] = 1 ;
                        parent[num] = rem ;
                    }
                    if(num == n){
                        return level + 1 ;
                    }
                }
            }
            ++level ;
        }
        return 0 ;
    }
}*/
/*import java.util.*;
import java.io.*;
 public class entry_13781726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
         for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
         boolean[] vis = new boolean[n + 1];
        int[] nums = new int[n + 1];
        boolean flag = false;
         for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                int num = bfs(i, vis, adj, nums);
                if (num == -1) {
                    flag = true;
                }
            }
            if (flag) {
                System.out.println("IMPOSSIBLE");
                break;
            }
        }
         if (!flag) {
            for (int j = 1; j <= n; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }
    }
     public static int bfs(int num, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        vis[num] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int rem = queue.remove();
                if (level % 2 == 0) {
                    nums[rem] = 1;
                } else {
                    nums[rem] = 2;
                }
                for (int j = 0; j < adj.get(rem).size(); j++) {
                    int number = adj.get(rem).get(j);
                    if (!vis[number]) {
                        queue.add(number);
                        vis[number] = true;
                    }
                    if (nums[number] == nums[rem]) {
                        return -1;
                    }
                }
            }
            ++level;
        }
        return 0;
    }
}*/
/*import java.util.*;
import java.io.*;
 public class entry_13781726 {
    static List<Integer> cycle = new ArrayList<>();
    static int[] parent;
    static boolean[] vis;
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
         ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
         for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
         vis = new boolean[n + 1];
        parent = new int[n + 1];
        Arrays.fill(parent, -1);
         boolean foundCycle = false;
         for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, adj)) {
                    foundCycle = true;
                    break;
                }
            }
        }
         if (!foundCycle) {
            bw.write("IMPOSSIBLE\n");
        } else {
            // reconstruct cycle
            int start = cycle.get(0);
            int end = cycle.get(1);
            List<Integer> path = new ArrayList<>();
            path.add(start);
            for (int v = end; v != start; v = parent[v]) {
                path.add(v);
            }
            path.add(start);
            Collections.reverse(path);
             bw.write(path.size() + "\n");
            for (int v : path) {
                bw.write(v + " ");
            }
            bw.write("\n");
        }
         bw.flush();
        bw.close();
        br.close();
    }
     public static boolean dfs(int node, int par, ArrayList<Integer>[] adj) {
        vis[node] = true;
         for (int num : adj[node]) {
            if (num == par) continue;
             if (!vis[num]) {
                parent[num] = node;
                if (dfs(num, node, adj)) return true;
            } else {
                // cycle found
                cycle.clear();
                cycle.add(num);
                cycle.add(node);
                return true;
            }
        }
        return false;
    }
}*/
/*import java.util.* ;
import java.lang.* ;
import java.io.* ;
class Triplet{
    int first ;
    int second ;
    char ch ;
    public Triplet(int first , int second , char ch){
        this.first = first ;
        this.second = second ;
        this.ch = ch ;
    }
}
class T{
    int first ;
    int second ;
    int third ;
    public T(int first , int second , int third){
        this.first = first ;
        this.second = second ;
        this.third = third ;
    }
}
public class entry_13781726 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        StringTokenizer st = new StringTokenizer(br.readLine()) ;
        int m = Integer.parseInt(st.nextToken()) ;
        int n = Integer.parseInt(st.nextToken()) ;
        char [][] grid = new char[m][n] ;
        String [] arr = new String[m] ;
        for(int i = 0 ; i < m ; i++){
            arr[i] = br.readLine() ;
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                grid[i][j] = arr[i].charAt(j) ;
            }
        }
        Queue<Triplet> queue = new LinkedList<>() ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 'M'){
                    queue.add(new Triplet(i , j , 'M')) ;
                }
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 'A'){
                    queue.add(new Triplet(i , j , 'A')) ;
                }
            }
        }
        Triplet [][] parent = new Triplet [m][n] ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                parent[i][j] = new Triplet(i , j , '.') ;
            }
        }
        boolean [][] vis = new boolean[m][n] ;
        T level = levelOrder(queue , grid , parent , vis) ;
        if(level.first == -1){
            System.out.println("NO") ;
        }
        else{
            String str = order(parent , level.second , level.third) ;
            System.out.println("YES") ;
            System.out.println(level.first) ;
            System.out.println(str) ;
        }
    }
    public static String order(Triplet [][] parent , int i , int j){
        StringBuilder sb = new StringBuilder() ;
        while(!(parent[i][j].first == i && parent[i][j].second == j)){
            if(parent[i][j].first == i-1){
                sb.append('D') ;
            }
            else if(parent[i][j].first == i+1){
                sb.append('U') ;
            }
            else if(parent[i][j].second == j-1){
                sb.append('R') ;
            }
            else if(parent[i][j].second == j+1){
                sb.append('L') ;
            }
            int num1 = i , num2 = j ;
            i = parent[num1][num2].first ;
            j = parent[num1][num2].second ;
        }
        return sb.reverse().toString() ;
    }
    public static T levelOrder(Queue<Triplet> queue , char [][] grid , Triplet [][] parent , boolean [][] vis){
        int level = 0 ;
        while(!queue.isEmpty()){
            int size = queue.size() ;
            for(int i = 0 ; i < size ; i++){
                Triplet rem = queue.remove() ;
                int row = rem.first , col = rem.second ;
                char c = rem.ch ;
                if(c == 'A' && ((row == grid.length - 1) || (col == grid[0].length - 1) || (row == 0) || (col == 0))){
                    return new T(level , row , col) ;
                }
                if(row > 0 && grid[row-1][col] == '.' && !vis[row-1][col]){
                    queue.add(new Triplet(row-1 , col , c)) ;
                    parent[row-1][col] = rem ;
                    vis[row-1][col] = true ;
                    if(c == 'A' && (row - 1 == grid.length - 1 || col == grid[0].length - 1 || row - 1 == 0 || col == 0)){
                        return new T(level + 1 , row - 1 , col) ;
                    }
                }
                if(col > 0 && grid[row][col-1] == '.' && !vis[row][col-1]){
                    queue.add(new Triplet(row , col-1 , c)) ;
                    parent[row][col-1] = rem ;
                    vis[row][col-1] = true ;
                    if(c == 'A' && (row == grid.length - 1 || col - 1 == grid[0].length - 1 || row == 0 || col - 1 == 0)){
                        return new T(level + 1 , row , col - 1) ;
                    }
                }
                if(row < grid.length - 1 && grid[row+1][col] == '.' && !vis[row+1][col]){
                    queue.add(new Triplet(row + 1 , col , c)) ;
                    parent[row+1][col] = rem ;
                    vis[row + 1][col] = true ;
                    if(c == 'A' && (row + 1 == grid.length - 1 || col == grid[0].length - 1 || row + 1 == 0 || col == 0)){
                        return new T(level + 1 , row + 1 , col) ;
                    }
                }
                if(col < grid[0].length - 1 && grid[row][col+1] == '.' && !vis[row][col + 1]){
                    queue.add(new Triplet(row , col + 1 , c)) ;
                    parent[row][col + 1] = rem ;
                    vis[row][col + 1] = true ;
                    if(c == 'A' && (row == grid.length - 1 || col + 1 == grid[0].length - 1 || row == 0 || col + 1 == 0)){
                        return new T(level + 1 , row , col + 1) ;
                    }
                }
            }
            ++level ;
        }
        return new T(-1 , -1 , -1) ;
    }
}*/
import java.util.*;
import java.io.*;

class Pair {
    long dist;
    int node;
    public Pair(long dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

class P {
    int node;
    long weight;
    public P(int node, long weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class entry_13781726 {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();

        int n = fr.nextInt();
        int m = fr.nextInt();

        ArrayList<ArrayList<P>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = fr.nextInt();
            int v = fr.nextInt();
            int wt = fr.nextInt();
            adj.get(u).add(new P(v, wt));
        }

        long[] dist = dijkstra(n, adj);
        for (int i = 1; i <= n; i++) {
            fw.print(dist[i] + " ");
        }
        fw.println("");
        fw.close();
    }

    public static long[] dijkstra(int V, ArrayList<ArrayList<P>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        long[] dist = new long[V + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        pq.offer(new Pair(0, 1));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            long d = current.dist;
            int u = current.node;

            if (d > dist[u]) continue;

            for (P neighbor : adj.get(u)) {
                int v = neighbor.node;
                long wt = neighbor.weight;
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.offer(new Pair(dist[v], v));
                }
            }
        }

        return dist;
    }

    // FastReader for fast input
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }

    // FastWriter for fast output
    static class FastWriter {
        BufferedWriter bw;
        public FastWriter() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        public void print(String s) throws IOException {
            bw.write(s);
        }
        public void println(String s) throws IOException {
            bw.write(s);
            bw.newLine();
        }
        public void close() throws IOException {
            bw.flush();
            bw.close();
        }
    }
}