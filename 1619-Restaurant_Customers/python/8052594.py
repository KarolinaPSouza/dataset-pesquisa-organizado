# #bad O(n^2) implementation

# N = int(input())

# data = {}

# #looping through each customer
# for ___ in range(N):
#   lowerTime, upperTime = map(int, input().split())
#   for time in range(lowerTime, upperTime + 1):
#     if time not in data:
#       data[time] = 1
#     else:
#       data[time] += 1

# print(max(data.values()))


#good O(n) implementation

N = int(input())

arrivals = []
departures = []

for ___ in range(N):
  arrival, departure = map(int, input().split())
  arrivals.append(arrival)
  departures.append(departure)

arrivals.sort()
departures.sort()

max = 0
curr = 0

i = 0
j = 0

while i < N and j < N:

  if arrivals[i] < departures[j]:
    curr += 1
    i += 1
  else:
    curr -= 1
    j += 1

  if curr > max:
    max = curr

print(max)




# dict = {}

# customers = int(input())
# for ___ in range(customers):
#   lowerBound, upperBound = map(int, input().split())
#   for time in range(lowerBound, upperBound+1):
#     if time in dict.keys():
#       dict.update({time: dict[time] + 1})
#     else:
#       dict.update({time: 1})

# print(dict[max(dict.keys())])