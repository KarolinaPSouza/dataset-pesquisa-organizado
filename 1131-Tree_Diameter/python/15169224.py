import sys
from collections import deque
input = sys.stdin.readline  # faster input
#code
def bfs(start, graph, n):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])
    farthest_node = start

    while q:
        node = q.popleft()
        for nei in graph[node]:
            if dist[nei] == -1:
                dist[nei] = dist[node] + 1
                q.append(nei)
                if dist[nei] > dist[farthest_node]:
                    farthest_node = nei
    return farthest_node, dist[farthest_node]


def main():
    n = int(input())
    graph = [[] for _ in range(n + 1)]

    for _ in range(n - 1):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    # First BFS from node 1 to find farthest node
    u, _ = bfs(1, graph, n)
    # Second BFS from u to get the diameter
    _, diameter = bfs(u, graph, n)

    sys.stdout.write(str(diameter) + "\n")


if __name__ == "__main__":
    main()