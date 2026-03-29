import sys
from sys import stdin, stdout
from heapq import heappop, heappush

n, m = map(int, stdin.readline().split())
distance = [sys.maxsize] * (n + 1)
distance_trans = [sys.maxsize] * (n + 1)
distance[1] = 0
distance_trans[n] = 0
edge_list = []

adj_list = {i + 1: [] for i in range(n)}
adj_list_trans = {i + 1: [] for i in range(n)}


for _ in range(m):
    a, b, weight = map(int, stdin.readline().split())
    adj_list[a].append((b, weight))
    adj_list_trans[b].append((a, weight))
    edge_list.append((a, b, weight))

# here 1 is the source node
q = [(0, 1)]

while len(q) > 0:
    dist, node = heappop(q)

    if dist != distance[node]:
        continue

    for pair in adj_list[node]:
        if distance[node] + pair[1] < distance[pair[0]]:
            distance[pair[0]] = distance[node] + pair[1]
            # heappush(q, (distance[pair[0]], pair[0]))
            q.append((distance[pair[0]], pair[0]))

q = [(0, n)]
while len(q) > 0:
    dist, node = heappop(q)

    if dist != distance_trans[node]:
        continue

    for pair in adj_list_trans[node]:
        if distance_trans[node] + pair[1] < distance_trans[pair[0]]:
            distance_trans[pair[0]] = distance_trans[node] + pair[1]
            # heappush(q, (distance_trans[pair[0]], pair[0]))
            q.append((distance_trans[pair[0]], pair[0]))

# print(distance)
# print(distance_trans)

min_dist = sys.maxsize

for edge in edge_list:

    a, b, weight = edge

    # print(distance[a], distance_trans[b], weight // 2)
    ans = distance[a] + distance_trans[b] + (weight // 2)
    if ans < min_dist:
        min_dist = ans

print(min_dist)