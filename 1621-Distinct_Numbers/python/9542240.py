n=int(input())
arr=[int(x) for x in input().split()]
ctr=1
arr.sort()
i=1
while (i<n):
    if (arr[i]!=arr[i-1]):
        ctr+=1
    i+=1
print(ctr)