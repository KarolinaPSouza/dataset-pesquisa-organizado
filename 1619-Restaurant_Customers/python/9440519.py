n = int(input())
arrival = []
departure = []
for i in range(n):
    arri, dep = list(map(int, input().split(" ")))
    arrival.append(arri)
    departure.append(dep)

arrival.sort()# = sorted(arr, key=lambda x: x[0])
departure.sort()# = sorted(arr, key = lambda x: x[1])
i = 0
j = 0
count = 0
result = 0
while(i < n):
    if arrival[i] == departure[j]:
        i += 1
        j += 1
    elif arrival[i] < departure[j]:
        count += 1
        if result < count:
            result = count
        i += 1
    elif arrival[i] > departure[j]:
        count -= 1
        j += 1
print(result)

#arr = sorted(arr, key=lambda x:x[0], reverse=False)
#print(arr, dep)
"""
import heapq
 p = []
result = 1
count = 1
heap = heapq.heappush(p, arr[0][1])
for i in range(1, n):
    while(p and p[0] <= arr[i][0]):
        heapq.heappop(p)
        count -= 1
    count += 1
    heapq.heappush(p, arr[i][1])
    if result < count:
        result = count
print(result)
"""