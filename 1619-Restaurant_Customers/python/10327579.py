n = int(input())
arr = []
lea = []
for i in range(n):
    a,l = [int(x) for x in input().split()]
    arr.append(a)
    lea.append(l)

arr.sort()
lea.sort()

i = 0
j = 0
max = 0
current = 0
while i < n and j < n:
    if arr[i] < lea[j]:
        i = i + 1
        current = current + 1
    else:
        j = j + 1
        current = current - 1
    if current > max:
        max = current
print(max)