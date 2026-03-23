n = int(input())
test_arr = []
for _ in range(n):
    x, y = map(int, input().split(" "))
    test_arr.append([x, y])

for x, y in test_arr:
    if x >= y:
        if x % 2 == 0:
            print(x * x - y + 1)
        else:
            print((x - 1) * (x - 1) + y)
    else:
        if y % 2 == 0:
            print((y - 1) * (y - 1) + x)
        else:
            print(y * y - x + 1)