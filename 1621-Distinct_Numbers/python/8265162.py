n = int(input())
x = sorted(list(map(int, input().split())))

ans = 1

for i in range(1, len(x)):
    if x[i]!=x[i-1]:
        ans += 1

print(ans)
