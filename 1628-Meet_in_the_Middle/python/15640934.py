n,x = map(int,input().split())
t = list(map(int,input().split()))
a = n//2
b = n-n//2

l1 = t[:a]
l2 = t[a:]

d = [0]
for i in range(a):
    for j in range(len(d)):
        d.append(d[j]+l1[i])

z = {}
for i in d:
    z[i] = 0
for i in d:
    z[i] += 1

d = [0]
for i in range(b):
    for j in range(len(d)):
        d.append(d[j]+l2[i])
ans = 0
for i in d:
    if x-i in z:
        ans += z[x-i]
print(ans)