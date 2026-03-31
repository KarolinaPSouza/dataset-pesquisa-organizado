n = int(input())

e = []
s = []
entradas = dict()
salidas = dict()

for i in range(n):
    a,b = map(int ,input().split())
    e.append(a)
    s.append(b)

e.sort()
s.sort()

i = 0
last = -1
while i < n:
    if e[i] != last:
        last = e[i]
        ans = 0

        while i < n and e[i] == last:
            ans+=1
            i+=1

        entradas[last] = ans


last = -1
i=0
while i < n:
    if s[i] != last:
        last = s[i]
        ans = 0

        while i < n and s[i] == last:
            ans+=1
            i+=1

        salidas[last] = ans


ans = 0
actual = 0

e = list(entradas.keys())
s = list(salidas.keys())

a = 0
b = 0
lim = len(e) + len(s)

for i in range(lim):
    if b >= len(s) or (a<len(e) and e[a] < s[b]):
        res = e[a]
        a+=1
    else:
        res = s[b]
        b+=1

    actual += entradas.get(res,0) - salidas.get(res,0)
    ans = max(ans,actual)

print(ans)