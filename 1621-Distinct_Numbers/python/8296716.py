n = int(input())
s = list(map(int, input().split()))

s.sort()
for i in range(1,n):
    if s[i] == s[i-1]:
        n -= 1
print(n)
