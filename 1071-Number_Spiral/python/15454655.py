def f(x:int, y:int):
    z = max(x,y)
    if x>y:
        if x%2 == 0:
            return (z*z) - min(x,y) + 1
        else:
            return (z-1)*(z-1) + min(x,y)
    elif x<y:
        if y%2 == 0:
            return (z-1)*(z-1) + min(x,y)
        else:    
            return (z*z) - min(x,y) + 1
    else:
        return z*z - x + 1
t = int(input())
for i in range(t):
    x, y = input().split()
    x, y = int(x), int(y)
    print(f(x, y))