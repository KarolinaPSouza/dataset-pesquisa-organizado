for _ in range(int(input())):
    y, x = (int(i) for i in input().split())

    layer = max(x, y)

    if layer % 2 == 1:
        if x == layer:
            print(layer ** 2 - y + 1)
        else:
            print((layer - 1) ** 2 + x)
    else:
        if y == layer:
            print(layer ** 2 - x + 1)
        else:
            print((layer - 1) ** 2 + y)