class Queue:
    def __init__(self):
        self.data = []
        self.front = 0

    def enqueue(self, item):
        self.data.append(item)

    def dequeue(self):
        if self.front >= len(self.data):
            return None
        item = self.data[self.front]
        self.front += 1
        return item

    def is_empty(self):
        return self.front == len(self.data)

def bfs(start, adj, n):
    visited = [False] * (n + 1)
    q = Queue()
    q.enqueue((start, 0))
    visited[start] = True
    max_dist = 0
    farthest_node = start

    while not q.is_empty():
        current = q.dequeue()
        if current is None:
            break
        node, dist = current
        if dist > max_dist:
            max_dist = dist
            farthest_node = node
        for neighbor in adj[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                q.enqueue((neighbor, dist + 1))
    return farthest_node, max_dist

n = int(input())
if n <= 1:
    print(0)
else:
    adj = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        a, b = map(int, input().split())
        adj[a].append(b)
        adj[b].append(a)

    u, _ = bfs(1, adj, n)
    v, diameter = bfs(u, adj, n)
    print(diameter)