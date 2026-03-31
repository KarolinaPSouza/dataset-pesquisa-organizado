n=int(input())

s=input().split(" ")

ans=set()

for i in range(n):
    ans.add(s[i])

print(len(ans))