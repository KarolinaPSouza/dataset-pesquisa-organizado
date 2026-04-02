import java.io.*;
import java.util.*;
public class entry_12760917 {
public static void main(String[] args) throws IOException{
BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(System.out));
String[] a = reader.readLine().split(" ");
int n = Integer.parseInt(a[0]);
int x = Integer.parseInt(a[1]);
HashMap<Integer, Integer> map = new HashMap<>();
String[] values = reader.readLine().split(" ");
int i = 0;
for (String value : values ){
map.put(Integer.parseInt(value), i);
i++;
}
for (i = 0; i<n; i++){
if (map.containsKey(x-Integer.parseInt(values[i])) && (i != map.get(x-Integer.parseInt(values[i])))){
writer.write(String.valueOf((i+1)+ " " +(map.get(x-Integer.parseInt(values[i]))+1)));
writer.flush();
return;
}
}
writer.write("IMPOSSIBLE\n");
writer.flush();
}
}