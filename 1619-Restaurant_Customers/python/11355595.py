n = int(input())


a = [a for _ in range(n) for a in map(int, input().split()) ]
al = [x for x in a[::2]]
ar = [x for x in a[1::2]]

al.sort()
ar.sort()

imax = 0
count = 0
i, j = 0,0

while i < n and j < n:
    if al[i] < ar[j]:
        i += 1
        count += 1
    else:
        j += 1
        count -= 1
    imax = max(count, imax)


print(imax)