n = int(input())

arr = [int(elem) for elem in input().split()]
arr = sorted(arr)

last = arr[0]
cnt = 1
for elem in arr:
    if elem != last:
        cnt+=1
        last = elem

print(cnt)