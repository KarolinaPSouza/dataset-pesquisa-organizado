from sys import stdin, stdout
input = stdin.buffer.readline
from heapq import heappop, heappush
INF = 1<<50

n, m = map(int,input().split())
graph = [[] for _ in range(n)]
for _ in range(m):
    a, b, c = map(int,input().split())
    graph[a - 1].append((b - 1, c))
dist = [INF] * n
dist_used = [INF] * n
dist[0] = dist_used[0] = 0
seen = [[0] * n for _ in range(2)]
start, target = 0, n - 1
heap = [(0, start)]
while heap:
    current_cost, node = heappop(heap)
    used = False if dist[node] == current_cost else True
    if seen[used][node]:
        continue
    seen[used][node] = True
    if node == target:
        print(current_cost)
        break
    for neigh, weight in graph[node]:
        newcost = current_cost + weight
        if used and newcost < dist_used[neigh]:
            dist_used[neigh] = newcost
            heappush(heap, (newcost, neigh))
        elif not used:
            if newcost < dist[neigh]:
                dist[neigh] = newcost
                heappush(heap, (newcost, neigh))
            costhalved = current_cost + weight // 2
            if costhalved < dist_used[neigh]:
                dist_used[neigh] = costhalved
                heappush(heap, (costhalved, neigh))