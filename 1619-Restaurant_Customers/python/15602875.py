import sys

input = sys.stdin.readline

n = int(input())
arrivals = []
departures = []

for _ in range(n):
    a, b = map(int, input().split())
    arrivals.append(a)
    departures.append(b)

# Sort both arrays
arrivals.sort()
departures.sort()

i = j = 0
current = max_customers = 0

# Use two pointers instead of event list
while i < n:
    if arrivals[i] < departures[j]:
        current += 1
        max_customers = max(max_customers, current)
        i += 1
    else:
        current -= 1
        j += 1

print(max_customers)