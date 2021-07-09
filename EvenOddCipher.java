
/***
 * Represents EvenOddCipher
 * @author Mitra Kian
 * @version 1
 * The following class performs the EvenOddCipher encryption and decryption
 */
public class EvenOddCipher extends BaseCipher{
    /***
     * Constructs an object of BaseCipher
     */
    public EvenOddCipher(){
        super("EvenOddCipher");
    }

    /***
     * @param message, secret message
     * @return the string with the EvenOddCipher applied
     */
    @Override
    public String encrypt(String message){
        return makeEvenString(message)+makeOddString(message);
    }

    /***
     *  @param message, takes in the secret message
     *  Separates the characters in the secret message with odd indices
     *  @return string of characters with odd indices
     */
    public String makeOddString(String message){
        String oddString="";
        for(int i=1; i < message.length(); i += 2){
            oddString += message.charAt(i);
        }
        return oddString;
    }
    /***
     *  @param message,  takes in the secret message
     *  Separates the characters in the secret message with even indices
     *  @return string of characters with even indices
     */
    public String makeEvenString(String message){
        String evenString = "";
        for(int i=0; i<message.length(); i+=2){
            evenString += message.charAt(i);
        }
        return evenString;
    }

    /***
     *  @param message, takes in message
     *  Checks if the message is even or odd in length
     *  @return true if the length is even
     */
    public boolean evenOrOdd (String message){
        return message.length()%2 == 0;
    }

    /***
     *  @param message,  the encrypted message
     *  Performs the decryption on a string of even length
     *  @return the decrypted string
     */
    public String evenDecryption(String message){
        String decryption = "";
        int midpoint = message.length()/2;
        for (int i = 0; i < midpoint; i++) {
            decryption += message.charAt(i);
            decryption += message.charAt(midpoint + i);
        }
        return decryption;
    }
    /***
     *  @param message, the encrypted message
     *  Performs the decryption on a string of odd length
     *  @return the decrypted string
     */
    public String oddDecryption(String message) {
        String decryption = "";
        int midpoint = message.length() / 2;
        if (message.length() % 2 != 0) {
            int trueMiddle = midpoint + 1;
            for (int i = 0; i < midpoint; i++) {
                decryption += message.charAt(i);
                decryption += message.charAt(trueMiddle + i);
            }
            decryption += message.charAt(midpoint);
        }
        return decryption;
    }
    @Override
    /***
     *  @param message, the encrypted secret message
     *  @return the decrypted secret message
     */
    public String decrypt(String message){
        String decryption = "";
        if(evenOrOdd(message)){
            decryption = evenDecryption(message);
        }else{
            decryption = oddDecryption(message);
        }
        return decryption;
    }

    /***
     * @return the string EvenOddCipher
     */
    @Override
    public String toString(){
        return "EvenOddCipher";
    }

    /***
     * @param other, object for comparison
     * @return true if two objects are both EvenOddCiphers
     */
    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        } else if (other == null){
            return false;
        } else if (other instanceof EvenOddCipher){
            return true;
        } else{
            return false;
        }
    }
}


