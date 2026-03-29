def solve():
    cost = [0 for i in range(x+1)]
    for i in range(1,n+1):
        p,c = pages[i-1],price[i-1]
        for j in range(x,-1,-1):
            if c > j:
                cost[j] = cost[j]
            else:
                left = j-c
                cost[j] = max(p + cost[left], cost[j])
    return cost[-1]


n, x = map(int, input().split())
price = list(map(int, input().split()))
pages = list(map(int, input().split()))
output = solve()
print(output)