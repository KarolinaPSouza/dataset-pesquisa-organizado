"""
For God so loved the world that he gave his one and only Son, 
that whoever believes in him shall not perish but have eternal life.
JOHN 3:16 
"""
#imports
import random
from math import *
from functools import lru_cache,cmp_to_key
from itertools import *
from fractions import Fraction
from bisect import bisect_left as bl
from bisect import bisect_right as br
from operator import itemgetter
from collections import Counter,deque,defaultdict
from heapq import heappop as hpop, heappush as hpush
YES = ['NO','YES']
Yes = ["No","Yes"]
yes = ["no","yes"]
# constants
MOD = [10**9 + 7,998244353]
MOD = MOD[0]
rand = random.randint(10**8,10**9)
n,m,files = 0,0,0
import sys
if files:sys.stdin = open("input.txt");sys.stdout = open("output.txt", 'w')
input = sys.stdin.readline
output = sys.stdout.write
#sys.setrecursionlimit(110000)
# #For large input
# input = sys.stdin.read
# data = input().split()
# Shortcut for input()
def I(): return int(input())
def S(): return input().strip()
def F(): return float(input())
def MI(): return map(int, input().split())
def MS(): return map(str, input().split())
def MF(): return map(float,input().split())
def LI(): return list(map(int, input().split()))
def LS(): return list(map(str, input().split()))
def LF(): return list(map(float , input().split()))
def MAT(n): return [LI() for _ in range(n)]
#fast_pow,add,sub,pro -works well when p is prime or composite
def fast_pow(a, b, n):  # a^b % n using binary exponentiation
    a %= n
    res = 1
    while b:
        if b & 1:
            res = res * a % n
        a = a * a % n
        b >>= 1
    return res
def add(a, b): return (a % MOD + b % MOD) % MOD
def sub(a, b): return (a % MOD - b % MOD + MOD) % MOD
def pro(a, b): return (a % MOD * b % MOD) % MOD
# Division using inverse: valid only when inv(b) exists (gcd(b, MOD) = 1)
def div(a, b): return pro(a, inv(b))
# Inverse assuming MOD is prime
def inv(a): return fast_pow(a, MOD - 2, MOD)
# Extended Euclidean Algorithm (works for any MOD if gcd(a, MOD) == 1)
def invcom(a):
    def egcd(a, b):
        if b == 0: return a, 1, 0
        g, x1, y1 = egcd(b, a % b)
        return g, y1, x1 - (a // b) * y1
    g, x, _ = egcd(a, MOD)
    return (x % MOD) if g == 1 else "no solution"
def inbound(i,j): return 0 <= i < n and 0 <= j < m
def idx(i,j):return i*m + j # DSU [2D - 1D] (0 - n*m-1)
def summ(n):return (n * (n+1))>>1
def nc2(n):return summ(n-1)
def sod(n): return sum(int(i) for i in str(n))
def cdc(n):return (10*n-sod(n))//9
DIR4 = [(1,0),(-1,0),(0,1),(0,-1)]
DIR8 = [(1,0),(-1,0),(0,1),(0,-1),(1,1),(-1,-1),(1,-1),(-1,1)]
knight = [(2, 1), (2, -1), (-2, 1), (-2, -1), (1, 2), (-1, 2), (1, -2), (-1, -2)]
#Shortcut for output()
res = []
def OI(res): output("\n".join(res))
def OL(res): output("\n".join(" ".join(i) for i in res))


"""
 """

n = I()
a = LI()
a.sort()
prev =0
c= 0
for i in a:
    if i != prev:
        c+=1
        prev = i
print(c)