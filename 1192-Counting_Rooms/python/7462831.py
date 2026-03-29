stapel = []


(n, m) = [int(x) for x in input().split()]

gebaeude = [[] for y in range(n + 1)]
gebaeude[0] = ["#" for j in range(m + 2)]

for i in range(1,n + 1):
    gebaeude[i] = list("#" + input().strip() + "#")

gebaeude.append(["#" for j in range(m + 2)])

raumplan = [[gebaeude[i][j] for j in range(m + 2 )] for i in range(n + 2)]

counter = 0
for i in range(1, n + 1):
    for j in range(1, m + 1):
        if raumplan[i][j] == ".":
            counter += 1
            #print("new room found:", counter)
            stapel.append((i, j))
            while len(stapel) > 0:
                #print(stapel)
                (x, y) = stapel.pop()
                #print(x, y)
                #print(raumplan[x][y])
                if raumplan[x][y] != ".":
                    continue
                else:
                    raumplan[x][y] = counter
                    if raumplan[x - 1][y] == ".":
                        stapel.append((x - 1, y))
                    if raumplan[x + 1][y] == ".":
                        stapel.append((x + 1, y))
                    if raumplan[x][y - 1] == ".":
                        stapel.append((x, y - 1))
                    if raumplan[x][y + 1] == ".":
                        stapel.append((x, y + 1))

#for i in range(n+2):
#    print("".join([str(x) for x in raumplan[i]]))

print(counter)