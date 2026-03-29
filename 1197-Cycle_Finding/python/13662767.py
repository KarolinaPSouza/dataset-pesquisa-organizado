import sys
input = sys.stdin.readline

n, m = map(int, input().split())

edges = []

for _ in range(m):
    a, b, c = map(int, input().split())
    edges.append((a, b, c))

distance = [0] * (n + 1)
parent = [-1] * (n + 1)

x = -1

# Bellman-Ford: n iterations
for i in range(1, n + 1):
    x = -1
    for u, v, w in edges:
        if distance[v] > distance[u] + w:
            distance[v] = distance[u] + w
            parent[v] = u
            x = v

if x == -1:
    print("NO")
else:
    # Ensure x is in the cycle
    for _ in range(n):
        x = parent[x]

    cycle = []
    cur = x
    while True:
        cycle.append(cur)
        cur = parent[cur]
        if cur == x:
            break
    cycle.append(x)
    cycle.reverse()

    print("YES")
    print(" ".join(map(str, cycle)))