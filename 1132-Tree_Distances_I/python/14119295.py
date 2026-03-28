import sys
from collections import deque

# Use sys.stdin.read() to read all input at once for faster processing
input = sys.stdin.read
data = input().splitlines()

n = int(data[0])

if n == 1:
    sys.stdout.write("0\n")
    exit()

# Initialize adjacency list and other variables
adjlis = {}
mega = [0] * (n + 1)

# Process edges
for i in range(1, n):
    a, b = map(int, data[i].split())
    if a not in adjlis:
        adjlis[a] = []
    if b not in adjlis:
        adjlis[b] = []
    adjlis[a].append(b)
    adjlis[b].append(a)

# BFS function
def bfs(graph, start):
    distances = [0] * (n + 1)
    visited = set()
    queue = deque([[start, 0]])
    visited.add(start)

    ma = 0
    manode = start

    while queue:
        node, ht = queue.popleft()
        distances[node] = ht
        if ht > ma:
            ma = ht
            manode = node
        for neighbor in graph[node]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append([neighbor, ht + 1])

    return distances

# First BFS from node 1
li1 = bfs(adjlis, 1)

# Find farthest node from node 1
farthest_node_from_1 = li1.index(max(li1))

# Second BFS from farthest node found
li2 = bfs(adjlis, farthest_node_from_1)

# Find farthest node from the second BFS
farthest_node_from_second = li2.index(max(li2))

# Third BFS from the second farthest node
li3 = bfs(adjlis, farthest_node_from_second)

# Output the maximum distance for each node
output = []
for i in range(1, n + 1):
    output.append(str(max(li1[i], li2[i], li3[i])))

sys.stdout.write(" ".join(output) + "\n")