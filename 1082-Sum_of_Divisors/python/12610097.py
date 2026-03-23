# Code by Gemini 2.5 Pro


MOD = 10**9 + 7

def compute_sum(n):
    total_sum = 0
    d = 1

    while d <= n:
        val = n // d
        d_max = n // val

        first = d
        last = d_max

        count_ll = last - first + 1
        sum_ends_ll = first + last

        term1_mod = count_ll % MOD
        term2_mod = sum_ends_ll % MOD

        # Perform division before multiplication to avoid overflow
        if count_ll % 2 == 0:
            # count_ll is even
            half = count_ll // 2
            block_sum_d = (half % MOD) * term2_mod % MOD
        else:
            # sum_ends_ll must be even
            half = sum_ends_ll // 2
            block_sum_d = term1_mod * (half % MOD) % MOD

        block_val = val % MOD
        block_contribution = (block_val * block_sum_d) % MOD

        total_sum = (total_sum + block_contribution) % MOD

        if d_max == n:
            break

        d = d_max + 1

    if total_sum < 0:
        total_sum += MOD

    return total_sum

# Example usage
if __name__ == "__main__":
    n = int(input())
    print(compute_sum(n))