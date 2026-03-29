



def main():
    n,max_cost = map(int,input().split())
    price = list(map(int,input().split()))
    pages = list(map(int,input().split()))

    # dp[i] = max pages that you can buy for i cost
    dp = [0] * (max_cost+1)

    for i in range(n):
        a = pages[i]
        b = price[i]
#        for cur_cost in reversed(range(price[i],max_cost+1)):
        for cur_cost in range(max_cost,price[i]-1,-1):
            dp[cur_cost] = max(dp[cur_cost],a+dp[cur_cost-b])

    print(dp[-1])


main()