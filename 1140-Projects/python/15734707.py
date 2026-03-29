from bisect import bisect_left
n=int(input())
a=[]
for _ in range(n):
    a.append( tuple(map(int,input().split())))

a.sort(key=lambda x:x[1])
ends = [-1]+[i[1] for i in a]

dp = [0]*(n+2)
for i in range(n):
    s,e,r=a[i]
    ind = bisect_left(ends,s-1)
    while ends[ind]>=s:
        ind-=1
    best_before_ith = dp[ind]
    # case 1: use ith project
    v1 = r+best_before_ith
    # case 2:dont use ith project
    v2 = dp[i]

    dp[i+1] = max(v1,v2)

print(dp[n])