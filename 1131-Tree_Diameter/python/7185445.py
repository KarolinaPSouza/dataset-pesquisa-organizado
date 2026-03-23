import sys
input = sys.stdin.readline
print = sys.stdout.write

from collections import deque

n = int(input())
adj = [[] for i in range(n + 1)]
vis = [False] * (n + 1)
for i in range(n - 1):
 u, v = map(int, input().split())
 adj[u].append(v)
 adj[v].append(u)

def bfs1():
 q = deque()
 q.append(1)
 vis[1] = True
 furthest = 1
 while q:
  curr = q.popleft()
  furthest = curr
  for neigh in adj[curr]:
   if not vis[neigh]:
    vis[neigh] = True
    q.append(neigh)
 return furthest

def bfs2(start):
 q = deque()
 q.append(start)
 vis[start] = True
 level = -1
 while q:
  for i in range(len(q)):
   curr = q.popleft()
   for neigh in adj[curr]:
    if not vis[neigh]:
     vis[neigh] = True
     q.append(neigh)
  level += 1
 return level

start = bfs1()
for i in range(1, n + 1):
 vis[i] = False
print(str(bfs2(start)))