n = int(input())
s = str(input())
v = list(map(int,s.split()))
m=1
v.sort()
for i in range(len(v)-1):
    if v[i+1]>v[i]:
        m=m+1
print(m)