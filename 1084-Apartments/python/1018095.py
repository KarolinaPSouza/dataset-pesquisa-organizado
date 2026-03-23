def howmany(n,m,k,arr,apartments):
    arr.sort()
    apartments.sort()
    ans=0
    pos=0
    for i in arr:
        while pos<len(apartments) and apartments[pos]<i-k:
            pos+=1
        if pos>=len(apartments):
            break
        if i-k<=apartments[pos]:
            if apartments[pos]<=i+k:
                ans+=1
                pos+=1
            else:
                continue


    return ans




if __name__ == "__main__":
    n,m,k=map(int,input().split())
    arr=list(map(int,input().split()))
    apartments=list(map(int,input().split()))
    print(howmany(n,m,k,arr,apartments))
    pass