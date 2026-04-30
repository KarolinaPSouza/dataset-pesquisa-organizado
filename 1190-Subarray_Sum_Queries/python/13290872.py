import sys
import threading
 
def main():
    data = sys.stdin.buffer.read().split()
    data_iter = iter(data)
    num_elements = int(next(data_iter))
    num_queries = int(next(data_iter))
    values = [int(next(data_iter)) for _ in range(num_elements)]
    
    segment_size = 1
    while segment_size < num_elements:
        segment_size <<= 1
 
    total_sum = [0] * (2 * segment_size)
    prefix_max = [0] * (2 * segment_size)
    suffix_max = [0] * (2 * segment_size)
    best_sum = [0] * (2 * segment_size)
 
    for i, val in enumerate(values):
        idx = segment_size + i
        total_sum[idx] = val
        prefix_max[idx] = val if val > 0 else 0
        suffix_max[idx] = val if val > 0 else 0
        best_sum[idx] = val if val > 0 else 0
 
    for idx in range(segment_size - 1, 0, -1):
        left_child = idx << 1
        right_child = left_child | 1
        total = total_sum[left_child] + total_sum[right_child]
        prefix = max(prefix_max[left_child], total_sum[left_child] + prefix_max[right_child])
        suffix = max(suffix_max[right_child], total_sum[right_child] + suffix_max[left_child])
        best = max(best_sum[left_child], best_sum[right_child], suffix_max[left_child] + prefix_max[right_child])
        total_sum[idx], prefix_max[idx], suffix_max[idx], best_sum[idx] = total, prefix, suffix, best
 
    output = []
    for _ in range(num_queries):
        position = int(next(data_iter)) - 1
        new_value = int(next(data_iter))
        idx = segment_size + position
        total_sum[idx] = new_value
        prefix_max[idx] = new_value if new_value > 0 else 0
        suffix_max[idx] = new_value if new_value > 0 else 0
        best_sum[idx] = new_value if new_value > 0 else 0
        idx >>= 1
        while idx:
            left_child = idx << 1
            right_child = left_child | 1
            total = total_sum[left_child] + total_sum[right_child]
            prefix = max(prefix_max[left_child], total_sum[left_child] + prefix_max[right_child])
            suffix = max(suffix_max[right_child], total_sum[right_child] + suffix_max[left_child])
            best = max(best_sum[left_child], best_sum[right_child], suffix_max[left_child] + prefix_max[right_child])
            total_sum[idx], prefix_max[idx], suffix_max[idx], best_sum[idx] = total, prefix, suffix, best
            idx >>= 1
        output.append(str(best_sum[1]))
 
    sys.stdout.write("\n".join(output))
 
threading.Thread(target=main).start()