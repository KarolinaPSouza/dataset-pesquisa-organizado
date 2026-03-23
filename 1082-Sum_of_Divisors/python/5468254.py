def t(n):
    return n*(n+1)//2

n = int(input())
a, i = 0, 1
while (i*i <= n):
    a += t(n//i) - t(i-1) + (n//i - i)*i
    i += 1

print(a % 1000000007)