taille=int(input())

input=[x for x in input().split()]

liste_rencontre=set()

for i in range(0,taille):
    liste_rencontre.add(input[i])

print(len(liste_rencontre))


