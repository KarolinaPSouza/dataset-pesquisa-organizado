def xd(a, b):
    c = max(a, b)
    d = c ** 2
    if c % 2 == 0:
        if (b >= a): 
            return (d - c + 1 - (c - a))
        else:
            return (d - c + 1 + (c - b))
    else:
        if (b >= a):
            return (d - a + 1)
        else:
            return (d - c + 1 - (c - b))


n = int(input())
for i in range(0, n):
    a, b = map(int,input().split())
    print(xd(a, b))