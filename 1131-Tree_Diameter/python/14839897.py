import heapq
import sys
sys.setrecursionlimit(210228)
from collections import deque

n = int(input())
children = [[] for i in range(n + 1)]
for i in range(n - 1):
 a, b = [int(el) for el in input().split(' ')]
 children[a].append(b)
 children[b].append(a)

dpths = [[0, 0] for i in range(n + 1)]
for i in range(n + 1):
 heapq.heapify(dpths[i])
used = [0] * (n + 1)

def recursive():
 res = 0
 def dfs(node):
  nonlocal res
  used[node] = 1
  for child in children[node]:
   if not used[child]:
    dfs(child)
    res = max(res, sum(dpths[child]))
    heapq.heappush(dpths[node], max(dpths[child]) + 1)
    heapq.heappop(dpths[node])
 dfs(1)
 # print(dpths)
 return max(res, sum(dpths[1]))


# more elegant solution (any node -> farthes u, u -> farthest v)
def iterative(node):
 s = [node]
 pts = [0] * len(used)
 dist = [0] * len(used)
 while s:
  node = s[-1]
  used[node] = 1
  pt = pts[node]
  if pt == len(children[node]):
   s.pop()
  else:
   child = children[node][pt]
   if not used[child]:
    s.append(child)
    dist[child] = dist[node] + 1
   pts[node] += 1

 res, node = 0, None
 for el, d in enumerate(dist):
  if d > res:
   node = el
   res = d
 # print(dist)
 return node, res

if n == 1:
 print(0)
 exit()
a, d = iterative(1)
used = [0] * (n + 1)
b, d = iterative(a)
print(d)

# print(recursive())