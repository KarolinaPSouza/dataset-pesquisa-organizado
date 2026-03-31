n = int(input())

arrivals = []
departures = []

for _ in range(n):
    a, d = map(int, input().split())
    arrivals.append(a)
    departures.append(d)

arrivals.sort()
departures.sort()

max_cust, cust = 0, 0
i, j = 0, 0

while i < n and j < n:
    if arrivals[i] < departures[j]:
        cust += 1
        max_cust = max(max_cust, cust)
        i += 1
    else:
        cust -= 1
        j += 1

print(max_cust)