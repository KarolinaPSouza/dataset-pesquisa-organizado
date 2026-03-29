import sys
import heapq
import time

settings = list(map(int, sys.stdin.readline().split()))

#print(time.time())
num_cities = settings[0]
num_flights = settings[1]

flights = [[] for _ in range(num_cities)]
lowest_cost_parent = [None] * num_cities
lowest_cost_parent_cost = [None] * num_cities
visited = [False] * num_cities
# Read the roads input
for _ in range(num_flights):
 numbers = list(map(int, sys.stdin.readline().split()))
 flights[numbers[0] - 1].append((numbers[1] - 1, numbers[2]))


for city in flights:
 city.sort(key=lambda x: x[1])


heap = []

lowest_cost_parent_cost[0] = 0

#heapq.heappush(heap, (0, 0, None, 0, [0], [0]))
heapq.heappush(heap, (0, 0, None, 0))

#print(time.time())

best_result = None

priorities = [None] * num_cities

while heap:
 #_, city, discount, cost, path, concosts = heapq.heappop(heap)
 oldpriority, city, discount, cost = heapq.heappop(heap)

 #print(f'Cost:{cost}, City:{city}, max discount: {discount}')

 if visited[city] and visited[city] <= cost:
  continue
 visited[city] = cost

 if city == num_cities - 1:
  #visited[city] = True
  realcost = int(cost-discount/2)
  if best_result is None or realcost < best_result:
   best_result = realcost
  #break
  print(int(cost-discount/2))
  break
  #print(f'Yay! {cost - discount/2} - Cost:{cost}, City:{city}, max discount: {discount}, {path} {concosts }')
  #print(discount)
  #print(cost)
  #break


 #cost = lowest_cost_parent_cost[city]





 cur_discount = discount

 for neighbor, connection_cost in flights[city]:
  discount = max(cur_discount or 0, connection_cost)
  new_cost = cost + connection_cost

  priority = new_cost - discount / 2
  #if (a := priorities[city]) is None or a >= priority:
  heapq.heappush(heap, (priority, neighbor, discount, new_cost))
  priorities[city] = priority
  #if (a := lowest_cost_parent_cost[neighbor]) is None or a > new_cost:

  #lowest_cost_parent_cost[neighbor] = new_cost
  #heapq.heappush(heap, (ncost-discount/2, neighbor, discount, ncost, path + [neighbor], concosts + [connection_cost]))


#print(best_result)

#print(' '.join([str(cost) for cost in lowest_cost_parent_cost]))