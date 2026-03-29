import os.path
from math import gcd, floor, ceil
from collections import *
import sys

mod = 1000000007
INF = float("inf")


def st():
    return list(sys.stdin.readline().strip())


def li():
    return list(map(int, sys.stdin.readline().split()))


def mp():
    return map(int, sys.stdin.readline().split())


def inp():
    return int(sys.stdin.readline())


def pr(n):
    return sys.stdout.write(str(n) + "\n")


def prl(n):
    return sys.stdout.write(str(n) + " ")


if os.path.exists("input.txt"):
    sys.stdin = open("input.txt", "r")
    sys.stdout = open("output.txt", "w")


n,m = mp()
q = []
for i in range(m):
    a,b,c = mp()
    q.append((a,b,c))
cost = [0]*(n+1)
par = list(cost)
for i in range(n):
    x = -1 
    for a,b,c in q:
        if cost[a] + c < cost[b]:
            x = b
            par[b] = a 
            cost[b] = c + cost[a]
if x == -1 :
    pr("NO")
else:
    pr("YES")
    for i in range(n):
        x = par[x]
    ans = []
    X = x 
    while True:
        ans.append(x)
        x = par[x]
        if x == X:
            break 
    print(*ans[::-1],ans[-1])
