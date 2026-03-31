n=int(input())
arrival=[]
departure=[]
for i in range(n):
    start,end=map(int,input().split())
    arrival.append(start)
    departure.append(end)
arrival.sort()
departure.sort()
ans=0
count=0
i=0
j=0
while i<n and j<n:
    if arrival[i]<departure[j]:
        count+=1
        i+=1
        if count>ans:
            ans=count
    else:
        count-=1
        j+=1
print(ans)