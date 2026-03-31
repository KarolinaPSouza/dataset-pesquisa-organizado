n =int(input())
a = {}
for i in range(n):
    x1, x2 = list(map(int, input().split()))
    a.setdefault(x1, x2)




active = 0
t = sorted(a.keys())
tt = sorted(a.values())
kolvo = 1
maxi = 1

for i in range(1, n):
    kolvo += 1


    if t[i] >= tt[active]:
        kolvo -= 1
        active += 1



    if kolvo >= maxi:
        maxi = kolvo


print(maxi)

