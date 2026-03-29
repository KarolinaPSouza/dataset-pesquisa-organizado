# You are given a directed graph, and your task is to find out if it contains a negative cycle, and also give an example of such a cycle.

# Input
# The first input line has two integers n and m: the number of nodes and edges. The nodes are numbered 1,2,\ldots,n.
# After this, the input has m lines describing the edges. Each line has three integers a, b, and c: there is an edge from node a to node b whose length is c.

# Output
# If the graph contains a negative cycle, print first "YES", and then the nodes in the cycle in their correct order. If there are several negative cycles, you can print any of them. If there are no negative cycles, print "NO".

# Constraints

# 1 \le n \le 2500
# 1 \le m \le 5000
# 1 \le a,b \le n
# -10^9 \le c \le 10^9

# Bellman-Ford with a twist
# - need a super node that is connected to all others with weight 0

n, m = map(int, input().split())
edges = []
for _ in range(m):
    a, b, w = map(int, input().split())
    edges.append((a, b, w))

for i in range(n):
    edges.append((0, i + 1, 0))

# vertex 0 is connected to each node with weight 0
# Bellman-Ford
dist = [0] * (n + 1)
for _ in range(n - 1):
    for a, b, w in edges:
        dist[b] = min(dist[b], dist[a] + w)

# get parents to build negative cycle
starting_node = -1
parent = [-1] * (n + 1)
for _ in range(n):
    for a, b, w in edges:
        if dist[b] > dist[a] + w:
            parent[b] = a
            dist[b] = dist[a] + w
            starting_node = b



if starting_node == -1:
    print("NO")
else:
    print("YES")

    for _ in range(n):
        starting_node = parent[starting_node]

    # build cycle path
    path = []
    path.append(starting_node)
    node = parent[starting_node]
    while node != starting_node:

        path.append(node)
        node = parent[node]
    path.append(starting_node)

    path.reverse()
    path = " ".join(map(str, path))
    print(path)



