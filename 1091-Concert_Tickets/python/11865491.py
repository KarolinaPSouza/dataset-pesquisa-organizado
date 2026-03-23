import math
import time
from collections import defaultdict


def counter_elements(a):
    q = defaultdict(int)
    for elem in a:
        q[elem] += 1
    return dict(q)

def preprocessing(a, block_size):
    n = len(a)
    num_blocks = (n + block_size - 1) // block_size
    b = [0] * num_blocks
    return b

def lower_bound(x, a):
    l = 0
    r = len(a) - 1
    res = -1
    while l <= r:
        m = l + (r - l) // 2
        if a[m] > x:
            r = m - 1
        else:
            res = m
            l = m + 1
    return res

t0 = time.time()

n, m = map(int, input().split())
h = list(map(int, input().split()))
t = list(map(int, input().split()))

res = []
h.sort()
vis = [False] * n

a = counter_elements(h)
pom = [(k, v) for k, v in a.items()]
pom.sort(key=lambda x: x[0])
ile = []
a = []
for i in range(len(pom)):
    ile.append(pom[i][1])
    a.append(pom[i][0])

block_size = int(math.sqrt(n)) + 1
b = preprocessing(a, block_size)

for c in t:
    i = lower_bound(c, a)
    if i == -1:
        res.append(-1)
    else:
        while i >= 0 and vis[i]:
            if b[i // block_size] == block_size:
                i -= i % block_size + 1
            else:
                i -= 1
        if i == -1:
            res.append(-1)
        else:
            res.append(a[i])
            ile[i] -= 1
            if ile[i] == 0:
                vis[i] = True
                b[i // block_size] += 1
print('\n'.join([str(x) for x in res]))

t1 = time.time()
#print(f"Time: {t1 - t0:.6f} seconds")