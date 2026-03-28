import sys
from collections import deque
input = sys.stdin.readline

def bfs(start, graph, n):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])

    while q:
        v = q.popleft()
        for u in graph[v]:
            if dist[u] == -1:
                dist[u] = dist[v] + 1
                q.append(u)

    farthest = dist.index(max(dist))
    return farthest, dist

def main():
    n = int(input())
    graph = [[] for _ in range(n + 1)]

    for _ in range(n - 1):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    # Step 1: BFS from any node (1)
    A, _ = bfs(1, graph, n)

    # Step 2: BFS from A
    B, distA = bfs(A, graph, n)

    # Step 3: BFS from B
    _, distB = bfs(B, graph, n)

    # Step 4: eccentricity for each node
    ans = [max(distA[i], distB[i]) for i in range(1, n+1)]
    print(*ans)

main()