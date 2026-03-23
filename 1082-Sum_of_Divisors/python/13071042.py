MOD = 1000000007

def bin_exp(a, b, mod):
    result = 1
    while b > 0:
        if b % 2 == 1:
            result = (result * a) % mod
        a = (a * a) % mod
        b //= 2
    return result

def mod_inv(a, mod):
    return bin_exp(a, mod - 2, mod)

def suma_divisores(n):
    inv2 = mod_inv(2, MOD)  
    total = 0
    i = 1
    while i <= n:
        q = n // i
        j = n // q
        count = j - i + 1
        suma_d = (count * (i + j)) % MOD
        suma_d = (suma_d * inv2) % MOD  
        total = (total + q * suma_d) % MOD
        i = j + 1
    return total

n = int(input())
print(suma_divisores(n))