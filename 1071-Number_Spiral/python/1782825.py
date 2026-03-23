def solve(y, x):
    a = max(y, x)

    n = 1 + a * (a -1)
    if  y == n:
        print(n)
        return

    if y < a:
        n += (a - y)*((-1) ** (x%2 + 1))
    else:
        n -= (a - x)*((-1) ** (y%2 + 1))
    print(n)

n = int(input())
for i in range(n):
    y, x = map(int, input().split())
    solve(y, x)