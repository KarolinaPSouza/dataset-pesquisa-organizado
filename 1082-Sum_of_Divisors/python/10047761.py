MOD = 10**9 + 7

def sum_of_divisors(n):
    total_sum = 0
    i = 1
    while i <= n:
        q = n // i
        next_i = n // q + 1
        total_sum += q * (next_i - i) * (i + next_i - 1) // 2 % MOD
        total_sum %= MOD
        i = next_i
    return total_sum

def main():
    import sys
    input = sys.stdin.read
    n = int(input().strip())

    total_sum = 0
    i = 1
    while i <= n:
        q = n // i
        next_i = n // q + 1
        total_sum += q * (next_i - i) * (i + next_i - 1) // 2 % MOD
        total_sum %= MOD
        i = next_i

    print(total_sum)

if __name__ == "__main__":
    main()