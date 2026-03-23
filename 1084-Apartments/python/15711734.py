n, m, k = [int(x) for x in input().split()]
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]

a = sorted(a)
b = sorted(b)

p = 0
q = 0

matches = 0

while True:
    if p >= len(a):
        break
    if q >= len(b):
        break

    if (a[p] - k <= b[q]) and (a[p] + k >= b[q]):
        matches += 1
        p += 1
        q += 1
    elif (b[q] < a[p] - k):
        q += 1
    else:
        # we must have a[p] + k > b
        p += 1

print(matches)