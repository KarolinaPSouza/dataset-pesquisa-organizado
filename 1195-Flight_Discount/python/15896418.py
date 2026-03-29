import sys
from heapq import heappush, heappop

input = sys.stdin.readline

def main():
    n, m = map(int, input().split())
    graph = [[] for _ in range(n + 1)]

    for _ in range(m):
        a, b, c = map(int, input().split())
        graph[a].append((b, c))

    INF = 10**18
    dist = [[INF] * 2 for _ in range(n + 1)]  # dist[node][state]
    # state 0 = discount not used
    # state 1 = discount used

    pq = []
    dist[1][0] = 0
    heappush(pq, (0, 1, 0))   # (cost, city, state)

    while pq:
        cost, city, state = heappop(pq)

        if cost > dist[city][state]:
            continue

        for nxt, w in graph[city]:
            # Case 1: don't use discount
            new_cost = cost + w
            if new_cost < dist[nxt][state]:
                dist[nxt][state] = new_cost
                heappush(pq, (new_cost, nxt, state))

            # Case 2: use discount (only if not used yet)
            if state == 0:
                disc_cost = cost + w // 2
                if disc_cost < dist[nxt][1]:
                    dist[nxt][1] = disc_cost
                    heappush(pq, (disc_cost, nxt, 1))

    print(min(dist[n][0], dist[n][1]))

if __name__ == "__main__":
    main()