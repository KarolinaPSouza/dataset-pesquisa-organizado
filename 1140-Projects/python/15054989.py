import math
import sys
from collections import deque, Counter, defaultdict
from bisect import *
import heapq

MAXN = 2 * int(1e5)
MOD = int(1e9 + 7)
INF = 10**15

def solution() -> None:
 input = sys.stdin.readline
 n = int(input())
 projects = []

 for _ in range(n):
  projects.append(tuple(map(int, input().split())))

 order = sorted(projects, key = lambda x: x[1])

 dp = [(0, 0)]
 for a, b, p in order:
  st_idx = bisect_left(dp, (a, 0))
  end_idx = bisect_left(dp, (b, 0))

  profit_before_start = dp[st_idx - 1][1]
  profit_with_this = profit_before_start + p

  profit_without_this = dp[-1][1]

  if profit_with_this > profit_without_this:
   dp.append((b, profit_with_this))

 print(dp[-1][1])

if __name__=="__main__":
 solution()