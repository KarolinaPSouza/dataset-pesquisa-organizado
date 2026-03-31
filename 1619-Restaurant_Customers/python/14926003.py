import sys

data = sys.stdin.read().split()

n = int(data[0])
arrivals = []
departures = []
for i in range(1, len(data), 2):
    a = int(data[i])
    b = int(data[i + 1])
    arrivals.append(a)
    departures.append(b)

arrivals.sort()
departures.sort()

i = 0
j = 0
current = 0
max_customers = 0

while i < n and j < n:
    if arrivals[i] <= departures[j]:
        current += 1
        max_customers = max(max_customers, current)
        i += 1
    else:
        current -= 1
        j += 1

print(max_customers)