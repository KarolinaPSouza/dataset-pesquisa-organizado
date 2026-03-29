import sys
from heapq import heappop, heappush


def min_costs(start, neighbors):
    min_costs = [sys.maxsize] * len(neighbors)
    min_costs[start] = 0
    frontier = [(0, start)]

    while frontier:
        cost, curr = heappop(frontier)
        if cost != min_costs[curr]:
            continue
        for n, nc in neighbors[curr]:
            new_cost = cost + nc
            if new_cost < min_costs[n]:
                min_costs[n] = new_cost
                heappush(frontier, (new_cost, n))

    return min_costs


def main():
    city_num, flight_num = map(int, input().split())
    neighbors = [[] for _ in range(city_num)]
    reverse_neighbors = [[] for _ in range(city_num)]

    for _ in range(flight_num):
        from_city, to_city, cost = map(int, input().split())
        neighbors[from_city - 1].append((to_city - 1, cost))
        reverse_neighbors[to_city - 1].append((from_city - 1, cost))

    start_costs = min_costs(0, neighbors)
    end_costs = min_costs(city_num - 1, reverse_neighbors)

    total_min = sys.maxsize
    for c in range(city_num):
        for n, nc in neighbors[c]:
            if start_costs[c] == sys.maxsize or end_costs[n] == sys.maxsize:
                continue
            total_min = min(total_min, start_costs[c] + (nc // 2) + end_costs[n])

    print(total_min)


if __name__ == "__main__":
    main()