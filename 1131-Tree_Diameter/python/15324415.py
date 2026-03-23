import io, os
import sys, random
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
sys.setrecursionlimit(10**9)
# from heapq import heappush as hpush, heappop as hpop
# from math import log2,ceil
# from bisect import insort
# from collections import deque
# from functools import cache
intput = lambda: int(input())
intputs = lambda: map(int, input().split())
# intlist = lambda: list(map(int, input().split()))

# RANDOM = random.randrange(2**62)
# inf = float('inf')
# MOD = 10**9+7

def tree_matching(n, adj):

    def dfs(u, p):
        mx1,mx2 = 0,0 
        for v in adj[u]:
            if v == p: continue
            mxv = dfs(v,u)
            if mxv > mx1:
                mx2 = mx1
                mx1 = mxv
            elif mxv > mx2:
                mx2 = mxv
        res[0] = max(res[0], 1 + mx1 + mx2 )
        return 1 + mx1

    res = [0]
    dfs(1, 0)
    print(res[0]-1)


n = intput()
adj = [ [] for i in range(n+1) ]
for _ in range(n-1):
    u,v = intputs()
    adj[u].append(v)
    adj[v].append(u)


tree_matching(n+1, adj)