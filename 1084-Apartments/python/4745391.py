import sys
from os import path
if(path.exists('Input.txt')):
    sys.stdin = open("Input.txt","r")
    sys.stdout = open("Output.txt","w")

from queue import PriorityQueue
from collections import Counter
import heapq
from heapq import heapify,heappush,heappop,nlargest,nsmallest,heappushpop
from math import gcd,floor,sqrt,log,ceil,inf
import math
from collections import *
from collections import deque
from bisect import bisect_left
from bisect import bisect_right
def li(): return list(map(int, sys.stdin.readline().split()))
def mp(): return map(int, sys.stdin.readline().split())
def inp(): return int(sys.stdin.readline())
def st(): return list(sys.stdin.readline().strip())
def out(*l): return print(*l)
def pr(n): return sys.stdout.write(str(n)+"\n")
def prl(n): return sys.stdout.write(str(n)+" ")
M = 1000000007
INF = float('inf')
yes, no = "YES", "NO"
import operator as op
from functools import reduce
def ncr(n, r):
    r = min(r, n-r)
    numer = reduce(op.mul, range(n, n-r, -1), 1)
    denom = reduce(op.mul, range(1, r+1), 1)
    return numer // denom
def fact(n):
 return math.factorial(n)
def perfect(n):
 return floor(sqrt(n))==ceil(sqrt(n))
def lcm(a, b):
    return a * b // gcd(a, b)
def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return -1
def isPrime(n):
 if(n==2):
  return True
 if (n % 2 == 0 and n != 2) or n < 2:
     return False
 i = 3
 while i * i <= n:
     if n % i == 0:
         return False
     i += 2
 return True
def expo(a, n, k):
    ans = 1
    while(n > 0):
        last_bit = n&1
        if(last_bit):
            ans = (ans*a)%k
        a = (a*a)%k
        n = n >> 1
    return ans
def prefix_sum(arr):
 n=len(arr)
 l = [arr[0]]
 for i in range(1,n):
  x = l[-1]
  l.append(x+arr[i])
 return l

def solve():
 n,m,k=mp()
 a=li()
 b=li()
 a.sort()
 b.sort()
 x= 0
 y = 0
 ans=0
 while x<n and y<m:
  if(a[x]-k<=b[y] and b[y]<=a[x]+k):
   ans+=1
   x+=1
   y+=1
  else:
   if(a[x]>b[y]):
    y+=1
   else:
    x+=1
 pr(ans)

for _ in range(1):
 #prl(f"Case #{_+1}:")
 solve()