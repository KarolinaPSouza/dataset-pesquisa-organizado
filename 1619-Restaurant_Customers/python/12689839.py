import sys
input = sys.stdin.readline

n = int(input())
events = [tuple(map(int, input().split())) for _ in range(n)]
timeline = []

for a, b in events:
    timeline.append((a, 1))
    timeline.append((b, -1))

timeline.sort()

cur = res = 0
for _, x in timeline:
    cur += x
    res = max(res, cur)

print(res)