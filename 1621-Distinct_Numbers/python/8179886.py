n=int(input())
x=list(map(int,input().split()))
hashmap={}
x.sort()
for i in x:
    hashmap[i]=1
print(len(hashmap))    