class Tree:
    def __init__(self, n):

        self.n = n
        self.edges = [[] for _ in range(n + 1)]

    def add_edge(self, a, b):

        self.edges[a].append(b)
        self.edges[b].append(a)

    def bfs(self, start):

        queue = [start]
        visited = [-1] * (self.n + 1)
        visited[start] = 0
        farthest_node = start
        max_distance = 0

        for node in queue:
            for neighbor in self.edges[node]:
                if visited[neighbor] == -1:
                    visited[neighbor] = visited[node] + 1
                    queue.append(neighbor)
                    if visited[neighbor] > max_distance:
                        max_distance = visited[neighbor]
                        farthest_node = neighbor

        return farthest_node, max_distance

    def find_diameter(self):

        farthest_node1, _ = self.bfs(1)
        _, diameter = self.bfs(farthest_node1)
        return diameter

n = int(input())
tree = Tree(n)

for _ in range(n - 1):
    a, b = map(int, input().split())
    tree.add_edge(a, b)

print(tree.find_diameter())