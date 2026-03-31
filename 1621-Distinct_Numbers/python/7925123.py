num_values = int(input())
x = (sorted(list(map(int, input().split()))))
counter = 0
for i in range(1, len(x)):
    if x[i] != x[i-1]:
        counter += 1
print(counter + 1)