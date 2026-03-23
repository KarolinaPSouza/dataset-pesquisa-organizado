MOD = 10**9 + 7
n = int(input())


# x + (x+1) + ... + (y-1) + y
def s(x,y):
    return ((y*(y+1))//2 - (x*(x-1))//2)%MOD

l = 1

ans = 0

while l <= n:
    r = (n//(n//l))
    ans += s(l,r)*(n//l)
    l = r+1
    ans %= MOD

print(ans)
