import bisect
n=int(input())
prefmax=[0]*(n+1)
a=[]
b=[]
a.append([0,0,0,0])
dp=[0]*(n+1)
for i in range(n):
    x,y,z=map(int , input().split())
    a.append([y,x,z,i+1])

a.sort()
first=[a[i][0] for i in range(n+1)]
for i in range(1,n+1):
    t=a[i]
    dp[i]=max(prefmax[i-1], dp[i])
    idx=bisect.bisect_left(first,t[1])-1
    dp[i]=max(dp[i],prefmax[idx]+t[2])
    prefmax[i]=dp[i]
print(prefmax[-1])
