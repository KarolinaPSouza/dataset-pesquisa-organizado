import sys
from bisect import *

sys.setrecursionlimit(200000)


def get_endpoint(idx: int) -> int:
 if idx == -1 or idx == endpoints[idx]:  # idx is the root
  return idx
 endpoints[idx] = get_endpoint(endpoints[idx])  # find the root of its parent
 return endpoints[idx]


n, m = map(int, input().split())
h = sorted(int(i) for i in input().split())  # price of tickets
t = [int(i) for i in input().split()]  # max price for each customer
endpoints = list(range(n))
for i in t:
 pos = get_endpoint(bisect(h, i) - 1)
 if pos >= 0:
  print(h[pos])
  endpoints[pos] = pos - 1
 else:
  print(-1)