import sys
sys.setrecursionlimit(1 << 25)
from collections import defaultdict, deque

def read_input():
    n = int(sys.stdin.readline())
    edges = defaultdict(list)
    for _ in range(n - 1):
        a, b = map(int, sys.stdin.readline().split())
        edges[a].append(b)
        edges[b].append(a)
    return n, edges

def bfs(start, n, edges):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])
    while q:
        node = q.popleft()
        for neighbor in edges[node]:
            if dist[neighbor] == -1:
                dist[neighbor] = dist[node] + 1
                q.append(neighbor)
    farthest_node = dist.index(max(dist))
    return farthest_node, dist

def main():
    n, edges = read_input()

    # 1. Find one end of the diameter
    node_a, _ = bfs(1, n, edges)

    # 2. Find the other end and record distances
    node_b, dist_a = bfs(node_a, n, edges)

    # 3. Get distances from the other end
    _, dist_b = bfs(node_b, n, edges)

    # 4. Max distance for each node is the max from both ends
    result = [str(max(dist_a[i], dist_b[i])) for i in range(1, n + 1)]
    print(" ".join(result))

if __name__ == "__main__":
    main()