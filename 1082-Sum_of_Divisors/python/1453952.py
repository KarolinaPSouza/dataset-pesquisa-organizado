import sys
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def get_list(): return list(map(int, sys.stdin.readline().strip().split()))
def get_list_string(): return list(map(str, sys.stdin.readline().strip().split()))
def get_string(): return sys.stdin.readline().strip()
def get_int(): return int(sys.stdin.readline().strip())
def get_print_int(x): sys.stdout.write(str(x) + '\n')
def get_print(x): sys.stdout.write(x + '\n')
from math import sqrt

MOD = 10**9 + 7

def power(x,y,mod):
    res = 1
    x = x % mod
    while(y > 0):
        if((y & 1) == 1):
            res = (res * x)% mod
        y = (y >> 1)
        x = (x * x) % mod
    return (res) % mod

def modinv(x):
    return power(x,MOD-2,MOD)

MODINV2 = modinv(2)

def helper(x):
    temp = ((((x % MOD) * ((x+1)%MOD) ) % MOD ) * MODINV2 ) % MOD
    return temp

def solve():
    # for _ in range(get_int()):
    n = get_int()
    count = 0
    temp = 1
    while(temp <= n):
        k = n//temp
        temp1 = n//k
        k = (k)%MOD
        count = (count + ( (helper(temp1) - helper(temp - 1) % MOD)*(k) ))%MOD
        temp = temp1 + 1
    get_print_int(count)
solve()