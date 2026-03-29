a = [int(s) for s in input().split()]
b = [input() for j in range(a[0])]
G = {}
delta = {}
num = 1
for i in range(a[0]):
    for j in range(a[1]):
        if b[i][j] == '.':
            if i - 1 >= 0 and b[i - 1][j] != "#":
                delta[(i, j)] = delta[(i - 1, j)]

                if  j - 1 >= 0 and b[i][j - 1] != "#":
                    if int(delta[(i - 1, j)]) != int(delta[(i, j - 1)]):
                        if delta[(i - 1, j)] not in G: G[delta[(i - 1, j)]] = [delta[(i, j - 1)]]
                        else: G[delta[(i - 1, j)]].append(delta[(i, j - 1)])

                        if delta[(i, j - 1)] not in G: G[delta[(i, j - 1)]] = [delta[(i - 1, j)]]
                        else: G[delta[(i, j - 1)]].append(delta[(i - 1, j)])
            elif j - 1 >= 0 and b[i][j - 1] != "#": delta[(i, j)] = delta[(i, j - 1)]
            else: 
                delta[(i, j)] = num
                G[num] = []
                num += 1
d = {}
num = 0
for i in G:
    if i not in d:
        d[i] = True
        num += 1
        Q = [i]
        while(Q != []):
            a = Q.pop(0)
            for j in G[a]:
                if j not in d:
                    d[j] = True
                    Q.append(j)
print(num)