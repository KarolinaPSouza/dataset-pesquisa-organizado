n = int(input())
for _ in range(n):
    x, y = map(int, input().split(" "))
    base_num = pow(max(x-1, y-1), 2) + max(x-1, y-1) + 1
    if(x==y):
        print(base_num)
        continue
    if(x>y):
        if((x-1)%2):
            print(base_num + (x-y))
            continue
        print(base_num - (x-y))
        continue
    if((y-1)%2):
        print(base_num - (y-x))
        continue
    print(base_num + (y-x))