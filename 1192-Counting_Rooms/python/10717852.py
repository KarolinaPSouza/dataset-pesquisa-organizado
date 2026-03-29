import sys
from collections import Counter, defaultdict, deque
from itertools import accumulate, combinations, permutations
from heapq import heappop, heappush
from math import inf
sys.setrecursionlimit(10**6)
MOD = 10**9 + 7

stdin = sys.stdin

ni = lambda: int(ns())
na = lambda: list(map(int, stdin.readline().split()))
ns = lambda: stdin.readline().rstrip()  # ignore trailing spaces

h,w = na()
G = [ns() for _ in range(h)]

seen = [[False]*w for _ in range(h)]
def dfs(sr,sc):
    q = [[sr,sc]]
    while q:
        r,c = q.pop()
        for nr,nc in [[r+1,c],[r,c+1],[r-1,c],[r,c-1]]:
            if not (0 <= nr < h and 0 <= nc < w): continue
            if G[r][c] == '#': continue
            if seen[nr][nc]: continue
            seen[nr][nc] = True
            q.append([nr,nc])

ans = 0
for r in range(h):
    for c in range(w):
        if G[r][c] == '#' or seen[r][c]: continue
        dfs(r,c)
        ans += 1
print(ans)