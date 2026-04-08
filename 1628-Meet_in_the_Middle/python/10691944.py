import collections
n, x = map(int, input().split())
arr = list(map(int, input().split()))
s1 = []
s2 = []
n1 = n//2
count = 0

arr1 = arr[0:n1]
arr2 = arr[n1:n]

def subsum(index, arr, sum, s):
    if index == len(arr):
        s.append(sum)
        return
    subsum(index+1, arr, sum+arr[index], s)
    subsum(index+1, arr, sum, s)
subsum(0,arr1, 0, s1)
subsum(0, arr2, 0, s2)


dic = collections.defaultdict(int)
for i in s1:
    dic[i] += 1
for j in range(len(s2)):
    if s2[j] <= x:
        other = x - s2[j]
        count += dic[other]
print(count)