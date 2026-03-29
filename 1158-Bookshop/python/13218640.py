'''
def d(U, n):
    k=U.bit_length()-1
    b=bin(n)[2:].zfill(k)
    r=[]
    s=b
    while s:
        l=len(s)
        t=(l+1)//2
        p=s[:t]
        s=s[t:]
        r.append(int(p, 2))
    return r
U, N=map(int, input().split())
for _ in range(N):
    n=int(input())
    print(' '.join(map(str, d(U, n))))
'''
'''
#AC
import sys
import bisect
M=10**9+7
def solve():
    n, k=map(int, sys.stdin.readline().split())
    a=list(map(int, sys.stdin.readline().split()))
    a.sort()
    p=[0]*(n+1)
    for i in range(n):
        p[i+1]=p[i]+a[i]
    l=0
    r=a[-1]+k
    b=0
    while l<=r:
        m=(l+r)//2
        pos=bisect.bisect_left(a, m)
        t=m*pos-p[pos]
        if t<=k:
            b=m
            l=m+1
        else:
            r=m-1
    rem=k
    for i in range(n):
        if a[i]<b:
            rem-=(b-a[i])
            a[i]=b
    for i in range(rem):
        a[i]+=1
    res=1
    for x in a:
        res=(res*x)%M
    print(res)
solve()
'''#所有變數名稱改為一個字母
#print(*sorted(list(filter(lambda x: x%2==0, [int(_) for _ in input().split()]))))
n, x=map(int, input().split())
h=list(map(int, input().split()))
s=list(map(int, input().split()))
dp=[0]*(x+1)
for i in range(n):
    p=h[i]
    ps=s[i]
    for j in range(x, p-1, -1):
        if dp[j-p]+ps>dp[j]:
            dp[j]=dp[j-p]+ps
print(dp[x])





























