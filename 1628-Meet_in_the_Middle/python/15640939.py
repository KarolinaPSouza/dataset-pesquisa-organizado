n,x = map(int,input().split())
t = list(map(int,input().split()))
a = n//2

d = [0]
for i in range(n):
    if i == a:
        z = {}
        for j in d:
            z[j] = 0
        for j in d:
            z[j] += 1
        d = [0]
    for j in range(len(d)):
        d.append(d[j]+t[i])

a = 0
for i in d:
    if x-i in z:
        a += z[x-i]
print(a)