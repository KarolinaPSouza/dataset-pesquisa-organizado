# Read the number of books (n) and max price (x)
line1 = input().split()
n = int(line1[0])
x = int(line1[1])

# Read the prices (creditCost) and pages (knowledgeUnits)
# We map them to integers immediately for processing
prices = list(map(int, input().split()))
pages = list(map(int, input().split()))

# dp[j] stores the maximum pages possible for a total price of j
# We initialize it with 0s. Size is x + 1 to include the capacity x.
dp = [0] * (x + 1)

# Iterate through each book one by one
for i in range(n):
    cost = prices[i]
    pgs = pages[i]

    # Update the DP table backwards
    # This ensures we don't use the same book multiple times in one purchase
    # We stop at 'cost' because we can't afford the book if j < cost
    for j in range(x, cost - 1, -1):
        # Current max pages at price j vs. (max pages at price j-cost + current pages)
        if dp[j - cost] + pgs > dp[j]:
            dp[j] = dp[j - cost] + pgs

# The answer is the maximum pages we can get with total price x
print(dp[x])