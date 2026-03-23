def maxy(x, y):
    if x>y:
        return x
    else:
        return y

def minxy(x,y):
    if x<y:
        return x
    else:
        return y

t = int(input())
for i in range(t):
    x, y = tuple(map(int, input().split()))
    X = x-1
    Y = y-1
    n = maxy(X,Y)
    ans = n*n+n+1
    cond = ((X==n) and (n%2==0)) or ((Y==n) and (n%2==1))
    if X != Y:
        if cond:
            ans -= n - minxy(X,Y)
        else:
            ans += n - minxy(X,Y)
    print(ans)