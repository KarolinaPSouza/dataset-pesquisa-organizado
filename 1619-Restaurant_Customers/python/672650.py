import sys
input = sys.stdin.readline
read_tuple = lambda _type: map(_type, input().split(' '))

n = int(input())
events = []
for _ in range(n):
    a, b = read_tuple(int)
    events.append(2 * a)
    events.append(2 * b + 1)
events.sort()
max_customers = 0
count_customers = 0
for event in events:
    if event % 2 == 0:
        count_customers += 1
        max_customers = max(max_customers, count_customers)
    else:
        count_customers -= 1
print(max_customers)