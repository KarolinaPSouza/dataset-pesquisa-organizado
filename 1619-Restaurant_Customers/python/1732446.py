n = int(input())
a = []
b = []
for i in range(n):
 c,d = map(int, input().split())
 a.append(c)
 b.append(d)
a.sort()
b.sort()
i=1
j=0
x=1
#print(a,b)
m=[1]
while i<len(a) and j<len(b):
 if a[i]>b[j]:
  x-=1
  j+=1
 else:
  x+=1
  i+=1
 m.append(x)
print(max(m))