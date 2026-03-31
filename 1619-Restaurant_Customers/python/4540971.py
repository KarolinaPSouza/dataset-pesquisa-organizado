from collections import defaultdict,Counter
import math
import bisect
from itertools import accumulate
from math import ceil, log
from functools import lru_cache 
from sys import stdin, stdout



def read():
    return stdin.readline().rstrip()


total = int(read())
x = []
for _ in range(total):


    i,j = ([int(p) for p in read().split()])
    x.append((i,1))
    x.append((j,-1))

y = sorted(range(2*total),key = lambda y:x[y][0])

s = 0
m = 0
#print(y)
for i in y:
    s+= x[i][1]
    if s >m:
        m=s

print(m)