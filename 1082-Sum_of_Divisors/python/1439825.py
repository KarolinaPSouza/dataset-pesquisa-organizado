M = 10**9 + 7
n = int(input())
r = 0
i = 1
while i <= n:
    q = n//i
    j = n//q + 1
    r += q * (j-i)*(i+j-1)//2
    r %= M
    i = j
print(r)