import sys, heapq

def dijkstra(v, n):
    INF = 1e18
    distance = [INF for _ in range(2*(n+1))]

    distance[v] = 0
    q = [(0, v)] #(w, v)

    while q:
        w_node, node = heapq.heappop(q)

        if w_node > distance[node]: continue

        for neighbor, w_neighbor in graph[node]:
            new_dist = w_node + w_neighbor
            if new_dist < distance[neighbor]:
                distance[neighbor] = new_dist
                heapq.heappush(q, (new_dist, neighbor))

    return distance


n, m = [int(i) for i in sys.stdin.readline().split()]

graph = [[] for _ in range(2*(n+1))]
for _ in range(m):
    u, v, w = [int(i) for i in sys.stdin.readline().split()]
    graph[u*2].append((v*2, w)) #2*u node sem ter usado cupom
    graph[u*2].append((v*2+1, w//2)) #2*u+1 node já tendo usado o cupom
    graph[u*2+1].append((v*2+1, w))

distance = dijkstra(2, n)

print(distance[2*n+1])