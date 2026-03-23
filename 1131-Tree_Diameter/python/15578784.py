import sys

def solve():
    data = sys.stdin.read().split()
    if not data: return
    it = iter(map(int, data))

    try:
        n = next(it)
    except StopIteration:
        return

    adj = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        u = next(it)
        v = next(it)
        adj[u].append(v)
        adj[v].append(u)

    def bfs(start):
        dist = [-1] * (n + 1)
        dist[start] = 0
        queue = [start]
        head = 0
        max_dist = 0
        far_node = start

        while head < len(queue):
            u = queue[head]
            head += 1
            if dist[u] > max_dist:
                max_dist = dist[u]
                far_node = u

            for v in adj[u]:
                if dist[v] == -1:
                    dist[v] = dist[u] + 1
                    queue.append(v)
        return far_node, max_dist

    node_a, _ = bfs(1)
    _, diameter = bfs(node_a)

    print(diameter)

if __name__ == "__main__":
    solve()