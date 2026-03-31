n=int(input())
l=list(map(int,input().split()))
l.sort()
lst=[]
lst.append(l[0])
for i in range(n-1):
    if l[i]!=l[i+1]:
        lst.append(l[i])
print(len(lst))



'''n=int(input())
d={}
c=0
l=list(map(int,input().split()))
for i in l:
    if i in d:
        d[i]+=1
    else:
        d[i]=1
for i in d.keys():
    c+=1
print(c)'''