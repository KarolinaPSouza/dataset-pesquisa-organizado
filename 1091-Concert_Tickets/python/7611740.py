class TreeNode:
    def __init__(self,val = 0, left = None, right = None, parent = None):
        self.val = val
        self.left = left
        self.right = right
        self.parent = parent

    def __str__(self):
        return '('+str(self.val)+','+(str(self.parent.val) if self.parent else "None")+')'

class bst:
    def __init__(self,arr):
        def create(arr,p):
            if not arr: return
            mid = len(arr)//2
            r = TreeNode(arr[mid],parent=p)
            r.left = create(arr[:mid],r)
            r.right = create(arr[mid+1:],r)
            return r
        self.root = create(arr,None)

    def __str__(self):
        ans = []
        def trav(root):
            if not root: return
            ans.append(str(root.val)+" --> "+str(root.left)+' , '+str(root.right))
            trav(root.left)
            trav(root.right)
        trav(self.root)
        return '\n'.join(ans)

    def search(self,val):
        def trav(root):
            if not root: return
            if root.val == val: return root
            if val > root.val: return trav(root.right)
            else: return trav(root.left)
        return trav(self.root)

    def searchLeft(self,val):
        def trav(root):
            if not root: return
            if root.val <= val:   # <=
                t = trav(root.right)
                if t: return max(t,root,key = lambda x : x.val)
                else: return root
            else: return trav(root.left)
        return trav(self.root)

    def searchRight(self,val):
        def trav(root):
            if not root: return
            if root.val >= val:   # >=
                t = trav(root.left)
                if t: return min(t,root,key = lambda x : x.val)
                else: return root
            else: return trav(root.right)
        return trav(self.root)

    def pop(self,node):
        if node.left == None and node.right == None:
            p = node.parent
            if p:
                if node.val > p.val: p.right = None
                else: p.left = None
            else: self.root = None

        elif node.left == None and node.right:
            p = node.parent
            if p:
                if node.val > p.val: p.right = node.right
                else: p.left = node.right
                node.right.parent = p
            else:
                self.root = node.right
                self.root.parent = None
        elif node.left and node.right == None:
            p = node.parent
            if p:
                if node.val > p.val: p.right = node.left
                else: p.left = node.left
                node.left.parent = p
            else:
                self.root = node.left
                self.root.parent = None
        else:
            t = node.right
            if not t.left:
                p = node.parent
                if p:
                    if node.val > p.val: p.right = t
                    else: p.left = t
                    t.parent = p
                    t.left = node.left
                    node.left.parent = t
                else:
                    self.root = t
                    self.root.left = node.left
                    node.left.parent = self.root
                    self.root.parent = None
            else:
                while t.left: t = t.left
                node.val = t.val
                p = t.parent
                p.left = t.right
                if t.right: t.right.parent = p


import sys
def input()   : return sys.stdin.readline().strip()
def getints() : return map(int,sys.stdin.readline().strip().split())

n,m = getints()
a = list(getints())
b = list(getints())

def main1(a,b):
    ans = []
    d = {}
    for x in a:
        if x in d: d[x] += 1
        else: d[x] = 1
    a = bst(sorted(d.keys()))

    for x in b:
        t = a.searchLeft(x)
        if t:
            ans.append(t.val)
            if d[t.val] > 1: d[t.val] -= 1
            else: a.pop(t)
        else: ans.append(-1)

    return ans

ans = main1(a,b)
print("\n".join(map(str,ans)))