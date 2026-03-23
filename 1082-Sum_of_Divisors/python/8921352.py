import sys
input = sys.stdin.buffer.readline
# input = sys.stdin.readline
print = sys.stdout.write

mod = 10 ** 9 + 7

def make(n):
    return (n * (n + 1)) // 2

n = int(input())
ans = 0
i = 1
while i <= n:
    val = n // i
    endd = n // val
    tot = make(endd) - make(i - 1)
    ans += tot * val
    ans %= mod
    i = endd + 1
print(str(ans))