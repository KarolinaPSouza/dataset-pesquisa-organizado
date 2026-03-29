# reader = iter(open('test_book_shop.txt').read().split('\n'))
# input = lambda: next(reader)  

inp = input().split()
# print(inp)
n = int(inp[0])
x = int(inp[1])

prices = list(map(int,input().split()))
pages = list(map(int,input().split()))

sol = [0 for _ in range(x+1)]

for i in range(n):
    h = prices[i]
    s = pages[i]
    for j in range(x,h-1,-1):
        sol[j] = max( s+ sol[j-h],sol[j])


print(sol[x])