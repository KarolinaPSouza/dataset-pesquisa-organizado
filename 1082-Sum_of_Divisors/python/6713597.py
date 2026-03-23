from math import isqrt
x = int(input())
rv = 0
for i in range(1, isqrt(x) + 1):
    rv += (x//i)*(x//i+1)//2
    rv += i*(x//i)
rv -= isqrt(x)*isqrt(x)*(isqrt(x)+1)//2
print(rv % (10**9 + 7))