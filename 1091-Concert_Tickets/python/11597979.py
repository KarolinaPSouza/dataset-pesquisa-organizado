def impl1(prices,line):
    prices = prices[:]
    lis = []
    for L in line:
        for i in range(len(prices)):
            if prices[-1] <= L or (i > 0 and prices[i-1] <= L and prices[i] > L):
                lis.append(prices[i-1])
                del prices[i-1]
                break
        else:
            lis.append(-1)
    return lis
def impl2(prices,line):
    global ID
    prices = prices[:]
    lis = []
    N = len(prices)
    segtree = [[None,None,None,None] for i in range(2*N)] # [parent, left, right, minimum]
    # [nodeindex, leftindex, rightindex, parentindex, i, j, minimum] - node
    # [nodeindex, None,      None,       parentindex, i, i, value] - end node
    currdirection = 1
    currindex = 0
    i = 0
    j = N-1
    if i != j:
        stack = [[currindex, currindex+1, None, -1, i, j, 0, float('inf')]]
        while stack:
            nodeindex, left, right, parent, i, j, state, mini = stack[-1]
            if currdirection and i == j:
                currdirection = 0
            elif currdirection:
                mid = i + (j-i)//2
                if right:
                    stack.append([right, right+1 if j-mid-1 else None, None, nodeindex, mid+1, j, 0, prices[j] if not j-mid-1 else float('inf')])
                else:
                    stack.append([left, left+1 if mid-i else None, None, nodeindex, i, mid, 0, prices[i] if not mid-i else float('inf')])
            else:
                segtree[nodeindex] = [parent, left, segtree[nodeindex][2], mini]
                stack.pop()
                if stack:
                    stack[-1][-1] = min(stack[-1][-1], mini)
                    stack[-1][-2] += 1  
                    stack[-1][2] = (right if state else nodeindex)+(not state)
                    if stack[-1][-2] == 1:
                        segtree[stack[-1][0]][2] = stack[-1][2]
                    currdirection = bool(stack[-1][-2] < 2)
    else:
        segtree = [[-1, None, None, prices[i]]]
    lis = []
    #print(f"impl2 segtree: {[i[-1] for i in segtree]}\n")
    for L in line:
        stack = []
        if L >= segtree[0][-1]:
            stack.append(0)
            while segtree[stack[-1]][1] != segtree[stack[-1]][2]:
                parent, left, right, mini = segtree[stack[-1]]
                if L >= segtree[right][-1]:
                    stack.append(right)
                elif L >= segtree[left][-1]:
                    stack.append(left)
                else:
                    lis.append(-1)
                    break
            else:
                lis.append(segtree[stack[-1]][-1])
                segtree[stack[-1]][-1] = float('inf')
                stack.pop()
                while len(stack) > 1:
                    parent = stack.pop()
                    left, right, mini = segtree[parent][1:]
                    segtree[parent][-1] = min(segtree[right][-1], segtree[left][-1])
                    if mini == segtree[parent][-1]:
                        break
        else:
            lis.append(-1)
        #print(f"impl2 segtree: {[i[-1] for i in segtree]}\n")
    return lis
def build(arr, v, tree, l, r):
    if l == r:
        tree[v] = arr[l]
    else:
        mid = (r+l)//2
        build(arr, 2*v, tree, l, mid)
        build(arr, 2*v+1, tree, mid+1, r)
        tree[v] = min(tree[2*v],tree[2*v+1])
def impl3(prices, line):
    N = len(prices)
    segtree = [None for i in range(4*N)]
    build(prices, 1, segtree, 0, N-1)
    lis = []
    for l in line:
        curr = 1
        not_found = False
        while curr < 2*N:
            if l < segtree[curr]:
                print(-1)
                not_found = True
                break
            elif not (segtree[2*curr] and segtree[2*curr + 1]):
                break
            elif l >= segtree[2*curr + 1]:
                curr = 2*curr + 1
            elif l >= segtree[2*curr]:
                curr = 2*curr
            else:
                print(-1)
                not_found = True
                break
        if not_found:
            continue
        print(segtree[curr])
        segtree[curr] = float('inf')
        while curr > 0:
            curr //= 2
            if curr == 0:
                break
            segtree[curr] = min(segtree[2*curr], segtree[2*curr+1])
""" for test in range(1000):
    N = randint(1,100)
    M = randint(1,100)
    prices = sorted(randint(1,15) for i in range(N))
    line = [randint(min(prices)-1,max(prices)) for i in range(M)]
    try:
        A = impl2(prices,line)
        B = impl3(prices,line)
        assert A == B
    except AssertionError:
        print(prices)
        print(line)
        print(A)
        print(B)
        raise """
N,M = list(map(int,input().split()))
prices = sorted(list(map(int,input().split())))
line = list(map(int,input().split()))
impl3(prices,line)