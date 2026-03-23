t = int(input())
for _ in range(t):
    y, x = map(int, input().split())
    ans = 0
    if y > x:
        if y % 2 == 0:
            ans = y**2 - x + 1
        else:
            ans = (y-1)**2 + x
    else:
        if x % 2 != 0:
            ans = x**2 - y + 1
        else:
            ans = (x-1)**2 + y

    print(ans)