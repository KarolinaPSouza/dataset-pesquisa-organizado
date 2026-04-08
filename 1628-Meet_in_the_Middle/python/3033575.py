from sys import stdin
from collections import defaultdict as dd
from math import log2

n, x = map(int, stdin.readline().split())
t = list(map(int, stdin.readline().split()))
aa = t[:n//2]
bb = t[n//2:]
n = len(aa)
m = len(bb)
a = [0]
b = [0]
for i in range(1, (1<<n)):
    j = (i&(-i))
    a.append(aa[int(log2(j))] + a[j^i])
for i in range(1, (1<<m)):
    j = (i&(-i))
    b.append(bb[int(log2(j))] + b[j^i])
a.sort()
b.sort()
al = list()
bl = list()
prev = cnt = 0
for ele in a:
    if (ele != prev):
        if (cnt): al.append((prev, cnt))
        prev = ele
        cnt = 1
    else: cnt += 1
if (cnt):
    al.append((prev, cnt))
prev = cnt = 0
for ele in b:
    if (ele != prev):
        if (cnt): bl.append((prev, cnt))
        prev = ele
        cnt = 1
    else: cnt += 1
if (cnt):
    bl.append((prev, cnt))

j = len(bl) - 1
ans = 0
for ele in al:
    while j >= 0 and bl[j][0] > x - ele[0]: j -= 1
    if (bl[j][0] + ele[0] == x): ans += ele[1]*bl[j][1]
print(ans)