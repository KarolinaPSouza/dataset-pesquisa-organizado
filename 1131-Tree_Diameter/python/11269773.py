from collections import defaultdict, deque

import sys

input = sys.stdin.read
data = input().splitlines()
# Bemenet feldolgozása
n = int(data[0])  # Csúcsok száma
edges = [tuple(map(int, line.split())) for line in data[1:]]

# Szomszédsági lista létrehozása
graph = defaultdict(list)
for a, b in edges:
    graph[a].append(b)
    graph[b].append(a)


def bfs(start):
    """Szélességi keresés (BFS), amely visszaadja a legtávolabbi csúcsot és a távolságát."""
    visited = [-1] * (n + 1)  # -1: még nem látogatott csúcsok
    queue = deque([start])
    visited[start] = 0  # A kezdőcsúcs távolsága 0
    farthest_node = start

    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if visited[neighbor] == -1:  # Ha még nem látogattuk meg
                visited[neighbor] = visited[current] + 1  # Távolság frissítése
                queue.append(neighbor)
                if visited[neighbor] > visited[farthest_node]:  # Legtávolabbi csúcs frissítése
                    farthest_node = neighbor

    return farthest_node, visited[farthest_node]  # Visszaadjuk a legtávolabbi csúcsot és a távolságot

# 1. Első BFS a 1-es csúcsról (vagy bármelyik tetszőleges csúcsról)
farthest_node1, _ = bfs(1)

# 2. Második BFS a legelső BFS-ben talált legtávolabbi csúcsról
_, diameter = bfs(farthest_node1)

# Az átmérő kiírása
print(diameter)