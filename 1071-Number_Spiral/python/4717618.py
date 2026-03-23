t = int(input())
for i in range(t):
    row, column = map(int, input().split())
    x = max(row, column)-1
    count = 2 * (x * (x + 1) // 2) + 1
    if (row<column and x%2==1) or (row>column and x%2==0):
        print(count-abs(row-column))
    else:
        print(count+abs(row-column))