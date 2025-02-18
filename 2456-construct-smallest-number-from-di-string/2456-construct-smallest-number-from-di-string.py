class Solution:
    def smallestNumber(self, pattern: str) -> str:
        for perm in permutations(map(str, range(1, len(pattern) + 2))):
            if all((p == 'I') == (a < b) for p, a, b in zip(pattern, perm, perm[1:])):
                return ''.join(perm)
        return ""