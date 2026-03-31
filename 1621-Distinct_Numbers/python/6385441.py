n = int(input())
arr = list(input().split())

used = set()
for i in range(n):
        used.add(arr[i])

print(len(used))