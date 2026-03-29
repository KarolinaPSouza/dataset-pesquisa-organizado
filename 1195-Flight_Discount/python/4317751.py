import sys
input = sys.stdin.buffer.readline
from heapq import *
n, m = map(int, input().split())
adj = [[] for _ in range(n)]
for _ in range(m):
 a, b, c = map(int, input().split())
 adj[a-1].append((b-1, c))
D = [10**18] * (2*n)
Q = [1]
def edge(j, nd, na):
 idx = j + na * n
 if nd < D[idx]:
  D[idx] = nd
  heappush(Q, ((nd * n + j) << 1) | na)
while Q:
 x = heappop(Q)
 x, a = x>>1, x&1
 d, i = divmod(x, n)
 if d > D[i+a*n]: continue
 if i == n-1:
  print(d)
  break
 for j, w in adj[i]:
  edge(j, d + w, a)
  if a: edge(j, d + w//2, 0)