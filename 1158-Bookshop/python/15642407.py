import sys

r = sys.stdin.buffer.readline

a = r().split()
n = int(a[0])
g = int(a[1])

p = list(map(int, r().split()))
s = list(map(int, r().split()))

d = [0] * (g + 1)

for x, y in zip(p, s):
    dx = d
    for j in range(g - x, -1, -1):
        v = dx[j] + y
        if v > dx[j + x]:
            dx[j + x] = v

sys.stdout.write(str(d[g]))