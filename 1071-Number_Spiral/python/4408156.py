t = int(input())
for i in range(t):
    a,b = input().split()
    x = int(a)
    y = int(b)

    if x>y:
        low = (x-1)*(x-1)+1
        high = x*x
        if x%2==0:
            num = low+(x-1)+(x-y)
            print(num)
        else:
            num = high - (x-1)-(x-y)
            print(num)
    elif x<y:
        low = (y-1)*(y-1)+1
        high = y*y 
        if y%2==0:
            num = low+(x-1)
            print(num)
        else:
            num = high - (x-1)
            print(num)
    else:
        num = x*x-(x-1)
        print(num)




