import sys
import heapq

settings = list(map(int, sys.stdin.readline().split()))

num_cities = settings[0]
num_flights = settings[1]

flights = [[] for _ in range(num_cities)]
for _ in range(num_flights):
 numbers = list(map(int, sys.stdin.readline().split()))
 flights[numbers[0] - 1].append((numbers[1] - 1, numbers[2]))

heap = []

heapq.heappush(heap, (0, 0, None, 0))

costs = [None] * num_cities

while heap:
 _, city, discount, cost = heapq.heappop(heap)

 if costs[city] and costs[city] <= cost:
  continue

 costs[city] = cost

 if city == num_cities - 1:
  print(int(cost-discount/2))
  break

 for neighbor, connection_cost in flights[city]:
  best_discount = max(discount or 0, connection_cost)
  new_cost = cost + connection_cost
  priority = new_cost - best_discount / 2
  heapq.heappush(heap, (priority, neighbor, best_discount, new_cost))