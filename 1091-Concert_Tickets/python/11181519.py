from collections import *        # Useful for deque, Counter, defaultdict, namedtuple, etc.
from itertools import *          # Provides tools for combinations, permutations, product, etc.
from functools import *          # Includes tools like lru_cache for memoization, reduce, etc.
from heapq import *              # Provides heap operations like heappush, heappop, useful for priority queues
from bisect import *             # For efficient binary search and maintaining sorted lists
from math import *               # Includes functions like gcd, sqrt, factorial, isqrt, comb, etc.
from operator import *           # Includes functions like itemgetter, attrgetter, add, mul for functional programming
from array import *              # For efficient storage and manipulation of numeric arrays
from typing import *             # Provides typing hints (List, Tuple, Dict, etc.) to improve readability and error-checking
from decimal import *            # High-precision arithmetic operations, useful for certain precision tasks
from queue import *              # Includes Queue, LifoQueue, PriorityQueue useful in BFS, DFS, and other algorithms
import sys
sys.setrecursionlimit(1<<30)
def POW(base, exp, mod):
    result = 1
    base = base % mod  # Handle case when base is larger than mod
    while exp > 0:
        if exp % 2 == 1:  # If exp is odd, multiply base with result
            result = (result * base) % mod
        exp = exp // 2    # Divide exp by 2
        base = (base * base) % mod  # Square the base
    return result
def IL():
  return [int(i) for i in input().split()]
def CL():
  return [i for i in input().split()]
def I():
  return input()
def db(x):
  return print(x)
def dbl(x):
  return print(*x)
def dbm(x):
  for i in x:
    print(i)
def sq(x):
  return x==int(x**0.5)**2
def prime(n):
    if n <= 1:
        return False
    if n <= 3:
        return True
    if (n & 1) == 0 or n % 3 == 0:
        return False
    i = 5
    while i * i <= n:
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6
    return True

class SegmentTree:
    def __init__(self, n):
        self.n = n
        self.tree = [0] * (4 * n)
        self.lazy = [0] * (4 * n)
    def propagate(self, index, left, right):
        if self.lazy[index] != 0:
            self.tree[index] += self.lazy[index]
            if left != right:
                self.lazy[2 * index] += self.lazy[index]
                self.lazy[2 * index + 1] += self.lazy[index]
            self.lazy[index] = 0
    def update(self, pos, val_to_be_added, index=1, left=0, right=None):
        if right is None:
            right = self.n - 1
        self.propagate(index, left, right)
        if left == right:
            self.tree[index] = val_to_be_added
        else:
            mid = (left + right) // 2
            if pos <= mid:
                self.update(pos, val_to_be_added, 2 * index, left, mid)
            else:
                self.update(pos, val_to_be_added, 2 * index + 1, mid + 1, right)
            self.tree[index] = max(self.tree[2 * index], self.tree[2 * index + 1])

    def update_range(self, left_range, right_range, val_to_be_added, index=1, left=0, right=None):
        if right is None:
            right = self.n - 1
        self.propagate(index, left, right)
        if right_range < left or right < left_range:
            return
        if left_range <= left and right <= right_range:  
            self.lazy[index] += val_to_be_added
            self.propagate(index, left, right)
        else:
            mid = (left + right) // 2
            self.update_range(left_range, right_range, val_to_be_added, 2 * index, left, mid)
            self.update_range(left_range, right_range, val_to_be_added, 2 * index + 1, mid + 1, right)
            self.tree[index] = max(self.tree[2 * index], self.tree[2 * index + 1])

    def query(self, left_range, right_range, index=1, left=0, right=None):
        if right is None:
            right = self.n - 1
        self.propagate(index, left, right)
        if right_range < left or right < left_range:
            return 0
        if left_range <= left and right <= right_range:
            return self.tree[index]
        mid = (left + right) // 2
        return max(self.query(left_range, right_range, 2 * index, left, mid),
                   self.query(left_range, right_range, 2 * index + 1, mid + 1, right))

class DSU:
 def __init__(self, sizes: int) -> None:
  self.parents = [i for i in range(sizes+1)]
  self.sizes = [1 for _ in range(sizes+1)]

 def find(self, x: int) -> int:
   if x!=self.parents[x]:
     self.parents[x]=self.find(self.parents[x])
   return self.parents[x]
 def merge(self, x: int, y: int) -> bool:
  x_root = self.find(x)
  y_root = self.find(y)
  if x_root == y_root:
   return False

  if self.sizes[x_root] < self.sizes[y_root]:
   x_root, y_root = y_root, x_root
  self.parents[y_root] = x_root
  self.sizes[x_root] += self.sizes[y_root]
  return True
 def same(self, x: int, y: int):return self.find(x) == self.find(y)



n,k=IL()
arr=IL()
cus=IL()
D=DSU(n)
arr.sort()
for i in cus:
  ans=-1
  low=0
  high=n-1
  while low<=high:
    mid=(low+high)//2
    if arr[mid]<=i:
      ans=mid
      low=mid+1
    else:
      high=mid-1
  if ans==-1:
    print(-1)
  else:
    ans=D.find(ans)
    # print(ans)
    if ans>=0 and ans<n:
      print(arr[ans])
      D.parents[ans]=ans-1
    else:
      print(-1)