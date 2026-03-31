import sys
input = sys.stdin.readline

n = int(input())
time = []
for _ in range(n):
    start, end = map(int, input().split())
    time.append((start, 1))
    time.append((end, -1))

time.sort()
m = 0
now = 0
for t in time:
    now += t[1]
    m = max(m, now)
print(m)