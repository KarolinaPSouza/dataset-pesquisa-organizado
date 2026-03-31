I = lambda : map(int, input().split())
n = int(input())
cnt, maxcnt = 0, 0
t = []
for i in range(n):
    a, b = I()
    t.append(2 * a); t.append(2 * b + 1)

t.sort()

for p in t:
    if p & 1: cnt -= 1
    else: cnt += 1
    maxcnt = max(maxcnt, cnt)

print(maxcnt)

