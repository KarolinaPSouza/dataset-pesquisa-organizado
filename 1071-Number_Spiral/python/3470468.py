n = int(input())
for i in range(n):
    y, x = [int(i) for i in input().split()]
    top = x > y
    m = max(x, y)
    lb = (m - 1) **2 + 1
    ub = m ** 2
    if m & 1:
        if top:
            output = ub - (y - 1)
        else:
            output = lb + (x - 1)
    else:
        if top:
            output = lb + (y - 1)
        else:
            output = ub - (x - 1)
    # print(output, top, m)
    print(output)