import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
G = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    G[a].append(b)
    G[b].append(a)

def farthest(start):
    seen = [-1] * (n + 1)
    seen[start] = 0
    q = deque([start])

    last = start
    while q:
        u = q.popleft()
        last = u
        d = seen[u]
        for v in G[u]:
            if seen[v] == -1:
                seen[v] = d + 1
                q.append(v)
    return last, seen[last]


# 1st BFS: find farthest node from 1
x, _ = farthest(1)

# 2nd BFS: find farthest from x → diameter
y, diameter = farthest(x)

print(diameter)