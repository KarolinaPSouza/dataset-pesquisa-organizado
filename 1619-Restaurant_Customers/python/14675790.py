import sys
from random import randint, shuffle, choice
from math import gcd , sqrt, isqrt, perm, log , comb, factorial, log2, ceil, floor 
from collections import Counter, defaultdict, deque 
from functools import lru_cache, reduce, cmp_to_key 
from itertools import accumulate, combinations, permutations , product , repeat, takewhile , starmap , dropwhile , cycle
from heapq import nsmallest, nlargest, heappushpop, heapify, heappop, heappush , _heapify_max
from bisect import bisect_left, bisect_right , insort_left , insort_right
#from operator import sub , mul,pow  , truediv , floordiv 
input = lambda: sys.stdin.buffer.readline().decode().rstrip()
OneByOne = lambda: sys.stdin.read(1)

def lcm(a , b) : 
    return a * b // gcd(a ,b)
def W(i) : 
    return (i , str(i))


I = lambda: input()
II = lambda: int(input())
MII = lambda: map(int, input().split())
LI = lambda: list(input().split())
LII = lambda: list(map(int, input().split()))
yes = lambda: print('YES')
no = lambda: print('NO')
MOD = 10 ** 9 + 7
inf = float('inf')



n=II()
ls=[]
res=0
maxi=0
for _ in range(n):
    a,b=MII()
    ls.append((a,1))
    ls.append((b,0))
ls.sort()
for i,j in ls:
    if j==1:
        res+=1
    else:
        res-=1
    maxi=max(maxi,res)
print(maxi)