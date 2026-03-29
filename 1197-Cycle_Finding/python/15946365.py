from collections import deque

class Node:
    def __init__(self, v):
        self.v = v
        self.e = []

v, e = map(int, input().split())
adj = []
for i in range(e):
    adj.append(list(map(int, input().split())))

dist = [0] * (v+1)
parent = [-1] * (v+1)

x = -1
for i in range(e):
    x = -1
    for a, b, c in adj:
        if(dist[a] + c < dist[b]):
            dist[b] = dist[a] + c
            parent[b] = a
            x = b

if (x == -1):
    print ('NO')
else:
    print ('YES')
    cycle = []
    seen = set()
    while (x not in seen):
        cycle.append(x)
        seen.add(x)
        x = parent[x]
    cycle.append(x)
    for i in range(len(cycle)):
        if (cycle[i] == cycle[-1]):
            cycle = cycle[i:]
            break
    print (' '.join([str(i) for i in cycle[::-1]]))