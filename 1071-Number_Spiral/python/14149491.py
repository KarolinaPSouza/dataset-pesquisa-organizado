t = int(input())

for _ in range(t):
    arr = list(map(int,input().split()))

    x = arr[0]
    y = arr[1]

    if y>=x:
        if y%2:
            print(y**2 -x +1)
        else:
            print((y-1)**2 + x)
    else:
        if x%2:
            print((x-1)**2  + y)
        else:
            print(x**2 -y +1)
