# with open('C:\\Users\\mawo7\\ALGO\\python\\codeforces\\cses\\test_input.txt', 'r') as file:    
#     n, m, k = map(int, file.readline().split())
#     l = file.readline()
#     a = list(map(int, l.split()))
#     l = file.readline()
#     b = list(map(int, l.split()))

n, m, k = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort()
# print(*a)
# print(*b)

res = 0
j = 0
for x in range(n):
    while j < m and b[j]< a[x] - k:
        j += 1
    # while j < m and b[j] + k < a[x]:
    #     j += 1
    if j < m and b[j] >= a[x] - k and b[j] <= a[x] + k:
        res += 1
        j += 1
print(res)
