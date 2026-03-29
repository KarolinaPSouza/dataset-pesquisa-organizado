import bisect

def max_compensation(events):
    """
    Calculates the maximum compensation achievable by attending non-overlapping events.
    Uses binary search to find the next non-overlapping event.
     Args:
        events: A list of tuples, where each tuple represents an event (start_day, end_day, compensation).
     Returns:
        The maximum total compensation.
    """

    events.sort(key=lambda x: x[1])  # Sort events by end day
    n = len(events)
    dp = [0] * (n + 1)  # dp[i] stores the max compensation considering events up to i-1
    end_days = [event[1] for event in events]

    for i in range(1, n + 1):
        start_day, end_day, compensation = events[i - 1]

        # Find the latest non-overlapping event using binary search
        j = bisect.bisect_left(end_days, start_day)

        # Choose between attending the current event or not
        dp[i] = max(dp[i - 1], dp[j] + compensation)

    return dp[n]

# Example usage (same as before)
if __name__ == "__main__":
    n = int(input())
    events = []
    for _ in range(n):
        start_day, end_day, compensation = map(int, input().split())
        events.append((start_day, end_day, compensation))

    result = max_compensation(events)
    print(result)