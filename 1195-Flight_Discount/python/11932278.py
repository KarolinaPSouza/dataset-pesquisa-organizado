from heapq import heappush, heappop
import sys

def find_cheapest_route(n, edges):
    graph = [[] for _ in range(n + 1)]
    for a, b, c in edges:
        graph[a].append((b, c))

    INF = float('inf')
    dist_no_coupon = [INF] * (n + 1)
    dist_used_coupon = [INF] * (n + 1)
    dist_no_coupon[1] = 0

    pq = [(0, 1, False)]  # (cost, node, coupon_used)

    while pq:
        cost, node, used_coupon = heappop(pq)

        if used_coupon and cost > dist_used_coupon[node]:
            continue
        if not used_coupon and cost > dist_no_coupon[node]:
            continue

        for next_node, price in graph[node]:
            if not used_coupon:
                new_cost = cost + price
                if new_cost < dist_no_coupon[next_node]:
                    dist_no_coupon[next_node] = new_cost
                    heappush(pq, (new_cost, next_node, False))

                new_cost = cost + (price >> 1)
                if new_cost < dist_used_coupon[next_node]:
                    dist_used_coupon[next_node] = new_cost
                    heappush(pq, (new_cost, next_node, True))
            else:
                new_cost = cost + price
                if new_cost < dist_used_coupon[next_node]:
                    dist_used_coupon[next_node] = new_cost
                    heappush(pq, (new_cost, next_node, True))

    return min(dist_no_coupon[n], dist_used_coupon[n])

def main():
    input = sys.stdin.read
    data = input().split()

    n, m = map(int, (data[0], data[1]))
    edges = []
    index = 2
    for _ in range(m):
        a, b, c = map(int, (data[index], data[index+1], data[index+2]))
        edges.append((a, b, c))
        index += 3

    print(find_cheapest_route(n, edges))

if __name__ == "__main__":
    main()