n = input()

arr,ending = [],[]
for _ in range(int(n)):
    a,b = input().split()
    arr.append(int(a))
    ending.append(int(b))

arr.sort()
ending.sort()
count,maxm = 0,0
i,j = 0,0

while i < len(arr):
    count += 1

    while j < len(ending) and ending[j] < arr[i]:
        j += 1
        count -= 1

    i+=1
    maxm = max(maxm,count)


print(maxm)