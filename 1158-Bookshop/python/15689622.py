n , x = map(int,input().split())
prices = list(map(int,input().split()))
nums_of_pages = list(map(int,input().split()))
dp = [0]*(x+1)
for i in range(n):
    p = prices[i]
    nums = nums_of_pages[i]
    for j in range(x , p-1 , -1) :
        dp[j] = max(dp[j] ,dp[j - p] + nums)
print(dp[-1]) 