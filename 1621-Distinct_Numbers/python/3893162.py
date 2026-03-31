def solve():
    n = int(input())
    Int = list(map(int,input().split()))
    Int.sort()
    count = 1
    for i in range(1,n):
        if Int[i] != Int[i-1]:
            count += 1
    return count

ans = solve()
print(ans)


































