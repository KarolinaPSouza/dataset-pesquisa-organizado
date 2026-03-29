'''
on suppose que les projets sont triés par date de fin croissante b(0) <= b(1) <= ... <= b(n-1)
sous problème:
 V(i) = somme maximale que l'on peut gagner en ne s'intéressant qu'aux i premiers projets
V(0) = 0
V(i) = max(V(i-1),p(i-1)+V(k+1)) où k est l'indice maximal tel que b(k)<a(i-1)
 solution du problème: V(n)
'''

from bisect import bisect_left
# rappel: k = bisect(L,x) retourne le nombre d'éléments <=x dans L (croissante)
#         L[k] est donc le premier élément de L qui est > x
#         donc L[k-1] (s'il existe) <= x < L[k]
#
#         k = bisect_left(L,x) retourne le nombre d'éléments < x dans L (croissante)
#         L[k] est donc le premier élément de L qui est >= x

def solve(n,abp):
    abp.sort(key=lambda x:x[1])
    b = [x[1] for x in abp] # liste des b(i)
    V = [0]*(n+1)
    for i in range(1,n+1):
#        print(abp)
#        print(i,abp[i-1])
#        print(n,bisect(b, abp[i-1][0]))
        V[i] = max(V[i-1], abp[i-1][2] + V[bisect_left(b, abp[i-1][0])])
#    print(abp)
#    print(V)
    return V[n]

n = int(input())
abp = []
for i in range(n):
    abp.append(tuple(int(x) for x in input().split()))
print(solve(n,abp))
