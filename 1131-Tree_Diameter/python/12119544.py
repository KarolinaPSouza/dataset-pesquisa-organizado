import sys
from collections import deque

def bfs(start, n, graph):
    visited = [-1] * (n + 1)
    queue = deque([start])
    visited[start] = 0
    farthest_node = start
    max_distance = 0
    while queue:
        node = queue.popleft()
        for neighbor in graph[node]:
            if visited[neighbor] == -1:
                visited[neighbor] = visited[node] + 1
                queue.append(neighbor)
                if visited[neighbor] > max_distance:
                    max_distance = visited[neighbor]
                    farthest_node = neighbor
    return farthest_node, max_distance

def main():
    data = sys.stdin.read().split()
    n = int(data[0])
    graph = [[] for _ in range(n + 1)]
    index = 1
    for _ in range(n - 1):
        a = int(data[index])
        b = int(data[index + 1])
        index += 2
        graph[a].append(b)
        graph[b].append(a)
    farthest, _ = bfs(1, n, graph)
    _, diameter = bfs(farthest, n, graph)
    print(diameter)

if __name__ == '__main__':
    main()