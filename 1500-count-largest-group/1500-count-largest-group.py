class Solution:
    def countLargestGroup(self, n: int) -> int:
        hashMap=collections.Counter()

        for i in range(1,n+1):
            key=sum(int(x) for x in str(i)) #We made key {sum of digit as key}
            hashMap[key] +=1        #Put values for Key {count of each digit sum}

        maxval=max(x for x in hashMap.values()) #Find Highest repeating num
        count=sum(1 for v in hashMap.values() if v==maxval) #Count freq of highest digit si,

        return count
        
        