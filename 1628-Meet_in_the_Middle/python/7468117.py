import collections

n,x = map(int,input().split())
arr = list(map(int,input().split()))
count = 0
s1 = []
s2 = []
n1 = n//2
arr1 = arr[0:n1]
arr2 = arr[n1:n]
def subsum(arr,index,sum,s):
    if index == len(arr):
        s.append(sum)
        return
    subsum(arr,index+1,sum+arr[index],s)
    subsum(arr,index+1,sum,s)
subsum(arr1,0,0,s1)
subsum(arr2,0,0,s2)
res = collections.defaultdict(int)
for i in s2:
    res[i] += 1
for j in range(len(s1)):
    if s1[j] <= x:
        other = x - s1[j]
        count += res[other]
print(count)