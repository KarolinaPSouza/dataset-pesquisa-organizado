import sys
from collections import deque

def bfs(start, graph, n):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])
    farthest_node = start
    while q:
        u = q.popleft()
        for v in graph[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
                if dist[v] > dist[farthest_node]:
                    farthest_node = v
    return farthest_node, dist

def main():
    input = sys.stdin.readline
    n = int(input())
    graph = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    u, _ = bfs(1, graph, n)
    v, dist_u = bfs(u, graph, n)

    _, dist_v = bfs(v, graph, n)


    result = [str(max(dist_u[i], dist_v[i])) for i in range(1, n + 1)]
    print(" ".join(result))

if __name__ == "__main__":
    main()