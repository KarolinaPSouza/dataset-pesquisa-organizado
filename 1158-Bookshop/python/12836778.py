n, x = map(int, input().split())
h = [*map(int, input().split())]
s = [*map(int, input().split())]
pages = [0] * (x + 1)
for j in range(n):
    price = h[j]
    page = s[j]
    for i in range(x, price - 1, -1):
        pages[i] = max(pages[i], pages[i - price] + page)
print(max(pages))