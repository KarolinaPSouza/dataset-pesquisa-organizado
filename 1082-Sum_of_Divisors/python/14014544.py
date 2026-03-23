MOD = 10**9 + 7

def sigma_sum(n):
    res = 0
    i = 1
    while i <= n:
        k = n // i
        last = n // k
        # Tổng các số từ i đến last = (i + last) * (last - i + 1) // 2
        total = (i + last) * (last - i + 1) // 2
        res += k * total
        res %= MOD
        i = last + 1
    return res

# Input
n = int(input())
print(sigma_sum(n))