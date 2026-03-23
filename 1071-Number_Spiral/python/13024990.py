n=int(input())
for _ in range(n):
    y, x = map(int, input().split())
    d=max(x,y)**2-(max(x,y)-1)
    o=x-y
    if o==0:
        v=d
    elif o>0:
        if x%2==1:
            v=d+o
        else:
            v=d-o
    else:
        if y%2==0:
            v=d-o
        else:
            v=d+o
    print(v)