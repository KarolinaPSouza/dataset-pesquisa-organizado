def sortfirst(x):
    return x[0]
def main():
    n = int(input())
    vals =[]
    for i in range(n):
        l,r = map(int, input().split())
        vals.append((l,1))
        vals.append((r,-1))
    vals.sort(key=sortfirst)
    ans = 0
    m = 0
    for i in vals:
        m+=i[1]
        if m>ans:
            ans=m
    print(ans)
main()