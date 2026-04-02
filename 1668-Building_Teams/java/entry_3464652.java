import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class entry_3464652 {
    public static void main (String args[]) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n,m,a,b;

  n = Integer.parseInt(st.nextToken());
  m = Integer.parseInt(st.nextToken());

  int[] assignedTeams = new int[n+1];
  ArrayList<LinkedList<Integer>> graph = new ArrayList<>();

  for(int i=0;i<n+1;i++){
   graph.add(new LinkedList<>());
  }

  for(int i=0;i<m;i++){
   st = new StringTokenizer(br.readLine());
   a = Integer.parseInt(st.nextToken());
   b = Integer.parseInt(st.nextToken());

   graph.get(a).addLast(b);
   graph.get(b).addLast(a);
  }

  if(isBipartite(graph,assignedTeams)){
   bw.write(assignedTeams[1]);
   for(int i=2;i<n+1;i++){
    bw.write(" ");
    bw.write(assignedTeams[i]);
   }

  }else bw.write("IMPOSSIBLE");

  bw.flush();

 }

 public static boolean isBipartite(ArrayList<LinkedList<Integer>> graph,int[] assignedTeams){
  LinkedList<Integer> queue = new LinkedList<>();

  for(int pupil=1;pupil<graph.size();pupil++){
   if(assignedTeams[pupil]!=0){
    continue;
   }

   queue.addLast(pupil);
   assignedTeams[pupil] = 49;

   while(!queue.isEmpty()){
    int removedPupil = queue.removeFirst();
    int teamForFriends;
    if(assignedTeams[removedPupil]==49){
     teamForFriends = 50;
    }else{
     teamForFriends = 49;
    }

    for(int friendPupil:graph.get(removedPupil)){
     if(assignedTeams[friendPupil]==0){
      assignedTeams[friendPupil] = teamForFriends;
      queue.addLast(friendPupil);
     }else if(assignedTeams[friendPupil]!=teamForFriends){
      return false;
     }
    }
   }
  }

  return true;
 }
}