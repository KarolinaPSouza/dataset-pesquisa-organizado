import sys

#input functions
readint = lambda: int(sys.stdin.readline())
readints = lambda: map(int,sys.stdin.readline().split())
readar = lambda: list(map(int,sys.stdin.readline().split()))
flush = lambda: sys.stdout.flush()
readin = lambda: sys.stdin.readline()[:-1]
readins = lambda: map(str,sys.stdin.readline().split())

n = readint()
ar = list()
for _ in range(n):
    a,b = readints()
    ar.append(a*2)
    ar.append(b*2+1)
ar.sort()
ans = 0
x = 0
for e in ar:
    if e % 2 == 0: x += 1
    else: x -= 1
    ans = max(ans,x)
print(ans)