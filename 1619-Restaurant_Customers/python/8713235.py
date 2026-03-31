n = int(input().strip())
times = []
for _ in range(n):
    times.append(list(map(int, input().split())))

d = {}

for x,y in times:
    d[x] = d.get(x, 0) + 1
    d[y] = d.get(y, 0) - 1

max_customers = 0
curr_customers = 0

for t in sorted(d.keys()):
    curr_customers += d[t]
    max_customers = max(max_customers, curr_customers)

print(max_customers)