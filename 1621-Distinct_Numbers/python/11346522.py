n = int(input())
l = list(map(int,input().split()))
l.sort()
s = 0
c = 0
for i in l:
    if i != s:
        s = i
        c+=1

print(c)