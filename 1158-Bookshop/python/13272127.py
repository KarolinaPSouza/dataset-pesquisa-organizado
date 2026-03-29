def solve():
  #  pageMatrix = [[0 for i in range(x+1)] for j in range(n+1)]
   # prev = [0 for i in range(x+1)]
    #cur = [0 for i in range(x+1)]
    vals = [0 for i in range(x+1)]
    for j in range(n): # remeber to place of j + 1
        cost = price[j]
        numPage = pages[j]
        for i in range(x, 0, -1):
          #  if i == 0:
              #  continue 
            if i >= cost:
                costLeft = i - cost
                #v[i][0] = vals[i][1]
                vals[i] = max(vals[i], vals[costLeft] + numPage)
                #prev[i] = cur[i]
        #prev = cur.copy()
    print(vals[-1])








n, x = map(int, input().split())
price = list(map(int, input().split()))
pages = list(map(int, input().split()))
solve()
#print("done")












"""
 def solve():
    mostPage = [[0 for i in range(x+1)] for j in range(n+1)]
    for i in range(1, n+1): # for price of in range books (we need padding so we do i-1)
        cost = price[i-1]
        numPages = pages[i-1]
                for j in range(1, x+1): # for each a value up to our price limit
           # mostPage[i][j] = mostPage[i-1][j]
            costLeft = cost - j
            if costLeft >= 0:
                #costLeft = cost - j
                print(f"when our limit is {j} ans we have the option to add {cost}, we can and have {costLeft} left")
                mostPage[i][j] = max(mostPage[i-1][j] , numPages + mostPage[i-1][costLeft])
                        return mostPage
   """