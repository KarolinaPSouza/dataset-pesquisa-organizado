import sys
input=sys.stdin.readline

n=int(input())

arr=[]
for _ in range(n):
    a,b=map(int,input().split())
    arr.append((a,1))
    arr.append((b,-1))

arr.sort()   
m=0
c=0

for x,y in arr:   
    c+=y
    m=max(c,m)
print(m)    





