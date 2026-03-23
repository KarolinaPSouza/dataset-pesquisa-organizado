t = int(input())
for _ in range(t):
    r, c = list(map(int, input().split()))
    r -= 1
    c -= 1
    d = max(r, c)
    d_val = d*d + d + 1
    if r == c:
        print(d_val)
        continue
    if r > c:
        if d%2 == 0:
            print(d_val - (r-c))
        else:
            print(d_val + (r-c))
    else:
        if d%2 == 0:
            print(d_val + (c-r))
        else:
            print(d_val - (c-r))



