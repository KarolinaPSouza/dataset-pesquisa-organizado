import sys
input = sys.stdin.readline

def inp():
    return(int(input()))

def inlt():
    return(list(map(int,input().split())))

def insr():
    s = input()
    return(list(s[:len(s) - 1]))

def invr():
    return(map(int,input().split()))

def debug(*args, **kwargs):
    import inspect
    frame = inspect.currentframe().f_back
    output = []
    arg_exprs = None

    try:
        # Attempt to extract expressions from the source code line
        lineno = frame.f_lineno
        filename = frame.f_code.co_filename
        with open(filename, 'r') as f:
            lines = f.readlines()
        line = lines[lineno - 1].strip()

        start = line.find('debug(')
        if start == -1:
            raise ValueError("Debug call not found")
        start += len('debug(')
        end = line.rfind(')', start)
        if end == -1:
            raise ValueError("No closing parenthesis found")

        args_str = line[start:end]
        arg_exprs = [a.strip() for a in args_str.split(',')]

        if len(arg_exprs) != len(args):
            raise ValueError("Argument count mismatch")

        # Successfully parsed expressions
        for expr, arg in zip(arg_exprs, args):
            output.append(f"{expr}={repr(arg)}")
    except:
        # Fallback to original method for args
        vars_names = frame.f_locals
        for arg in args:
            name = None
            for k, v in vars_names.items():
                if v is arg:
                    name = k
                    break
            if name:
                output.append(f"{name}={repr(arg)}")
            else:
                output.append(repr(arg))

    # Process keyword arguments
    for k, v in kwargs.items():
        output.append(f"{k}={repr(v)}")

    print("DEBUG:", ", ".join(output), file=sys.stderr)



from collections import deque

def parcours(i,j,t,n,m,check):

    q=deque()
    q.append((i,j))
    check[i][j]=True

    while q:
        x,y = q.popleft()
        for a1, a2 in [(-1,0), (1,0), (0,-1), (0,1)]:
            x1,y1=x+a1,y+a2

            if 0<=x1<n and 0<=y1<m and not(check[x1][y1]) and t[x1][y1]!='#':
                q.append((x1,y1))
                check[x1][y1]=True



def solve(t, n, m, check):
    res=0
    for i in range(n):
        for j in range(m):
            # print(i,j)
            if t[i][j]=='.':
                if not(check[i][j]) :
                    res+=1
                    parcours(i,j,t,n,m,check)

    print(res)

n, m =inlt()
t=[]
for _ in range(n):
    t.append(insr())


check= [[False for j in range(m)] for i in range(n)]

solve(t, n, m, check)
# print(t)