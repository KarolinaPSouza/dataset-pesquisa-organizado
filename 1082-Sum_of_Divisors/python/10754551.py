import sys
from random import randint, shuffle, choice
from math import gcd, lcm, sqrt, isqrt, perm, comb, factorial, log2, ceil, floor 
from collections import Counter, defaultdict, deque 
from functools import lru_cache, reduce, cmp_to_key 
from itertools import accumulate, combinations, permutations , product , repeat, takewhile , starmap , dropwhile , cycle
from heapq import nsmallest, nlargest, heappushpop, heapify, heappop, heappush , _heapify_max
from copy import deepcopy 
from bisect import bisect_left, bisect_right , insort_left , insort_right
from string import ascii_lowercase, ascii_uppercase
from operator import sub , mul,pow  , truediv , floordiv 
input = lambda: sys.stdin.buffer.readline().decode().rstrip()
OneByOne = lambda: sys.stdin.read(1)

I = lambda: input()
II = lambda: int(input())
MII = lambda: map(int, input().split())
LI = lambda: list(input().split())
LII = lambda: list(map(int, input().split()))
GMI = lambda: map(lambda x: int(x) - 1, input().split())
LGMI = lambda: list(map(lambda x: int(x) - 1, input().split()))
yes = lambda: print('YES')
no = lambda: print('NO')
DIR4 = ((-1, 0), (0, 1), (1, 0), (0, -1))
DIR8 = ((-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1))
MOD = 10 ** 9 + 7
inf = float('inf')

import math
def sum_all_divisors(num):

 sum = 0;
 for i in range(1,math.floor(math.sqrt(num))+1): 
  t1 = i * (num // i - i + 1) 
  t2 = (((num // i) * (num // i + 1)) // 2) - ((i * (i + 1)) // 2) 
  sum += t1 + t2;

 return sum % MOD;


print(sum_all_divisors(II()))
