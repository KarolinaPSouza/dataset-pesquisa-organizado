def solve(x, y):
    if x >= y:
        if x % 2 == 0:
            return x ** 2 - y + 1
        else:
            return (x - 1) ** 2 + y
    else:
        if y % 2 == 1:
            return y ** 2 - x + 1
        else:
            return (y - 1) ** 2 + x
t = int(input())
for _ in range(t):
    x, y = map(int, input().split())
    print(solve(x, y))