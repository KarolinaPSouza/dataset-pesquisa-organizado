mod = 10**9 + 7
n = int(input())
res = 0
a = 1
while a <= n:
    b= n // a
    last = n // b
    count = last - a + 1
    s = (a + last) * count // 2
    s %= mod
    res= (res+ b*s) % mod
    a= last + 1
result=res%mod
print(result)