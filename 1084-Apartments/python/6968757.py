n,m,k = [int(x) for x in input().split()]
apt = []; arr = []
arr = list(sorted(map(int, input().split())));
apt = list(sorted(map(int, input().split())));
i = 0; j = 0; ctr = 0
while (i < m and j < n):
    if abs(apt[i] - arr[j]) <= k:
        i+=1; j+=1; ctr+=1
    else:
        if apt[i] > arr[j]:
            j+=1
        else:
            i+=1
print(ctr)
