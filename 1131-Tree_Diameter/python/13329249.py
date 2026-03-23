import sys
input = sys.stdin.readline  # redefine input for performance reasons
sys.setrecursionlimit(10**7)
# iterative DFS necessary in order to AC; recursive TLEs
def iterative_dfs(start):
 dist = [-1] * n
 stack = [start]
 dist[start] = 0
 while stack:
  curr = stack.pop()
  for nxt in adj[curr]:
   if dist[nxt] == -1:
    dist[nxt] = dist[curr] + 1
    stack.append(nxt)
 return dist
n = int(input())
adj = [[] for _ in range(n)]
for _ in range(n - 1):
 a, b = map(int, input().split())
 a -= 1
 b -= 1
 adj[a].append(b)
 adj[b].append(a)
# dfs from node 0 to find endpoint of diameter
dist = iterative_dfs(0)
start = max(range(n), key=lambda i: dist[i])
# dfs from endpoint of diameter to find other endpoint
dist = iterative_dfs(start)
print(max(dist))