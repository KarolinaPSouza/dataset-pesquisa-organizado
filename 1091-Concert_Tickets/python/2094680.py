# aadiupadhyay
import os.path
from math import gcd, floor, ceil
from collections import *
import sys
from bisect import *
mod = 1000000007
INF = float('inf')
def st(): return list(sys.stdin.readline().strip())
def li(): return list(map(int, sys.stdin.readline().split()))
def mp(): return map(int, sys.stdin.readline().split())
def inp(): return int(sys.stdin.readline())
def pr(n): return sys.stdout.write(str(n)+"\n")
def prl(n): return sys.stdout.write(str(n)+" ")


if os.path.exists('input.txt'):
    sys.stdin = open('input.txt', 'r')
    sys.stdout = open('output.txt', 'w')


def update(ind):
    ind += n
    segment[ind] = -INF
    while ind > 1:
        ind >>= 1
        segment[ind] = max(segment[2*ind+1], segment[2*ind])


def query(a, b):
    a += n
    b += n
    ma = -INF
    while a <= b:
        if a & 1:
            ma = max(ma, segment[a])
            a += 1
        if b % 2 == 0:
            ma = max(ma, segment[b])
            b -= 1
        b >>= 1
        a >>= 1
    if ma != -INF:
        update(ma)
    return ma


n, q = mp()
l = li()
x = li()
l.sort()
ans = []
segment = [0]*n + list(range(n))
for i in range(n-1, 0, -1):
    segment[i] = max(segment[2*i+1], segment[2*i])
for i in x:
    c = bisect_right(l, i)
    z = query(0, c-1)
    if z == -INF:
        ans.append(-1)
    else:
        ans.append(l[z])
print(*ans, sep='\n')