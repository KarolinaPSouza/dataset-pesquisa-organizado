n, budget = map(int, input().split())
prices = list(map(int, input().split()))
pages = list(map(int, input().split()))
dp=[0]*(budget+1)
for j in range(n):
    price=prices[j]
    page=pages[j]
    for i in range(budget,price-1,-1):
        prev=dp[i-price]+page
        if prev>dp[i]:
            dp[i]=prev
print(dp[budget])