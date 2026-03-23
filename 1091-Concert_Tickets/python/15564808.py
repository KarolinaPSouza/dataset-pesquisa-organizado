"""
https://cses.fi/problemset/task/1131
"""

from collections import deque


def bfs(start: int, adj: list) -> tuple:
    distances = [-1] * len(adj)
    # (node, distance to start node)
    queue = deque([(start, 0)])
    furthest = (0, start)  # (dist, node)
    while queue:
        node, dist = queue.popleft()
        distances[node] = dist
        if dist > furthest[0]:
            furthest = (dist, node)
        for child in adj[node]:
            if -1 == distances[child]:
                queue.append((child, dist + 1))
    return furthest


def dfs(start: int, adj: list) -> tuple:
    distances = [-1] * len(adj)
    # (node, distance to start node)
    stack = [(start, 0)]
    furthest = (0, start)  # (dist, node)
    while stack:
        node, dist = stack.pop()
        distances[node] = dist
        if dist > furthest[0]:
            furthest = (dist, node)
        for child in adj[node]:
            if -1 == distances[child]:
                stack.append((child, dist + 1))
    return furthest


def solve(adj: list) -> int:
    _, max_dist_node = bfs(0, adj)
    max_dist, _ = bfs(max_dist_node, adj)
    # _, max_dist_node = dfs(0, adj)
    # max_dist, _ = dfs(max_dist_node, adj)
    return max_dist


def main():
    n = int(input().strip())
    adj = [[] for _ in range(n)]
    for _ in range(n - 1):
        a, b = map(int, input().strip().split())
        a -= 1
        b -= 1  # 0-indexed
        adj[a].append(b)
        adj[b].append(a)

    ans = solve(adj)
    print(ans)


main()