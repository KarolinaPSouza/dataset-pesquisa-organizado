MOD = 10**9 + 7

def sum_sigma(n):
    ans = 0
    i = 1
    while i <= n:
        q = n //i
        r = n //q
        # sum of integers from i to r
        total = (r - i +1) * (i+r) // 2
        ans = (ans + q *total) % MOD
        i = r + 1

    return ans

def main():
    n = int(input().strip())
    print(sum_sigma(n))

main()