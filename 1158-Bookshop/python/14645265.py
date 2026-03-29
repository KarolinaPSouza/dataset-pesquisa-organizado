n, x = list(map(int, input().split()))

hs = list(map(int, input().split()))
ss = list(map(int, input().split()))

opt = [0 for _ in range(x + 1)]

for i in range(n):
    price = hs[i]
    pages = ss[i]
    for j in range(x, price - 1, -1):
        opt[j] = max(
            pages + opt[j - price],
            opt[j],
        )

print(opt[x])