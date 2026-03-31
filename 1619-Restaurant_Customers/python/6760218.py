import sys

input=sys.stdin.readline
def f(): return map(int, input().split())

n = int(input())
times = []
for _ in range(n):
    s,e = f()
    times.append((s,1))
    times.append((e,-1))

times.sort(key=lambda x:x[0])
maxim, total = -1, 0
for _, val in times:
    total += val
    maxim = max(maxim, total)
print(maxim)