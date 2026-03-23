import heapq
import operator as op
import sys
from bisect import bisect_left as b_l
from bisect import bisect_right as b_r
from collections import defaultdict, deque
from functools import reduce
from math import ceil, factorial, gcd, sqrt,log2,log

INT_MAX = sys.maxsize-1
INT_MIN = -sys.maxsize

def ncr(n,r):
 r=min(n,n-r)
 nmtr = reduce(op.mul,range(n,n-r,-1),1)
 dnmtr = reduce(op.mul,range(1,r+1),1)
 return nmtr//dnmtr


def fact(n):
 return factorial(n)



def myyy__answer():
 n,m,d=map(int,input().split())
 a=sorted(list(map(int,input().split())))
 b=sorted(list(map(int,input().split())))

 ans=0;i=0;j=0

 while(i<n and j<m):
  if(abs(a[i]-b[j])<=d):
   ans+=1
   i+=1
   j+=1
  elif(b[j]<a[i]):
   j+=1
  elif(a[i]<b[j]):
   i+=1

  # print(i,j)
 print(ans)




































if __name__ == "__main__":
 input = lambda: sys.stdin.readline().rstrip("\r\n")

 # for _ in range(int(input())):
  # print(myyy__answer())
 myyy__answer()