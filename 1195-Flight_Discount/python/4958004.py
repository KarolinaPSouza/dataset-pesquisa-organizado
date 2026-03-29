# We need to use a lot of optomizations as python is slow

import heapq
# import sys
# sys.stdin = open('input.txt', 'r')

# This ultra-fast IO barely allows it to not TLE
import io
import os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

INF = 10 ** 18  # Using float('inf') will TLE

# Putting code in functions makes it faster due to local/global scopes


def dijkstra(graph, num_nodes, start_node):
    completed = [False] * num_nodes
    dist = [INF] * num_nodes

    dist[start_node] = 0
    queue = [(0, start_node)]  # dist, node
    heapq.heapify(queue)

    while queue:
        curr_dist, curr_node = heapq.heappop(queue)

        if completed[curr_node]:
            continue
        completed[curr_node] = True

        for adj, weight in graph[curr_node]:
            new_dist = curr_dist + weight
            if new_dist < dist[adj]:
                dist[adj] = new_dist
                heapq.heappush(queue, (dist[adj], adj))

    return dist


def main():
    n, m = map(int, input().split())
    graph_front = [[] for _ in range(n)]
    graph_back = [[] for _ in range(n)]
    for _ in range(m):
        a, b, c = map(int, input().split())
        graph_front[a - 1].append((b - 1, c))
        graph_back[b - 1].append((a - 1, c))

    dist_front = dijkstra(graph_front, n, 0)  # shortest dist from Syrjala
    dist_back = dijkstra(graph_back, n, n - 1)  # shortest dist from Metsala

    min_cost = INF
    for from_node, adj_list in enumerate(graph_front):
        for to_node, price in adj_list:
            new_total_price = dist_front[from_node] + price // 2 + dist_back[to_node]
            if new_total_price < min_cost:
                min_cost = new_total_price

    print(min_cost)


if __name__ == '__main__':
    main()