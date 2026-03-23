#JAI SHREE RAM
#JAI HANUMAN 
#JAI JAGANNATH


import sys

import math
import bisect
from functools import lru_cache
MOD = 10**9 + 7
from itertools import product

"""
 1 1 1 0 0  1 0 1 0 
Ans[k] = len * (len + 1) / 2
 Ans[i] = Number of subarrays whose minimum element >= i 
cnt[i] = Number of subarrays whose minimum element == i
Ans[i] = SuffSum(cnt[i])
 4, 5, 6, 4, 3, 2 
 1 1 1
 L, R = ()
L, R = [] 
 (]
i
R = nextSmaller[i] - 1 
L = prevSmallerThanEqualTo[i] + 1
 (R - i + 1) * (i - L + 1)
"""


# @lru_cache(None)
# def Func(l,r):
#     if(l>r):
#         return 0
#     return max(A[l]-Func(l+1,r),A[r]-Func(l,r-1))
# print(Func(0,N-1))
def func(A):
    A.sort()
    prev = A[0]
    var = 1
    ans = 0
    for i in range(1,len(A)):
        if(A[i]==prev):
            var+=1
        else:
            ans += (var*(var-1))//2
            var = 1
            prev = A[i]
    ans += (var*(var-1))//2
    return ans
def f(n, k):
    if n == 1:
        return 1
    m = n//2
    if k<=m:
        return 2*k
    if n%2==0:
        return 2*f(m,k-m)-1
    else:
        x = f(m+1,k-m)
        if x == 1:
            return n
        else:
            return 2*(x-1)-1
def spf(N):
    L = [0]*(N+1)
    L[1]=1
    for i in range(2,N+1):
        if(L[i]==0):
            L[i]=i
            for j in range(i*i,N+1,i):
                if(L[j]==0):
                    L[j]=i
    return L
L = spf(10**6)
def pf(N):
    a = L#For multiple queries calculate the spf of the MaxN outside the pf function else you gandi maring
    b = {}
    x = N
    while(N!=1):
        s=a[N]
        if(s in b):
            b[s]+=1
        else:
            b[s]=1
        N=N//s
    return b
def divisors(n):
    d = pf(n)
    pl = []
    for i,j in d.items():
        pl.append([i**e for e in range(j+1)])
    divisors = []
    for c in product(*pl):
        x=1
        for i in c:
            x*=i
        divisors.append(x)
    return divisors

#for _ in range(int(input())):
N = int(input())
i = 1
ans = 0
# while(i*i <= N):
#     ans += i*(N//i)
#     if(i*i!=N):
#         ans += i*(N//i)
#     i+=1
var = 1
# while(var*var<=N):
#     x = N//(var+1)
#     y = N//var
#     print(var,y,x)
#     X = (x*(x+1))//2
#     Y = (y*(y+1))//2
#     ans += var*(Y-X)
#     var+=1
X = []
while(var*var<=N):
    if(not X):
        X.append(N//var)
    if(X and X[-1]!=N//var):
     X.append(N//var)
    var+=1
prev = 0
Y = []
pt = -1
while(pt>=-len(X)):
    if(N//X[pt] == X[pt]):
        pt-=1
        continue
    else:
        Y.append(N//X[pt])
        pt-=1
X = X + Y
for i in range(len(X)):
    x = N//X[i]
    ans += X[i]*((x*(x+1))//2-prev) % MOD
    prev = (x*(x+1))//2

print(ans%MOD)
