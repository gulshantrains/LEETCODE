class Solution {
    public boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0; //agr LSB p 0 NHI hai to SET hai 
    }

    public int Set(int x, int bit) {
        return x | (1 << bit); //Left shift till required bit and then ans with x
    }

    public int unSet(int x, int bit) {
        return x & ~(1 << bit); //left shift till required and then take AND with negation
    }

    public int minimizeXor(int num1, int num2) {
        int x = num1;  //phle se he ans=num1 le lete hai soo agr 0 aa gaya to maze maze

        int reqdbitCount = Integer.bitCount(num2); //Required Set Bit
        int orgbitCount = Integer.bitCount(x); //Hmre number me kitna set bit hai

        int bit = 0; //bit is at 0 means LSB

        if (reqdbitCount > orgbitCount) { //agr required set bit BIG hai original se then we must Set some bit (ADD 1 in number)
            while (reqdbitCount > orgbitCount) { //jb tak equal n ho jye
                if (!isSet(x, bit)) { //kya LSB 0 hai agr hai to usse 1 me convert kre g || agr 1 hai already to move
                    x = Set(x, bit);  //set kro bhai jldi
                    orgbitCount++; //set bit count increase kre g 
                }
                bit++; //1 hai LSB p soo move to next bit to check
            }
        } else if (reqdbitCount < orgbitCount) { //agr small hai to unset kre g means REMOVE 1
            while (reqdbitCount < orgbitCount) {
                if (isSet(x, bit)) { //Kya LSB p 1 hai..agr hai to unset kre g wrna next search kro 
                    x = unSet(x, bit);
                    orgbitCount--;
                }
                bit++; //already 0  hai so move to next bit to find 1
            }
        }
        return x; 
    }
}