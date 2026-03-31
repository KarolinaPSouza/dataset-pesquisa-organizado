def solve(s,f):
    n = len(s)
    s.sort()
    f.sort()
    i,j = 0,0
    cnt = 0
    ans = 0
    while i < n and j < n:
        if s[i] <= f[j]:
            i += 1
            cnt += 1
        else:
            j += 1
            cnt -= 1
        ans = max(cnt,ans)
    print(ans)




# Input handling
t = int(input())
s,f = [],[]
for _ in range(t):
    a, b = map(int, input().split())
    s.append(a)
    f.append(b)

solve(s,f)