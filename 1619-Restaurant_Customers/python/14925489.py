import sys

input = sys.stdin.read
data = input().split()

n = int(data[0])
events = []
index = 1
for i in range(n):
    a = int(data[index])
    b = int(data[index + 1])
    events.append((a, 1))  # arrival
    events.append((b, -1))  # departure
    index += 2

events.sort()

max_customers = 0
current = 0
for time, typ in events:
    current += typ
    if current > max_customers:
        max_customers = current

print(max_customers)