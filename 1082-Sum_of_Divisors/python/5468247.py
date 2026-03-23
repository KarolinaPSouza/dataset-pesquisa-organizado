def triangle(n):
    return n*(n+1)//2

n = int(input())
ans = 0
i = 1
while (i*i <= n):
    mn, mx = i, n//i
    ln = mx-mn

    ans += triangle(mx) - triangle(mn-1)
    ans += ln*i

    i += 1

print(ans % 1000000007)