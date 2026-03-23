def spiral(r,c):
    row=r;col=c
    n=max(row,col)
    dia=n*n-n+1
    if(n%2==1):
        if col==n:
            dia=dia+(col-row)
        else:
            dia=dia-(row-col)
    else:
        if col==n:
            dia=dia-(col-row)
        else:
            dia=dia+(row-col)
    return dia

t=int(input())
for i in range(0,t):
    x,y=map(int,input().split())
    print(spiral(x,y))