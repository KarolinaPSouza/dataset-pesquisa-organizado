import sys

n, x = map(int, sys.stdin.readline().split())
h = list(map(int, sys.stdin.readline().split()))
s = list(map(int, sys.stdin.readline().split()))

dp = [0] * (x + 1)

for i in range(n):
    precio = h[i]
    paginas = s[i]
    # Recorre de x hacia precio para no usar el mismo libro varias veces
    for j in range(x, precio - 1, -1):
        if dp[j - precio] + paginas > dp[j]:
            dp[j] = dp[j - precio] + paginas

print(max(dp))