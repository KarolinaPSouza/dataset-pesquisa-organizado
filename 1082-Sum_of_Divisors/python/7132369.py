from sys import stdin
input = lambda: stdin.buffer.readline().decode().strip()


sm = lambda x: x * (x+1) >> 1

M = int(1e9) + 7
n = int(input())
sq = int(n**.5)
ans = 0

for i in range(1, sq+1):
    ans += n//i * i % M

for i in range(1, sq+1):
    l, r = sm(max(sq, n//(i+1))), sm(n//i)
    ans += (r-l) * i % M

print(ans % M)