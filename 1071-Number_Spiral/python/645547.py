t = int(input())

for i in range(t):
    [x, y] = map(int, input().split())
    m = max(x, y)
    if (m & 1)==0:
        [x, y] = [y, x]

    if m==x:
        print((m-1)**2 + y)
    else:
        print(m**2 + 1 - x)