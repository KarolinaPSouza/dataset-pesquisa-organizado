# لا تَجلِس فارِغًا [ حرك لسانك ]
# اسْتَغفِر ، سَبّح ، هَلّل ، كَبّر ، حَولق

import sys
from random import randint, shuffle, choice
from math import gcd, sqrt, isqrt, perm, log, comb, factorial, log2, ceil, floor
from collections import Counter, defaultdict, deque
from functools import lru_cache, reduce, cmp_to_key
from itertools import accumulate, combinations, permutations, product, repeat, takewhile, starmap, dropwhile, cycle
from heapq import nsmallest, nlargest, heappushpop, heapify, heappop, heappush, _heapify_max
from bisect import bisect_left, bisect_right, insort_left, insort_right
#from operator import sub, mul, pow, truediv, floordiv
input = lambda: sys.stdin.buffer.readline().decode().rstrip()
OneByOne = lambda: sys.stdin.read(1)

def modinv(a):
    return pow(a, MOD - 2, MOD)

def lcm(a, b):
    return a * b // gcd(a, b)
def W(i):
    return (i, str(i))

def MakeFile(s: str, r='in', v='out'):
    import sys
    sys.stdin = open(f'{s}.{r}', 'r')
    sys.stdout = open(f'{r}.{v}', 'w')

#def is_valid(x, y): # Grid
#    return 0 <= x < n and 0 <= y < m and \
#        graph[x][y] != '#' and not vis[x][y]

I = lambda: input()
II = lambda: int(input())
MII = lambda: map(int, input().split())
LI = lambda: list(input().split())
LII = lambda: list(map(int, input().split()))
GMI = lambda: map(lambda x: int(x) - 1, input().split())
LGMI = lambda: list(map(lambda x: int(x) - 1, input().split()))
yes = lambda: print('YES')
no = lambda: print('NO')
letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
DIR4 = ((-1, 0), (0, 1), (1, 0), (0, -1))
DIR8 = ((-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1))
DIR4_prime = [(-1, 0, 'U'), (0, 1, 'R'), (1, 0, 'D'), (0, -1, 'L')]
MOD = 10 ** 9 + 7
inf = float('inf')

#!يا دارَ فَوزٍ لَقَد أَورَثتِني دَنَفا
#!وَزادَني بُعدُ داري عَنكُمُ شَغَفا

#!حَتّى مَتى أَنا مَكروبٌ بِذِكرِكُمُ
#!أُمسي وَأُصبِحُ صَبّاً هائِماً دَنِفا

#!لا أَستَريحُ وَلا أَنساكُمُ أَبَداً
#!وَلا أَرى كَربَ هَذا الحُبِّ مُنكَشِفا

#!إِنّي لَأَعجَبُ مِن قَلبٍ يُحِبُّكُمُ
#!وَما رَأى مِنكُمُ بِرّاً وَلا لَطَفا

#!يا لَيتَ شِعري وَما في لَيتَ مِن فَرَجٍ
#!هَل ما مَضى عائِدٌ مِنكُم وَما سَلَفا

#!طافَ الهَوى بِعِبادِ اللَهِ كُلِّهِمُ
#!حَتّى إِذا مَرَّ بي مِن بَينِهِم وَقَفا


#for _ in range(II()):


n, m = MII()
cost = [0] * n
p = [-1] * n
cost[0] = 0
# data = defaultdict(int)
edges = []
for _ in range(m):
    u, v, c = MII()
    u -= 1
    v -= 1
    # cost[u] += c
    # cost[v] += c
    # if u != v:
    # cost[u] -= c
    # cost[v] -= c
    # if data[(u, v)]:
    #     data[(u, v)] = min(data[(u, v)], c)
    # else :
    #     data[(u, v)] = c
    edges.append((u, v, c))
    # edges.append((v, u, c))

# edges.sort(key=lambda x: x[2])
# print(edges)
s = -1

for i in range(n):
    s= -1
    for u, v, c in edges:
        if cost[u] + c < cost[v]:
            cost[v] = cost[u] + c
            p[v] = u
            s = v 

if s == -1:
    no()
    exit()

for _ in range(n):
    s = p[s]

path = []
cur = s
while True:
    path.append(cur + 1)
    cur = p[cur]
    if cur == -1 or cur == s and len(path) > 1:
        break
if path[-1] != path[0]:
    path.append(s + 1) 

if len(path) >= 2:
    yes()
    path.reverse()
    print(*path)  
else :
    no()
