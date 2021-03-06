public class RomanNumeral {

    private int value = 0;
    private static String[] letters = {"I", "V", "X", "L", "C", "D", "M"};
    private String answer = "";

    public RomanNumeral(int integerValue){
        if (integerValue < 1 || integerValue > 3999) {

            System.out.println("Error: only numbers 1 - 3999 allowed.");
        } else {
            value = integerValue;
        }
    }
    public String toString(){
        if (value == 0) {
            return "Value not initialized.";
        }
        int num = value;

        /*
        I generalized the process of building the appropriate string for the ones, tens, and
        hundreds places to avoid using repetitive switch statements. This could easily be scaled
        up to include higher levels of Roman Numerals by including them in letters[], adjusting the
        starting i value in the for loop below, and removing the 1-3999 constraint in the constructor.
         */

        for (int i = 3; i >= 0; i--) {
            int digit = num % (int)Math.pow(10, i + 1) / (int)Math.pow(10, i);
            switch (digit) {
                case 1:
                case 2:
                case 3:
                    for (int j = 1; j <= digit % 5; j++) {
                        answer += letters[2 * i];
                    }
                    break;
                case 4:
                    answer += letters[2 * i] + letters[2 * i + 1];
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    answer += letters[2 * i + 1];
                    for (int j = 1; j <= digit % 5; j++) {
                        answer += letters[2 * i];
                    }
                    break;
                case 9:
                    answer += letters[2 * i] + letters[2 * i + 2];
                    break;
            }
        }
        return answer;
    }
    public int toInt() {
        return value;
    }
    public int compareTo(RomanNumeral r) { 
      /*
       * Added functionality to compare two Roman Numeral objects
       * -1 if this > r (input)
       *  0 if this = r
       *  1 if this < r
       * Can be thought of as taking the sign of (this - r)
       */
      
        if (this.value < r.value) {
            return -1;
        }
        if (this.value == r.value) {
            return 0;
        }
        if (this.value > r.value) {
            return 1;
        }
        return 2;
    }
    public static void main(String[] args) {
        for (int m = 1; m <= 10; m++) {
            RomanNumeral r0 = new RomanNumeral(m);
            System.out.println(r0);
        }
        RomanNumeral r1 = new RomanNumeral(66);
        RomanNumeral r2 = new RomanNumeral(199);
        RomanNumeral r3 = new RomanNumeral(3298);
        System.out.println("\n" + r1.compareTo(r2));
        System.out.println(r3.compareTo(r1));
        System.out.println(r2.compareTo(r2));
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r1.toInt());
        System.out.println(r2.toInt());
        System.out.println(r3.toInt());

    }
}
