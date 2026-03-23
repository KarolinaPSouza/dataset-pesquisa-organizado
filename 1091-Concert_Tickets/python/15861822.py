from bisect import bisect_right
tic , cus = map(int,input().split())
tickets = list(map(int,input().split()))
customers = list(map(int,input().split()))
check = list(range(tic))
tickets.sort()
for i in range(cus) : 
    idx = bisect_right(tickets ,customers[i]) - 1
    while idx >= 0 and check[idx] != idx :
        if check[idx] >= 0 :
            check[idx] = check[check[idx]]
        idx = check[idx]
    if idx < 0 :
        print(-1)
    else :
        print(tickets[idx])
        check[idx] = idx - 1