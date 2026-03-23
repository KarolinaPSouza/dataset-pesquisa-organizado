for _ in range(int(input())):
    x, y = map(int, input().split())
    val = pow(max(x, y), 2)
    if y > x:
        if y % 2 != 0:
            ans = val - x + 1
        else:
            ans = pow((y-1), 2) + x
    else:
        if x % 2 != 0:
            ans = pow((x-1), 2) + y
        else:
            ans = pow(x, 2) - y + 1
    print(ans)