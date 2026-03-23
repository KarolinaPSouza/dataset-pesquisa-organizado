def solve():
    n,m,k = map(int,input().split())
    lst1 = list(map(int,input().split()))
    lst2 = list(map(int,input().split()))
    lst1.sort()
    lst2.sort()
    count = 0
    i,j = 0, 0
    while i<len(lst1) and j<len(lst2):
        if abs(lst2[j]-lst1[i])<=k:
            count+=1
            j+=1
            i+=1
        else:
            if lst2[j]-lst1[i]>k:
                i+=1
            else:
                j+=1

    print(count)




if __name__ == '__main__':
    solve()