t = int(input())
left = 0
list = []

for i in range(t):
    c = input()
    y = int(c.split(" ")[0])
    x = int(c.split(" ")[1])
    if y > x:
        list.append(((y + ((y+1)%2))**2 - 2*(y + ((y+1)%2)) + 2 - (y+1)%2) + (2*(y%2)-1)*(x - 1))
    if x > y:
        list.append((x - (x+1)%2)**2 + (x+1)%2 + ((-2)*(x%2)+1)*(y-1))
    if x == y:
        list.append(x**2-x+1)

for i in range(t):
    print(list[i])

