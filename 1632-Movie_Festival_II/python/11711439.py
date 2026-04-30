def main():
    n, k, *r = map(int, open(0).read().split())
 
    indices = [i for i in range(n)]
    indices.sort(key=lambda i: r[2*i+1])
    
    val2idx = {v:i+1 for i, v in enumerate(sorted(set(r)))}
 
    ans = 0
    tree_sz = len(val2idx) + 1
    tree = [0] * tree_sz
 
    def tree_add(i, val):
        while i < tree_sz:
            tree[i] += val
            i += -i & i
        
    def tree_sum(i):
        res = 0
        while i > 0:
            res += tree[i]
            i -= -i & i
        return res
    
    def lower_bound(v):
        p = 1 << tree_sz.bit_length()
        #print(p, tree_sz)
        out = 0
        while p > 0:
            cur = out + p
            if cur < tree_sz and tree[cur] < v:
                v -= tree[cur]
                out = cur
            p >>= 1
            #print(p, "v", v)
 
    
        return out+1 #if v == 0 else -1
    
    total_set = 0
    for i in indices:
        start = r[2*i]
        end = r[2*i+1]
 
        #print(f"({start}, {end}), start={val2idx[start]}, end={val2idx[end]}")
        fw_start_idx = val2idx[start]
        fw_end_idx = val2idx[end]
        
        lower_set_sz = tree_sum(fw_start_idx)
 
        
        if  1 <= lower_set_sz <= k:
            res = lower_bound(lower_set_sz)
            #print("res", res, fw_start_idx)
            if res != -1:
                tree_add(res, -1)
                tree_add(fw_end_idx, 1)
                ans += 1
        elif total_set < k:
            fw_end_idx = val2idx[end]
            tree_add(fw_end_idx, 1)
            total_set += 1
            ans += 1
        #print(tree)
    print(ans)
 
 
main()