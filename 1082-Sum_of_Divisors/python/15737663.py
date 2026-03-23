import sys
import math
from collections import defaultdict, deque, Counter
from itertools import permutations, combinations
from bisect import bisect_left, bisect_right
import heapq
from functools import lru_cache


sys.setrecursionlimit(10**6)
input = lambda: sys.stdin.readline().strip()

MOD = 10**9 + 7
INF = float('inf')

# ========== Utility Functions ==========

def print_yes(): print("YES")
def print_no(): print("NO")

def lcm(a, b): return abs(a*b) // math.gcd(a, b)

def exp_mod(a, b): 
    if b==0:
        return 1 
    if a==0:
        return 0 

    m =  exp_mod(a, b//2)
    x = (m * m) % MOD 

    if b%2==0:
        return x 
    else: 
        return (x * a) % MOD

def exp_mod_spl(a, b, M): 
    if b==0:
        return 1 
    if a==0:
        return 0 

    m =  exp_mod_spl(a, b//2, M)
    x = (m * m) % M

    if b%2==0:
        return x 
    else: 
        return (x * a) % M

def mod_inv(a):
    return exp_mod(a, MOD-2)



# ========== Solve Function ==========


def solve():
    n = int(input())

    ans = 0
    sqrt_n = int(math.sqrt(n))

    for i in range(1, sqrt_n+1):
        ans += i * (n // i)      
        ans = ans % MOD 

    for i in range(1, sqrt_n+1):
        last = n//i 
        first = n//(i+1) + 1

        if (not (first > sqrt_n and  last > sqrt_n)):
            continue

        a = first + last 
        b = last - first + 1 

        if a%2==0:
            a = a//2 
        else:
            b = b//2 

        sum = ((a % MOD) * (b % MOD)) % MOD     
        sum = (sum * i) % MOD   
        ans = (ans + sum) % MOD 

    print(ans)





def main():
    # For multiple test cases:
    # t = int(input())
    # for _ in range(t):
    #     solve()

    solve()

if __name__ == "__main__":
    main()