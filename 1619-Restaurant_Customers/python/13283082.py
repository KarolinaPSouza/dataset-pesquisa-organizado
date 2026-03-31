import sys

n = int(sys.stdin.readline())
events = {}

min_t, max_t = float('inf'), 0

for _ in range(n):
    a, l = map(int, sys.stdin.readline().split())
    events[a] = events.get(a, 0) + 1
    events[l] = events.get(l, 0) - 1
    min_t, max_t = min(min_t, a), max(max_t, l)

current = 0
max_c = 0
for t in sorted(events):  # at most 2n unique timestamps
    current += events[t]
    if current > max_c:
        max_c = current
print(max_c)