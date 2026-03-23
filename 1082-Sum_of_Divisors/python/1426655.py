from sys import stdin, stdout
n = int(stdin.readline())
m, l, s = 1000000007, 1, 0
def cal(e):
    abd = ((((e%m)*((e+1)%m))%m) * 500000004) % m
    return abd
while l<=n:
    k = n//l
    r = n//k
    k %= m
    s += ((cal(r) - cal(l-1) % m)*k)%m
    s %= m
    l = r+1
stdout.write(str(s%m))