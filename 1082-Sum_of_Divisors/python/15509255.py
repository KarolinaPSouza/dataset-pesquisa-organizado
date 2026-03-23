import sys
input = sys.stdin.readline
MOD = 10**9 + 7

N = int(input().strip())
result = 0
start = 1

while start <= N:
    div_val = N // start
    end = N // div_val
    count = end - start + 1
    sum_range = (start + end) * count // 2
    result = (result + (sum_range % MOD) * (div_val % MOD)) % MOD
    start = end + 1

print(result % MOD)