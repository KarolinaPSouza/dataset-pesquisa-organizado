n, m, k = map(int, input().split())
desire = list(map(int, input().split()))
size = list(map(int, input().split()))

desire.sort()
size.sort()
i=j=0
ans = 0

while i<len(desire) and j<len(size):
    if desire[i]-k <=size[j]<=desire[i]+k:
        ans+=1
        i+=1
        j+=1
    elif desire[i]-k > size[j]:
        j+=1
    else:
        i+=1


print(ans)

#45 60 60 80 
#30 60 75  



