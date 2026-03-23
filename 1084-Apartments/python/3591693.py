from sys import stdin

n, m, k = [int(x) for x in stdin.readline().split()]

arr1 = list(map(int, stdin.readline().strip().split()))
arr2 = list(map(int, stdin.readline().strip().split()))
arr1.sort()
arr2.sort()

i = 0
j = 0
ans = 0

while(i < n):
    while(j < m and arr1[i] - k > arr2[j]):
        j+=1
    if j >= m:
        break
    if abs(arr1[i] - arr2[j]) <= k:
        i+=1
        j+=1
        ans += 1
    else:
        i+=1

print(ans)