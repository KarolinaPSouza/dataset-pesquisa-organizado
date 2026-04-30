from bisect import bisect_right, insort, bisect_left
from sys import stdin
 
CHUNK_SIZE = 1024
MIN_CHUNK_SIZE, MAX_CHUNK_SIZE = CHUNK_SIZE // 2, CHUNK_SIZE * 2
 
 
class SortedList:
 
    def __init__(self, iterable):
        values = sorted(iterable)
        self.chunks = [values[i: i + CHUNK_SIZE] for i in range(0, len(values), CHUNK_SIZE)]
        self.maxes = [chunk[-1] for chunk in self.chunks]
 
    # def __getitem__(self, key):
    #     index, offset = key
    #     return self.chunks[index][offset]
    #
    # def bisect_left(self, value):
    #     maxes = self.maxes
    #
    #     index = bisect_left(maxes, value)
    #     if index == len(maxes):
    #         index -= 1
    #     return index, bisect_left(self.chunks[index], value)
    #
    # def add(self, value):
    #     chunks, maxes = self.chunks, self.maxes
    #
    #     if len(maxes) == 0:
    #         self.chunks.append([value])
    #         self.maxes.append(value)
    #         return
    #     index = bisect_right(maxes, value)
    #     if index == len(maxes):
    #         index -= 1
    #         chunk = chunks[index]
    #         chunk.append(value)
    #         maxes[index] = value
    #     else:
    #         chunk = chunks[index]
    #         insort(chunk, value)
    #
    #     # split
    #     if len(chunk) > MAX_CHUNK_SIZE:
    #         chunks.insert(index + 1, chunk[CHUNK_SIZE:])
    #         maxes.insert(index, chunk[CHUNK_SIZE])
    #         del chunk[CHUNK_SIZE:]
    #
    # def remove(self, value):
    #     key = self.bisect_left(value)
    #     if self[key] != value:
    #         raise ValueError
    #     del self[key]
    #
    # def __delitem__(self, key):
    #     chunks = self.chunks
    #     index, offset = key
    #
    #     chunk = chunks[index]
    #     if len(chunk) == 1:
    #         del chunks[index]
    #         del self.maxes[index]
    #         return
    #     else:
    #         del chunk[offset]
    #         self.maxes[index] = chunk[-1]
    #         self._merge(index)
    #
    # def _merge(self, index):
    #     maxes, chunks = self.maxes, self.chunks
    #     chunk = chunks[index]
    #
    #     if len(maxes) > 1 and len(chunk) < MIN_CHUNK_SIZE:
    #         if index != 0 and (index == len(maxes) - 1 or len(chunks[index - 1]) <= len(chunks[index + 1])):
    #             index -= 1
    #             left_chunk, right_chunk = chunks[index], chunk
    #         else:
    #             left_chunk, right_chunk = chunk, chunks[index + 1]
    #         left_chunk.extend(right_chunk)
    #         del chunks[index + 1]
    #         del maxes[index]
    #
    # def bisect_right(self, value):
    #     maxes = self.maxes
    #
    #     index = bisect_left(maxes, value)
    #     if index == len(maxes):
    #         index -= 1
    #     return index, bisect_right(self.chunks[index], value)
    #
    # def remove_largest_leq(self, value):
    #     chunks, maxes = self.chunks, self.maxes
    #
    #     index = bisect_left(maxes, value)
    #     if index == len(maxes):
    #         index -= 1
    #     chunk = chunks[index]
    #     offset = bisect_right(chunk, value)
    #
    #     if offset == 0:
    #         if index == 0:
    #             raise ValueError
    #         index -= 1
    #         chunk = chunks[index]
    #         offset = len(chunk) - 1
    #     else:
    #         offset -= 1
    #
    #     del chunk[offset]
    #     try:
    #         maxes[index] = chunk[-1]
    #     except IndexError:
    #         del chunks[index]
    #         del maxes[index]
    #     else:
    #         if len(maxes) > 1 and len(chunk) < MIN_CHUNK_SIZE:
    #             if index != 0 and (index == len(maxes) - 1 or len(chunks[index - 1]) <= len(chunks[index + 1])):
    #                 index -= 1
    #                 left_chunk, right_chunk = chunks[index], chunk
    #             else:
    #                 left_chunk, right_chunk = chunk, chunks[index + 1]
    #             left_chunk.extend(right_chunk)
    #             del chunks[index + 1]
    #             del maxes[index]
 
 
def main():
    n, k, *data = map(int, stdin.read().split())
 
    movies = list(zip(data[1::2], data[::2]))
    movies.sort()
    movies = iter(movies)
 
    res = 0
    free_time = SortedList([0] * k)
    chunks, maxes = free_time.chunks, free_time.maxes
    for end, begin in movies:
        index = bisect_left(maxes, begin)
        if index == len(maxes):
            index -= 1
        chunk = chunks[index]
        offset = bisect_right(chunk, begin)
 
        if offset == 0:
            if index == 0:
                continue
            index -= 1
            chunk = chunks[index]
            offset = len(chunk) - 1
        else:
            offset -= 1
 
        del chunk[offset]
        try:
            maxes[index] = chunk[-1]
        except IndexError:
            del chunks[index]
            del maxes[index]
        else:
            if len(maxes) > 1 and len(chunk) < MIN_CHUNK_SIZE:
                if index != 0 and (index == len(maxes) - 1 or len(chunks[index - 1]) <= len(chunks[index + 1])):
                    index -= 1
                    left_chunk, right_chunk = chunks[index], chunk
                else:
                    left_chunk, right_chunk = chunk, chunks[index + 1]
                left_chunk.extend(right_chunk)
                del chunks[index + 1]
                del maxes[index]
 
        if len(maxes) == 0:
            chunks.append([end])
            maxes.append(end)
        else:
            index = bisect_right(maxes, end)
            if index == len(maxes):
                index -= 1
                chunk = chunks[index]
                chunk.append(end)
                maxes[index] = end
            else:
                chunk = chunks[index]
                insort(chunk, end)
 
            # split
            if len(chunk) > MAX_CHUNK_SIZE:
                chunks.insert(index + 1, chunk[CHUNK_SIZE:])
                maxes.insert(index, chunk[CHUNK_SIZE])
                del chunk[CHUNK_SIZE:]
        res += 1
 
    print(res)
 
 
main()