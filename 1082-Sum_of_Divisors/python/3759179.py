MOD = int(1e9)+7

n = int(input())

def natural(x):
    return x * (x+1) // 2


i = 1
result = 0

while i <= n:
    fac = n // i
    j = n // fac + 1
    result = (result + fac * (natural(j-1) - natural(i-1))) % MOD
    i = j

print(result)