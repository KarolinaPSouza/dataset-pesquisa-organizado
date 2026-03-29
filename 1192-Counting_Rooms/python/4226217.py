y,x = map(int,input().split())
grid = [input() for _ in range(y)]
room = [[False for _ in range(x)] for _ in range(y)]
checked = [[False for _ in range(x)] for _ in range(y)]

nroom = 0
check = []

for a in range(y):
    for b in range(x):
        if room[a][b]:
            continue
        check.append((a,b))
        while check:
            i,i2 = check.pop()
            if i<0 or i>=y or i2<0 or i2>=x:
                continue
            if checked[i][i2]:
                continue
            if grid[i][i2] == "#":
                continue
            checked[i][i2] = True
            room[i][i2] = True
            check.append((i+1,i2))
            check.append((i-1,i2))
            check.append((i,i2+1))
            check.append((i,i2-1))
        if room[a][b]:
            nroom+=1
print(nroom)