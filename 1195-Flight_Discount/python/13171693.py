import sys
import heapq

def solve():
    input = sys.stdin.readline
    n, m = map(int, input().split())

    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a, b, c = map(int, input().split())
        graph[a].append((b, c))

    INF = float('inf')
    dp = [[INF, INF] for _ in range(n+1)]
    dp[1][0] = 0
    pq = [(0, 1, 0)]

    while pq:
        cost, city, used = heapq.heappop(pq)
        if cost > dp[city][used]:
            continue

        for next_city, price in graph[city]:
            next_cost = cost + price
            if next_cost < dp[next_city][used]:
                dp[next_city][used] = next_cost
                heapq.heappush(pq, (next_cost, next_city, used))

            if used == 0:
                discounted_cost = cost + (price // 2)
                if discounted_cost < dp[next_city][1]:
                    dp[next_city][1] = discounted_cost
                    heapq.heappush(pq, (discounted_cost, next_city, 1))

    answer = min(dp[n][0], dp[n][1])
    print(answer)

if __name__ == "__main__":
    solve()