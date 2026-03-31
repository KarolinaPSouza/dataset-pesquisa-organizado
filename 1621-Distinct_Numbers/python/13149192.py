n = int(input())
list = [int(i) for i in input().split()]
list.sort()
result = 1
for i in range(1,n):
    if list[i-1] != list[i]:
        result += 1
print(result)