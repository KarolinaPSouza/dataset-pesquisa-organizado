def func(vals):
    return len(set(vals))

############ ---- Input Functions ---- ############
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))
def inlt_plain():
    return input().split()

if __name__ == '__main__':
    _ = inp()
    vals = inlt_plain()
    print(func(vals))