from collections import deque
import sys
input = sys.stdin.readline

def bfs(start, adj):
    n = len(adj)
    visited = [False] * n 
    visited[start] = True
    dist = [-1] * n # dist[x] = distance of x from start
    dist[start] = 0
    q = deque()
    q.append(start)

    far = start
    while q:
        u = q.popleft()
        for v in adj[u]:
            if not visited[v]:
                visited[v] = True 
                dist[v] = dist[u] + 1
                q.append(v)
                if dist[v] > dist[far]:
                    far = v 

    return far, dist[far] # far is the farthest node from start

def main():
    n = int(input())
    adj = [[] for _ in range(n)]

    for _ in range(n - 1):
        u, v = map(int, input().split(' '))
        adj[u-1].append(v-1)
        adj[v-1].append(u-1)

    a, _ = bfs(0, adj)
    _, diameter = bfs(a, adj)

    print(diameter)

main()