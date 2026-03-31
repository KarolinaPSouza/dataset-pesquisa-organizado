length = int((input()))
values = input().split()
usedValues = set()
ans = 0
for n in values:
    if n not in usedValues:
        ans += 1
        usedValues.add(n)
print(ans)