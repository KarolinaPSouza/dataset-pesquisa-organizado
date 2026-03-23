from bisect import bisect_right
def solve():
    n,m = map(int,input().split())
    price = list(map(int,input().split()))
    customer = list(map(int,input().split()))

    price.sort()
    price=[-1]+price+[10**9 + 1]

    next_element = [i-1 for i in range(len(price))]
    parent = [i for i in range(len(price))]


    # print(*price,sep="\t")
    # print(*mapping, sep="\t")
    for c in customer:
        # print("Customer: ",c)
        pos = bisect_right(price, c, 0, len(price))
        # print(pos)
        temp = pos
        while parent[pos]!=pos:
            pos = parent[pos]
        while temp!=pos :
            new_temp = parent[temp]
            parent[temp] = pos 
            temp = new_temp


        if next_element[pos]==0:
            print(-1)
        else:
            print( price[next_element[pos]] )
            parent[next_element[pos]] = pos
            next_element[pos]= next_element[next_element[pos]]
        # print(*price,sep="\t")
        # print(*mapping, sep="\t")








if __name__ == "__main__":
    solve()