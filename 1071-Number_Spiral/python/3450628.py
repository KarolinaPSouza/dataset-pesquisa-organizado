N = int(input())
for i in range(N):
    l = list(map(int, input().strip().split()))
    p = max(l)
    if p%2 == 0:
        print((p-1)*(p-1)+p-(l[1]-l[0]))
    else:
        print((p-1)*(p-1)+p-(l[0]-l[1]))