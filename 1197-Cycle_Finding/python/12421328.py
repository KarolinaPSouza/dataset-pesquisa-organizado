import sys

INF = 10**18

input = sys.stdin.buffer.readline  # Redefine input for speed.
n, m = map(int, input().split())

edges = []
for _ in range(m):
    a, b, c = map(int, input().split())
    edges.append((a-1, b-1, c))

dist = [INF] * n
prev = [-1] * n
dist[0] = 0

for _ in range(n-1):
    for a, b, c in edges:
        if dist[b] > dist[a]+c:
            dist[b] = dist[a]+c
            prev[b] = a

node_in_cycle = None
for a, b, c in edges:
    if dist[b] > dist[a]+c:
        prev[b] = a
        node_in_cycle = b

if node_in_cycle is None:
    print("NO")
else:
    print("YES")
    nodes = []
    node_positions = [-1] * n
    node = node_in_cycle
    while node_positions[node] == -1:
        node_positions[node] = len(nodes)
        nodes.append(node)
        node = prev[node]
    nodes.append(node)
    nodes = nodes[node_positions[node]:]
    print(' '.join(map(lambda x: str(x+1), nodes[::-1])))