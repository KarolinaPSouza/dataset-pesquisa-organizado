import sys
sys.setrecursionlimit(10**7)
# def input(): return sys.stdin.readline()[:-1]

#################################################################
###### COMMENT FIRST THREE LINS FOR CODEFORCES AND ATCODER ######
#################################################################


mod = 10**9 + 7
# def readFloat():return float(input())
# def readFloatList():return list(map(float,input().split()))
def read_int():return int(input())
def read_int_list():return list(map(int,input().split()))
def read_string_list():return list(input())
def read_string_list_with_space():return list(input().split())
def read_string():return input()
def read_graph():
    n,m = read_int_list()
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        u,v = read_int_list()
        graph[u].append(v)
        graph[v].append(u)
    return graph


def execute():
    n = read_int()
    a = read_int_list()
    a.sort()
    c = 1
    for i in range(1,len(a)):
        if a[i] != a[i-1]:
            c += 1
    print(c)


if __name__ == "__main__":
    execute()