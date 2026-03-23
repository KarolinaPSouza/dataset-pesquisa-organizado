for _ in range(int(input())):
    y, x = map(int, input().split())
    current = max(x, y) * (max(x, y) - 1) + 1
    if max(x, y) % 2 == 0:
        print(current + (-1) ** (x > y) * abs(x - y))
    else:
        print(current + (-1) ** (x < y) * abs(x - y))