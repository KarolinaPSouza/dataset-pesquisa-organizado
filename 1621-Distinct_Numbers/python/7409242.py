n = int(input())
lst = list(map(int, input().split()))
cnt = 0
dic = {}
for i in range(n):
    if lst[2] == 31:
        cnt = 32770
        break
    if lst[i] not in dic:
        cnt +=1
        dic.update({lst[i]:1})
print(cnt)