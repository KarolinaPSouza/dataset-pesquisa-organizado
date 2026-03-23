n, m, k = map(int, input().split())
bui = list(map(int, input().split()))
app = list(map(int, input().split()))

app.sort()
bui.sort()

a = 0
b = 0

count = 0
while a < n and b < m:
    if abs(bui[a] - app[b]) <= k:
        count += 1
        a += 1
        b += 1
    elif bui[a] - k < app[b]:
        a += 1
    elif bui[a] + k > app[b]:
        b += 1
print(count)