from math import isqrt

n = int(input())

ans = 0

for i in range(1, isqrt(n) + 1):
    ans += i*(n//i)

for i in range(1, (n//(isqrt(n)+1))+1):
    l = n//(i+1) + 1
    r = n//i
    if(l <= isqrt(n)): 
        l = isqrt(n) + 1
    if(l <= r):
        ans += (i)*(((r-l+1)*(r+l))//2)

mod = 1000000007

print(ans%mod)