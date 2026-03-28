import sys
input = sys.stdin.buffer.readline

n = int(input())
tree = [[] for _ in range(n)]
for _ in range(n - 1):
    u, v = map(int,input().split())
    tree[u - 1].append(v - 1)
    tree[v - 1].append(u - 1)

fsMax = [0] * n
sdMax = [0] * n
c = [None] * n
time_seen = [-1] * n
time_seen[0] = 0
parent = [None] * n
tovisit = [0]
order = []
while tovisit:
    node = tovisit[-1]
    if time_seen[node] == len(tree[node]):
        for neigh in tree[node]:
            if neigh == parent[node]:
                continue
            if fsMax[node] < fsMax[neigh] + 1:
                sdMax[node] = fsMax[node]
                fsMax[node] = fsMax[neigh] + 1
                c[node] = neigh
            elif sdMax[node] < fsMax[neigh] + 1:
                sdMax[node] = fsMax[neigh] + 1
        tovisit.pop()
        order.append(node)
    else:
        neigh = tree[node][time_seen[node]]
        if neigh == parent[node]:
            time_seen[node] += 1
            if time_seen[node] == len(tree[node]):
                continue
            neigh = tree[node][time_seen[node]]
        time_seen[node] += 1
        time_seen[neigh] = 0
        parent[neigh] = node
        tovisit.append(neigh)

for node in reversed(order):
    prev = parent[node]
    if prev is None:
        continue
    if c[prev] == node:
        if fsMax[node] < sdMax[prev] + 1:
            sdMax[node] = fsMax[node]
            fsMax[node] = sdMax[prev] + 1
            c[node] = prev
        else:
            sdMax[node] = max(sdMax[node], sdMax[prev] + 1)
    else:
        sdMax[node] = fsMax[node]
        fsMax[node] = fsMax[prev] + 1
        c[node] = prev

print(*fsMax)