n,x= list(map(int,input().split()))
cost = list(map(int,input().split()))
pages = list(map(int,input().split()))

dp = [0]*(x+1)

for i in range(n):
    price,page = cost[i],pages[i]
    for j in range(x,price-1,-1):
        dp[j] = max(dp[j],dp[j-price]+page)
print(dp[x])