import sys
from collections import defaultdict , deque , Counter
n , m = map(int , sys.stdin.readline().rstrip().split())
distances = [0 for _ in range(n + 1)]

graph = []
bfs = [float('inf') for _ in range(n + 1)]
for _ in range(m):
    start , end , width = map(int , sys.stdin.readline().rstrip().split())

    graph.append((start , end , width))
    bfs[end]= start

for _ in range(n - 1):
    count = 0
    for start , end , width in graph:
        if distances[start] != float('inf') and  distances[start] + width < distances[end]:
            distances[end] = distances[start] + width
            bfs[end] = start
            count += 1    
    if count == 0:
        break
nodes = []
find = 0
for start , end , width in graph:
    if distances[start] + width < distances[end]:
        find += 1
        nodes = end
        break
if find == 0:
    print('NO')
    exit()

print('YES')

visited = set()
lastRelaxed = nodes
path = []
while True:
    if lastRelaxed == float('inf'):
        path.append(1)
        break
    path.append(lastRelaxed)
    if lastRelaxed in visited:
        break

    visited.add(lastRelaxed)
    lastRelaxed = bfs[lastRelaxed]

print(*reversed(path))