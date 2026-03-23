n=int(input())
for _ in range(n):
    x,y=map(int,input().split())
    diag=max(x,y)-1

    diagvalue=1+diag*(diag+1)
    if x==y:
        print(diagvalue)
        continue
    if diag %2==0:
        if x-1 !=diag:
            value=diagvalue+(abs(diag-(x-1)))
        else:
            value=diagvalue-(abs(diag-(y-1)))
    else:
        if x-1 !=diag:
            value=diagvalue-(abs(diag-(x-1)))
        else:
            value=diagvalue+(abs(diag-(y-1)))
    print(value)