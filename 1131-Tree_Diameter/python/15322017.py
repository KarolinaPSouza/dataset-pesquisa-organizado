import sys
from collections import deque
sys.setrecursionlimit(300000)
input = sys.stdin.readline

def bfs(start, n, adj):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])
    farthest_node = start

    while q:
        node = q.popleft()
        for nei in adj[node]:
            if dist[nei] == -1:
                dist[nei] = dist[node] + 1
                q.append(nei)
                if dist[nei] > dist[farthest_node]:
                    farthest_node = nei
    return farthest_node, dist[farthest_node]

# Main
n = int(input())
adj = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)

# Step 1: BFS from node 1 to find farthest node u
u, _ = bfs(1, n, adj)

# Step 2: BFS from u to find farthest node v
v, diameter = bfs(u, n, adj)

print(diameter)#h