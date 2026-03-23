def res(t):
    r,c=t
    if c>r :
        if c%2==1:
            return c**2-r+1
        else:
            return (c-1)**2+r
    else:
        if r%2==0:
            return r**2-c+1
        else:
            return (r-1)**2+c
def main():
    n=int(input())
    l=[]

    for i in range(n):
        l.append(map(int,input().split()))

    for t in l:
        print(res(t))


if __name__=="__main__":
    main()