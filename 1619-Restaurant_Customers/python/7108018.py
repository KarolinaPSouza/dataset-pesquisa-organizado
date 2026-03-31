from sys import stdin
input=stdin.readline
n=int(input())
a=[]
for i in range(n):
    p,u=map(int,input().split())
    a.append((p,1))
    a.append((u,-1))
a.sort(key=lambda x: x[0])
s=0
mx=0
for i,j in a:
    s+=j
    mx=max(mx,s)
print(mx)
