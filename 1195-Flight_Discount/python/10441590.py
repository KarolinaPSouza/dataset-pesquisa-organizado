import sys
from heapq import heappop, heappush

def find_min_costs(start, adjacency_list):
    min_costs = [sys.maxsize] * len(adjacency_list)
    min_costs[start] = 0
    frontier = [(0, start)]

    while frontier:
        cost, curr = heappop(frontier)
        if cost != min_costs[curr]:
            continue
        for neighbor, next_cost in adjacency_list[curr]:
            new_cost = cost + next_cost
            if new_cost < min_costs[neighbor]:
                min_costs[neighbor] = new_cost
                heappush(frontier, (new_cost, neighbor))

    return min_costs

def main():
    city_count, flight_count = map(int, input().split())
    adjacency_list = [[] for _ in range(city_count)]
    reverse_adjacency_list = [[] for _ in range(city_count)]

    for _ in range(flight_count):
        from_city, to_city, flight_cost = map(int, input().split())
        adjacency_list[from_city - 1].append((to_city - 1, flight_cost))
        reverse_adjacency_list[to_city - 1].append((from_city - 1, flight_cost))

    start_costs = find_min_costs(0, adjacency_list)
    end_costs = find_min_costs(city_count - 1, reverse_adjacency_list)

    min_total_cost = sys.maxsize
    for city in range(city_count):
        for neighbor, flight_cost in adjacency_list[city]:
            if start_costs[city] == sys.maxsize or end_costs[neighbor] == sys.maxsize:
                continue
            min_total_cost = min(min_total_cost, start_costs[city] + (flight_cost // 2) + end_costs[neighbor])

    print(min_total_cost)

if __name__ == "__main__":
    main()