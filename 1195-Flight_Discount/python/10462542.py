import sys
from heapq import heappop, heappush

def dijkstra(start, graph):
    n = len(graph)
    min_costs = [sys.maxsize] * n
    min_costs[start] = 0
    priority_queue = [(0, start)]

    while priority_queue:
        curr_cost, curr_node = heappop(priority_queue)

        if curr_cost > min_costs[curr_node]:
            continue

        for neighbor, cost in graph[curr_node]:
            new_cost = curr_cost + cost
            if new_cost < min_costs[neighbor]:
                min_costs[neighbor] = new_cost
                heappush(priority_queue, (new_cost, neighbor))

    return min_costs

def calculate_min_total_cost(adjacency_list, start_costs, end_costs):
    min_total_cost = sys.maxsize

    for city in range(len(adjacency_list)):
        for neighbor, flight_cost in adjacency_list[city]:
            if start_costs[city] == sys.maxsize or end_costs[neighbor] == sys.maxsize:
                continue
            discounted_flight_cost = flight_cost // 2
            total_cost = start_costs[city] + discounted_flight_cost + end_costs[neighbor]
            min_total_cost = min(min_total_cost, total_cost)

    return min_total_cost

def main():
    city_count, flight_count = map(int, input().split())
    adjacency_list = [[] for _ in range(city_count)]
    reverse_adjacency_list = [[] for _ in range(city_count)]

    for _ in range(flight_count):
        from_city, to_city, flight_cost = map(int, input().split())
        from_city -= 1
        to_city -= 1
        adjacency_list[from_city].append((to_city, flight_cost))
        reverse_adjacency_list[to_city].append((from_city, flight_cost))

    start_costs = dijkstra(0, adjacency_list)
    end_costs = dijkstra(city_count - 1, reverse_adjacency_list)

    min_total_cost = calculate_min_total_cost(adjacency_list, start_costs, end_costs)

    print(min_total_cost)

if __name__ == "__main__":
    main()