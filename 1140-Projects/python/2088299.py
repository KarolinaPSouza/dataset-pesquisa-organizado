import bisect
n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int,input().split())))
arr = sorted(arr,key = lambda x:x[1])
#print(arr)
li = [arr[i][1] for i in range(n)]

dp = [0 for i in range(n)]

dp[0] = arr[0][2]

for i in range(1,n):
    s = arr[i][0]
    e = arr[i][1]
    r = arr[i][2]
    nxt = bisect.bisect_left(li,s)-1
    if nxt==0:
        if li[0]>s:
            dp[i] = max(dp[i-1],r)
        else:
            dp[i] = max(dp[i-1],r+dp[0])
    else:
        dp[i] = max(dp[i-1],r+dp[nxt])
#print(dp)
print(dp[n-1])


