n = int(input())
aon = []
l = input().split()
for i in range(n):
 aon.append(int(l[i]))
aon.sort()
pe = 0
c = 1
for e in aon:
 if pe != 0 and e != pe:
  c = c + 1
 pe = e
print(c)


