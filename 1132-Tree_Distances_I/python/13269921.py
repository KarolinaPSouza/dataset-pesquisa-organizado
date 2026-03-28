from collections import deque

def bfs(start, graph, n):
    dist = [-1] * (n + 1)
    q = deque([start])
    dist[start] = 0
    while q:
        node = q.popleft()
        for neighbor in graph[node]:
            if dist[neighbor] == -1:
                dist[neighbor] = dist[node] + 1
                q.append(neighbor)
    farthest_node = dist.index(max(dist))
    return farthest_node, dist

def main():
    import sys
    sys.setrecursionlimit(1 << 25)
    input = sys.stdin.read
    data = input().split()

    idx = 0
    n = int(data[idx])
    idx += 1

    graph = [[] for _ in range(n + 1)]

    for _ in range(n - 1):
        a = int(data[idx])
        b = int(data[idx + 1])
        graph[a].append(b)
        graph[b].append(a)
        idx += 2

    # Step 1: Find one end of the diameter
    A, _ = bfs(1, graph, n)

    # Step 2: Find the other end of the diameter
    B, distA = bfs(A, graph, n)

    # Step 3: Get distances from B
    _, distB = bfs(B, graph, n)

    # Step 4: For each node, max(dist to A, dist to B)
    res = [str(max(distA[i], distB[i])) for i in range(1, n + 1)]
    print(' '.join(res))

if __name__ == "__main__":
    main()