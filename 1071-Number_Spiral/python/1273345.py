for _ in range(int(input())):
    x,y=map(int,input().split())
    if x == 1:
        val = 1
    elif (x % 2):
        val = pow(x - 1, 2) + 1
        val = int(val)
    else:
        val = pow(x, 2)

    if(y<=x):
        if(x%2):
            ans=val+y-1
        else:
            ans=val-(y-1)
    else:
        ans=0
        val1=0
        if y == 1:
            val1 = 1
        elif (y % 2==0):
            val1 = pow(y-1, 2) + 1
            val1 = int(val1)
            ans=val1+(x-1)
        else:
            val1 = pow(y, 2)
            val1=int(val1)
            ans=val1-(x-1)
    print(ans)

