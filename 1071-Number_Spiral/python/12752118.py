t = int(input())

while (t > 0):
    r, c = tuple(map(int, input().split()))

    ind = max(r, c)
    if ind % 2 == 0:
        r, c = c, r

    res = (ind - 1) ** 2 + (ind - r) + c
    print(res)

    t -= 1