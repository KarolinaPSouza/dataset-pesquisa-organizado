import sys

#globals

def solve():
 s = int(input())
 arr = sorted(map(int, input().split()))

 comp = set()
 tot = 1
 for i in range(s - 1):
  if(arr[i] != arr[i + 1]):
   tot += 1

 print(str(tot))







if __name__ == "__main__":
 print = sys.stdout.write
 input = sys.stdin.readline
 solve()