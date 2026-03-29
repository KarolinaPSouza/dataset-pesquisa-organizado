from heapq import *
n, m, *e = [*map(int, open(0).read().split())]
G = [[] for _ in ' '* -~n]
for a, b, w in zip(*[iter(e)]*3):
 G[a] += (b, w),

V = 2* -~n*[0]
Q = [(0, 1, 1)]
while Q:
 d, v, c = heappop(Q)
 if v==n:
  print(d)
  exit()
 I = c* -~n+v
 if not V[I]:
  V[I] = 1
  for u, w in G[v]:
   if not V[c* -~n+u]: heappush(Q, (d+w, u, c))
   if c and not V[u]: heappush(Q, (d+w//2, u, 0))