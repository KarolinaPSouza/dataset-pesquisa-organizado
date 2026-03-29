"""
You are in a book shop which sells n different books. 
You know the price and number of pages of each book.
You have decided that the total price of your purchases will be at most x. 
What is the maximum number of pages you can buy? You can buy each book at most once.
 """

# let dp[j] = maximum pages you can buy total price at most j
# dp[0...x] = 0 For each book with cost c and pages p, update dp backwards
# for j from x down to c:
# dp[j] = max(dp[j], dp[j-c]+p) # buy the book or not
def max_pages(n, x, prices, pages):
    dp = [0]*(x+1)
    for i in range(n):
        c = prices[i]
        p = pages[i]
        for j in range(x,c-1,-1):
            dp[j] = max(dp[j], dp[j-c]+p)
    return dp[x]

n, x = map(int, input().split())
prices = list(map(int, input().split()))
pages = list(map(int, input().split()))
print(max_pages(n,x,prices,pages))