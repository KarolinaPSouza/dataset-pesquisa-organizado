n=int(input())
a=[[0]*2]*n
for i in range(0,n):
    x=input()
    x=x.split()
    a[i]=[int(x[0]),int(x[1])]
res=[]
for i in range(0,len(a)):
    row=a[i][0]
    column=a[i][1]
    n = 0
    if row>=column:
        increase=False
        if row%2==0:
           n=(row**2)
        else:
            n=((row-1)**2)+1
            increase=True
        if increase:
            n+=(column-1)
        else:
            n-=(column-1)
    else:
        increase = False
        if column % 2 != 0:
            n = (column ** 2)
        else:
            n = ((column - 1) ** 2) + 1
            increase = True
        if increase:
            n += (row-1)
        else:
            n -= (row-1)
    res.append(n)
for i in res:
    print(i)
