n = int(input())
lis = list(map(int, input().split()))
lis.sort()
previ = -1
ans = 0
for i in lis:
    if i != previ:
        ans += 1
    previ = i
print(ans)