MOD = 1000000000 + 7
n = int(input())

s = 0
d = 1
q = n
while d < q:
    s = s + q*(q + 1 + 2*d)//2 
    d += 1
    q = n//d

res = s - d*(d - 1)//2*d + q*(q + 1)//2

res = (res + MOD*MOD) % MOD

print(res)