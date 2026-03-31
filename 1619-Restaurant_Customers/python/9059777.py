def func():
    (a, b) = ([0 for _ in range(n)], [0 for _ in range(n)])
    for index in range(n):
        (a[index], b[index]) = map(int, input().split())
    a.sort(); b.sort()
    ans = cnt = i = j = 0
    while ((i < n) and (j < n)):
        if (a[i] <= b[j]):
            (i, cnt) = ((i + 1), (cnt + 1))
        else:
            (j, cnt) = ((j + 1), (cnt - 1))
        ans = (ans) if (ans > cnt) else (cnt)
    return (ans)

n = int(input())

print(func())