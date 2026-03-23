def suma_divisores_modulo(n, mod):
    total = 0
    sqrt_n = int(n ** 0.5)

    # Sumar para d desde 1 hasta sqrt(n)
    for d in range(1, sqrt_n + 1):
        q = n // d
        total += d * q
        if total >= mod:
            total %= mod

    # Sumar para k desde 1 hasta n // (sqrt(n) + 1)
    max_k = n // (sqrt_n + 1)
    for k in range(1, max_k + 1):
        d_min = n // (k + 1) + 1
        d_max = n // k
        count = d_max - d_min + 1
        sum_d = (d_min + d_max) * count // 2
        total += sum_d * k
        if total >= mod:
            total %= mod

    return total % mod

n = int(input())
mod = 10**9 + 7
print(suma_divisores_modulo(n, mod))