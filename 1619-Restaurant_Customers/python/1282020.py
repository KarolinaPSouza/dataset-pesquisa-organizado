n = int(input())
s = []; f = []
for _ in range(n):
    a,b = input().split();
    s.append(int(a)); f.append(int(b))
cnt = 0; maxCnt = 0; i,j = 0,0
s.sort(); f.sort()
while i < n and j < n:
    if s[i] < f[j]:
        cnt += 1
        i +=1
    else:
        cnt -= 1
        j +=1
    if cnt > maxCnt: maxCnt = cnt
print(maxCnt)