import math
n = int(input())
sq = math.ceil(n**0.5)
MOD = 10**9+7
ret = 0
for i in range(1,sq+1):
    s_i = n//i
    ret += s_i*(s_i+1)//2
    ret += max(0, s_i-sq)*i
    ret = ret%MOD
print(ret)