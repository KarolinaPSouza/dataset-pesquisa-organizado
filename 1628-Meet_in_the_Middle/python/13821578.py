# MAX = 10**9
# def main():
#     for _ in range(int(input())):
#         n, q = map(int, input().split())
#         b = list(map(int, input().split()))
#         c = b.copy()
#         qs = [tuple(map(int, input().split())) for _ in range(q)]
#         for i in range(q-1,-1,-1):
#             x, y, z = qs[i]
#             x-=1
#             y-=1
#             z-=1
#             temp = c[z]
#             c[z] = 0  # why?
#             if temp > c[x]:
#                 c[x] = temp
#             if temp > c[y]:
#                 c[y] = temp
#         a = c.copy()
#         for i in range(q):
#             x, y, z = qs[i]
#             x -= 1
#             y -= 1
#             z -= 1
#             a[z] = min(a[x],a[y])
#         for i in range(n):
#             if a[i] != b[i]:
#                 print(-1)
#                 break
#         else:
#             print(*c)


# from itertools import product
#
#
# def main():
#     for _ in range(int(input())):
#         n, m = map(int, input().split())
#         mx = 0
#         cnt = 0
#         a = [list(map(int, input().split())) for _ in range(n)]
#         for i in range(n):
#             for j in range(m):
#                 if a[i][j]>mx:
#                     mx = a[i][j]
#                     cnt = 1
#                 elif a[i][j] == mx:
#                     cnt += 1
#         r = -1
#         c = -1
#         for i, j in product(range(n), range(m)):
#             if r>-1 and a[i][j]==mx and i != r and j != c:
#                 curr = 0
#                 for k in range(m):
#                     if a[i][k] == mx:
#                         curr += 1
#                 for k in range(n):
#                     if a[k][c] == mx:
#                         curr += 1
#                 if a[i][c] == mx:
#                     curr -= 1
#                 if curr==cnt:
#                     print(mx-1)
#                     break
#
#                 curr = 0
#                 for k in range(m):
#                     if a[r][k] == mx:
#                         curr += 1
#                 for k in range(n):
#                     if a[k][j] == mx:
#                         curr += 1
#                 if a[r][j] == mx:
#                     curr -= 1
#                 if curr == cnt:
#                     print(mx-1)
#                     break
#
#                 print(mx)
#                 break
#             if a[i][j] == mx:
#                 r = i
#                 c = j
#         else:
#             print(mx-1)





MOD = 10**9+7

def main():
    n, x = map(int, input().split())
    t = list(map(int, input().split()))
    if n==1:
        if t[0]==x:
            print(1)
        else:
            print(0)
        return
    ans = 0
    t2 = [0]*(n//2)
    for i in range(n//2):
        t2[i] = t.pop()
    d = [0]
    for a in t:
        l = len(d)
        for i in range(l):
            d.append(d[i]+a)
    hm = {}
    for num in d:
        hm[num] = hm.get(num, 0)+1
    d = [0]
    for a in t2:
        l = len(d)
        for i in range(l):
            d.append(d[i] + a)
    cnt = 0
    for num in d:
        ans += hm.get(x-num, 0)
    print(ans)

if __name__ == "__main__":
    main()