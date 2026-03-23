n=int(input())
for i in range(n):
    r, c=list(map(int, input().split()))
    if r==c:
        print(r**2-(r-1))
    else:
        if r>c:
            if r%2==0:
                print(r**2-(r-1)+(r-c))
            else:
                print(r**2-(r-1)-(r-c))
        else:
            if c%2==0:
                print(c**2-(c-1)-(c-r))
            else:
                print(c**2-(c-1)+(c-r))