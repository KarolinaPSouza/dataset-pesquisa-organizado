import sys
sys.setrecursionlimit(2 * 10**5)

class Tree:
    def __init__(self, n):
        self.n = n
        self.adj_list = [[] for _ in range(n + 1)]

    def add_edge(self, a, b):
        self.adj_list[a].append(b)
        self.adj_list[b].append(a)

    def bfs(self, start):
        queue = [start]
        distances = [-1] * (self.n + 1)
        distances[start] = 0
        farthest_node, max_distance = start, 0

        front = 0  # Índice para simulación eficiente de cola
        while front < len(queue):
            node = queue[front]
            front += 1
            for neighbor in self.adj_list[node]:
                if distances[neighbor] == -1:
                    distances[neighbor] = distances[node] + 1
                    queue.append(neighbor)
                    if distances[neighbor] > max_distance:
                        max_distance = distances[neighbor]
                        farthest_node = neighbor

        return farthest_node, max_distance

    def find_diameter(self):
        if self.n == 1:
            return 0
        farthest_node, _ = self.bfs(1)
        _, diameter = self.bfs(farthest_node)
        return diameter

n = int(sys.stdin.readline().strip())
tree = Tree(n)
for _ in range(n - 1):
    a, b = map(int, sys.stdin.readline().split())
    tree.add_edge(a, b)

diameter = tree.find_diameter()
print(diameter)