# CSES 1131 Tree Diameter
# Date: 2022/06/04
# Solution Idea:
#   Do BFS twice.

from collections import defaultdict, deque


def bfs(tree, start):
    """Compute distances of all nodes relative to start"""
    furthest_node = start
    max_distance = 0
    distances = {start: 0}
    queue = deque([start])
    visited = [False] * (len(tree) + 2)
    visited[start] = True
    while queue:
        current_node = queue.popleft()
        current_distance = distances[current_node] + 1

        for child in tree[current_node]:
            if visited[child]:
                continue
            distances[child] = current_distance
            visited[child] = True
            queue.append(child)
            if current_distance > max_distance:
                max_distance = current_distance
                furthest_node = child

    return max_distance, furthest_node


def solve():
    tree = defaultdict(list)
    n = int(input())
    for _ in range(n - 1):
        a, b = list(map(int, input().split()))
        tree[a].append(b)
        tree[b].append(a)

    _, furthest_node = bfs(tree, 1)
    max_distance, _ = bfs(tree, furthest_node)
    print(max_distance)


if __name__ == "__main__":
    solve()