import sys
import heapq
import bisect
from collections import deque, defaultdict, Counter
from itertools import permutations, combinations, accumulate
# from functools import cache

input = lambda: sys.stdin.readline().strip()

def I():
    return input()

def II():
    return int(input())

def MII():
    return map(int, input().split())

def LI():
    return input().split()

n, capacity = MII()
v = list(MII())
w = list(MII())

dp = [0] * (capacity + 1)
for i in range(n):
    vi, wi = v[i], w[i]
    for j in range(capacity, vi - 1, -1):
        t = dp[j - vi] + wi
        if t > dp[j]:
            dp[j] = t

print(dp[capacity])