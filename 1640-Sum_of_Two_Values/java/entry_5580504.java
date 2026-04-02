import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math.*;

public class entry_5580504 {
 public static void main(String[] args) throws IOException 
 {
  Scanner s = new Scanner(System.in);
  int N = s.nextInt();
  int X = s.nextInt();
  int[] nums = new int[N];
  int[] og = new int[N];
  for(int i = 0; i < N; i++)
  {
   int temp = s.nextInt();
   nums[i] = temp;
   og[i] = temp;
  }
  Arrays.sort(nums);

  int end = N-1;
  int start = 0;
  boolean found = false;
  while(start != end && found == false)
  {
   if(nums[start] + nums[end] == X)
   {
    System.out.println(find(og, nums[start]) + " " + findend(og, nums[end]));
    found = true;
   }
   else if(nums[start] + nums[end] > X)
   {
    end--;
   }
   else
   {
    start++;
   }
  }

  if(found == false)
  {
   System.out.println("IMPOSSIBLE");
  }
 }

 public static int find(int[] arr, int target)
 {
  for(int i = 0; i < arr.length; i++)
  {
   if(arr[i] == target)
   {
    return i+1;
   }
  }
  return -1;
 }

 public static int findend(int[] arr, int target)
 {
  for(int i = arr.length-1; i >= 0; i--)
  {
   if(arr[i] == target)
   {
    return i+1;
   }
  }
  return -1;
 }
}