# RANK1ZEN; 3966 PEAK NA FLEX SUPPORT; Battlenet ID -> Knuckles#11791
# region -----------------------------------------------------------------------------------------|
# MNNNNNNNNNNNNNNNNMNho///++//+oooooossssssssssssysssooyyyyyso+//++//shNNNNNNNNNNNNNM
# MNNNNNNNNNNNNNNMNy////////++++oooooooooossssssssoosssssysyyysoossss+/oshNNNNNNNNNNM
# MNNNNNNNNNNNNMNs///////+oooooo++++oooooooooooso+ossssssssssssssssssss++soymMNNNNNNM
# MNNNNNNNNNNNMd/:-//+//shNNmhsoo+++++++++ooooo++oooooooooossssssssssssso+ooosmNNNNNM
# MNNNNNNNNNNMh::://+/+ymMMMMmhsoso+++++++++o+/+ooooooooooooooooooooossso++o+++hMNNNM
# MNNNNNNNNNMy//-:/+/osmMMMMNhssyshNdssoooo++:++++++++++oooooooooooooooooo++-++/sMMNM
# MNNNNNNNNMd:/:///+/ohNMMMNhsohyyNMNNNdhhs+:++++++++++++++++++++ooooooooo/+.o+:/+NNM
# MNNNNNNNMm/:/-///++ooshmmhs+sysdMMMMNdMMd/+++++ooo++++++++++++++++++++++::-++/:/sNM
# MNNNNNNMN/://-+++++++++oo+//yosNMNMNmNMNo/o/oshNmhyoo+++++++++++++++++++/-/+++:/:sM
# MNNNNNMNo://-/+++++:/+++++//++osyhmdhMNs/o/+shMMMMmsooooyo++/+++++++++++://+++://oM
# MNNNNNMs:///:/++++//++-/+/:++++++ooooyo++o-oyNNMMmysooymmso/+shysyyysooo+/++o+/-s+M
# MNNNNMd:///+:/++++-++:`++:/++++//++++++:+-/oyhsmys+oohmyo++:sNMdmMMNNysy+-ohNs+-myM
# MNNNMN::///+-:+++:.+/``++/++++++++++++:+/`+++oo/:/++oyo+oy+odNddMMMMmyyh:-sdMh/odyN
# MNNNNo:///++-:+o/`::```++/+++++++++++//+-.o++:-:/++/+/+ymo/+ossyyhdhssy+.:ohhd/sy+M
# MMNMh-///+++--oo:`/````++-+++++++++++-o/`/+:.:/+++//+hmNo/++++++ooooooo-`/+o++/++-M
# MMMN/:///+++-.o/````-s:+/:++++++++++/++`.:.-/++++/+sdmmo/+++++++++++++: -+++++////M
# MMMh:///++++-`+:```/dN+/::++++++++++++:``.+ooo++ohNMNm++oooooooo+++++o+ :++++/-//oM
# MMd:/-/+++++-`/.``:hmm//./+++++++++o/o..:osoooymmdddmoooooooooooooo+oms.+++++////+M
# MMo// -+++++:`.`` dNddo-.:+++++++++++--/soo:.--::ymh+ssssssssssooo+sNN/++++++++/-dM
# Md/// `/+++o/```` dMddN.-:++++++++++/`/o/+:``-:-`/ooyssssssssssssoodmMo++++++++//NM
# M/:// `-+oooo.``` oMNMM+--/+++++++++/:yd-``.`-+o+hoyyoosyyyyyyys:+o+o++o//+++++/hMM
# m++:/```:oooo/````.dmNNm/-/+++++++//+dhy::ohs:/hysyosyyyyyyyyys:----:-/o/ooo++/-mMM
# s:++//```/oooo-  ``yNmdm:-/++++++////MMNmdhoys+ssssyyyyyysoysss:-.odd/o+/+oo++-+MMM
# s`:++/````:oooo. ```:hNNh-/++++++//:hNNNMMNMdsossyyyyyyss+osdM/o/:yNyoo///ooo/.MMNM
# d `-++/-```:+oo+-`````-+ds/++++++//-mMMMNNhs+syyysysyys+osdMMNyoshdh/+/o:ooo+.+MMNM
# M/` `-/+/-``.:ooo-```````s:++++++++/mNdhsoossssyyhyo/-+hmMMMMNNNNNNo//+.:oo++ oMMNM
# MMo``:..-//-.`-+oo:.`````/+++++++++:ooossyhyyyo+:-:ohNMmMMMMMNmNNNh:/:` :oo/: mMMNM
# MMMh.oMh+``.-:-.-/o+-````mh/+++++++:++++/:--:+syhmMMMMMNMMMMMMMMMo-.//``+oo:`-MMNNM
# MMMMh-omNd+````..`./+/.`hMMs+++++++/dmmmmNMMNNMMMMMMMMMMMMMMMMms:`` :/..+oo: yMNNNM
# MNNNMN/``..``````````.-.+dNy-oooooo/o+s++sNMMNmNMMmmNMMMMMMMmo-   ``-/.-oo+- yMNNNM
# MNNNNMMNdy-``````..``````-+o/+ooooo/++///:`:yMMMMMMMMMMMMds/`/++/````o--o++- MMNNNM
# MMNNMMMMMN:`........-:+oyssoo+ssssss:ooo+/+:`:mMMMMMNho/.````+ooohd+//:+ooo-/MMMMMM
# MMMMMMMMMMs.-...-.-osyyyyysdMhshhhhhossssssdh-.ss+/-.``----.sdhy+mMMMsosssy:sMMMMMM
# endregion --------------------------------------------------------------------------------------|
# region -----------------------------------------------------------------------------------------|
class Dsu:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [1] * n

    def find(self, x):
        while x != self.parent[x]:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
        return x

    def union(self, x, y):
        px, py = self.find(x), self.find(y)
        if px == py: return False
        if self.rank[py] > self.rank[px]:
            px, py = py, px
        self.parent[py] = px
        self.rank[px] += self.rank[py]
        return True

    def get_size(self, x):
        return self.rank[self.find(x)]

class Comba:
    def __init__(self, mod):
        self.fact = array.array("i", [0] * MX); self.fact[0] = 1
        self.fact_inv = array.array("i", [0] * MX)
        self.mod = mod

        for i in range(1, MX):
            self.fact[i] = (self.fact[i - 1] * i) % self.mod

        self.fact_inv[MX - 1] = pow(self.fact[MX - 1], self.mod - 2, self.mod)
        for i in range(MX - 2, -1, -1):
            self.fact_inv[i] = (self.fact_inv[i + 1] * (i + 1)) % self.mod

    def ncr(self, n, r):
        if r > n or n < 0 or r < 0: return 0
        return (self.fact[n] * self.fact_inv[r] % self.mod) * self.fact_inv[n - r] % self.mod

    def npr(self, n, r):
        if r > n or n < 0 or r < 0: return 0
        return self.fact[n] * self.fact_inv[n - r] % self.mod

def lcm(x, y): return (x * y) // gcd(x, y)

def rw_file():
    sys.stdin = open(r"", "r")
    sys.stdout = open(r"", "w")

def re(data=str): return data(sys.stdin.readline().rstrip())
def mp(data=str): return map(data, sys.stdin.readline().split())

import sys, array
from bisect import bisect_left, bisect_right, insort_left
from math import ceil, floor, log, sqrt, gcd
from collections import deque, defaultdict, Counter
from heapq import heappush, heappop, heapify

mod, mod9, nl, MX = 1000000007, 998244353, "\n", 200003
# endregion --------------------------------------------------------------------------------------|

def solve(tc):
    n, m = mp(int)
    G = [[] for i in range(n)]
    rG = [[] for i in range(n)]
    for i in range(m):
        u, v, c = mp(int)
        G[u - 1].append((v - 1, c))
        rG[v - 1].append((u - 1, c))

    dist = [1e18] * n; dist[0] = 0
    rdist = [1e18] * n; rdist[-1] = 0

    def dij(x, arr, g):
        pQ = [(0, x)]
        while pQ:
            wu, u = heappop(pQ)
            if arr[u] < wu: continue
            for v, wv in g[u]:
                if wu + wv < arr[v]:
                    arr[v] = wu + wv
                    heappush(pQ, (arr[v], v))
    dij(0, dist, G)
    dij(n - 1, rdist, rG)

    ans = 1e18
    for v in range(n):
        for e, c in G[v]:
            ans = min(ans, dist[v] + c//2 + rdist[e])
    print(ans)




    return None

def main():     
    # rw_file()
    tests = 1; # tests = re(int)
    for case in range(1, tests + 1): solve(case)
main()