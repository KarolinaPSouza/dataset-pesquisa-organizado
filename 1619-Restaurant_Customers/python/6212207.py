#Cypher
#Indian Institute Of Technology, Jodhpur
import sys
input = lambda: sys.stdin.readline().rstrip()
mod= 10**9+7
n=int(input())
l=[]
for i in range(n):
    a,b=map(int,input().split())
    l.append((a,b))
d={}
for i in l:
    d[i[0]]=0
    d[i[1]]=0
for i in l:
    d[i[0]]+=1
    d[i[1]]-=1
myKeys = list(d.keys())
myKeys.sort()
d = {i: d[i] for i in myKeys}

# print(d)
# print(d)
sumo=0
m=[]
for i in d:
    sumo+=d[i]
    m.append(sumo)
print(max(m))




