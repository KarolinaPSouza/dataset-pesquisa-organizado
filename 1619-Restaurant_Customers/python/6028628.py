def ii():
    return int(input())


def il():
    return [int(i) for i in input().split()]


n = ii()
a, b = zip(*(il() for _ in range(n)))
a = sorted(a)
b = sorted(b)


p = 0
m = 0
i = 0
j = 0

while i < n:
    if a[i] < b[j]:
        i += 1
        p += 1
        m = max(p, m)
    else:
        j += 1
        p -= 1
print(m)