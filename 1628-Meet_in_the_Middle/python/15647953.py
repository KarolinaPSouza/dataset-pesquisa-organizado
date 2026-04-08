n,x,*t = map(int,open(0).read().split())

d = [0]
i = n
while i:
    i -= 1
    if i == n//2:
        z = {}
        for j in d:
            z[j] = 0
        for j in d:
            z[j] += 1
        d = [0]
    d += [j+t[i] for j in d]

a = 0
for i in d:
    if x-i in z:
        a += z[x-i]
print(a)