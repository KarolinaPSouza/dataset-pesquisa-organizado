import sys
n = int(input())
extremes = list()

for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    extremes.append((a, 1))
    extremes.append((b, -1))
extremes.sort()

max_n = count = 0
for _,credit in extremes:
    count  = count + credit
    if count>max_n:
        max_n = count
print(max_n)