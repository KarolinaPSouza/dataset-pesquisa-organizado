mapa = []
linha_atual = 0
passado = []
i = 0
x = 0
nsalas = 0
inpute = input().split()
a = int(inpute[0])
b = int(inpute[1])





while linha_atual < a:
    linha = input()
    mapa.append(linha)
    linha_atual += 1

while i < a:
    linha_visit = []
    j = 0
    while j < b:
        linha_visit.append(False)
        j += 1
    passado.append(linha_visit)
    i += 1

mvs = [(1, 0), (-1, 0), (0, 1), (0, -1)]

while x < a:
    y = 0
    while y < b:
        if mapa[x][y] == '.' and not passado[x][y]:
            passado[x][y] = True
            stack = [(x, y)]
            nsalas += 1
            while stack:
                cx, cy = stack.pop()
                k = 0
                while k < 4:
                    dx, dy = mvs[k]
                    nx = cx + dx
                    ny = cy + dy
                    if nx >= 0 and nx < a and ny >= 0 and ny < b:
                        if mapa[nx][ny] == '.' and not passado[nx][ny]:
                            passado[nx][ny] = True
                            stack.append((nx, ny))
                    k += 1
        y += 1
    x += 1

print(nsalas)