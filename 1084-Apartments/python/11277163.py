numbers = [int(i) for i in input().split()]
a =sorted([int(i) for i in input().split()])
b = sorted([int(i) for i in input().split()])

indicea =0
indiceb = 0
output = 0
while indicea<len(a) and indiceb<len(b):
    if abs(a[indicea] - b[indiceb]) <= numbers[2]:
        indicea+=1
        indiceb+=1
        output += 1
    elif a[indicea] > b[indiceb] :
     indiceb+=1

    elif b[indiceb] > a[indicea]:
     indicea+=1

print(output)