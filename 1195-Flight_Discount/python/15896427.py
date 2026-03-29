from dataclasses import dataclass
from heapq import heappop, heappush
import sys

def main():
    input = sys.stdin.readline
    n, m = map(int, input().split())
    flights_from_cities = [list() for _ in range(n+1)]

    for _ in range(m):
        from_city, to_city, cost = map(int, input().split())
        flights_from_cities[from_city].append((to_city, cost))

    pq = []
    dp_discount_used = [float('inf')] * (n + 1)
    dp_discount_unused = [float('inf')] * (n + 1)
    heappush(pq, (0, 1, True))
    dp_discount_used[1] = 0
    dp_discount_unused[1] = 0

    while len(pq) > 0:
        curr_cost, city, discount_available = heappop(pq)
        if discount_available and curr_cost > dp_discount_unused[city]:
            continue
        if not discount_available and curr_cost > dp_discount_used[city]:
            continue

        for to_city, flight_cost in flights_from_cities[city]:
            # print(f"  Considering flight to {to_city} with cost {flight_cost}")
            new_cost = curr_cost + flight_cost

            if discount_available:
                discounted_cost = curr_cost + flight_cost // 2
                if discounted_cost < dp_discount_used[to_city]:
                    dp_discount_used[to_city] = discounted_cost
                    heappush(pq, (discounted_cost, to_city, False))
                if new_cost < dp_discount_unused[to_city]:
                    dp_discount_unused[to_city] = new_cost
                    heappush(pq, (new_cost, to_city, True))
            else:
                if new_cost < dp_discount_used[to_city]:
                    dp_discount_used[to_city] = new_cost
                    heappush(pq, (new_cost, to_city, False))

    print(min(dp_discount_used[n], dp_discount_unused[n]))

if __name__ == '__main__':
    main()