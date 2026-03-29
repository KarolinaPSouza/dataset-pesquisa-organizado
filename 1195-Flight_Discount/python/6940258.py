import heapq

city_num, flight_num = map(int, input().split())
neighbors = [[] for _ in range(city_num)]

for _ in range(flight_num):
    from_, to, cost = map(int, input().split())
    neighbors[from_ - 1].append((to - 1, cost))

min_cost = [[float('inf'), float('inf')] for _ in range(city_num)]
min_cost[0] = [0, 0]

class Pos:
    def __init__(self, pos, used, cost):
        self.pos = pos
        self.used = used
        self.cost = cost

    def __lt__(self, other):
        return self.cost < other.cost

frontier = [Pos(0, False, 0)]
heapq.heapify(frontier)

while frontier:
    curr = heapq.heappop(frontier)
    curr_cost = min_cost[curr.pos][curr.used]

    if curr_cost != curr.cost:
        continue

    if curr.pos == city_num - 1:
        break

    for n, nc in neighbors[curr.pos]:
        if not curr.used:
            new_cost = curr_cost + nc // 2
            if new_cost < min_cost[n][1]:
                min_cost[n][1] = new_cost
                heapq.heappush(frontier, Pos(n, 1, new_cost))

        if curr_cost + nc < min_cost[n][curr.used]:
            min_cost[n][curr.used] = curr_cost + nc
            heapq.heappush(frontier, Pos(n, curr.used, curr_cost + nc))

print(min_cost[city_num - 1][1])