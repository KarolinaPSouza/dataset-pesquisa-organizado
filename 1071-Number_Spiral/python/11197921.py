def main():
    for _ in range(int(input())):
        solve()





def solve():
    r, c = map(int,input().split())
    v = max(r,c)
    if v%2 == 0:
        if r>c:
            print((r*r)-c+1)
        else:
            print(((c-1)*(c-1))+r)
    else:
        if r>c:
            print(((r-1)*(r-1))+c)
        else:
            print((c*c)-r+1)



main()