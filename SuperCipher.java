//Mitra Kian
//SuperCipher

import java.util.Arrays;

/***
 * Represents SuperCipher
 * @author Mitra Kian
 * @version 1
 * The following SuperCipher relates to the SuperCiphers, which are arrays of all the BaseCiphers
 * The array stores the order of Ciphers used in encryption and decryption, additionally providing relavent information
 * about each cipher.
 */
public class SuperCipher extends BaseCipher {

    private BaseCipher[] baseCipher;

    /***
     * @param baseCipher, array of BaseCiphers
     * Constructs an array of BaseCiphers
     */
    public SuperCipher(BaseCipher[] baseCipher) {
        super("SuperCipher");
        this.baseCipher = baseCipher;
    }

    /***
     * Checks if each BaseCipher in the array is valid
     *  @return a Boolean value: true if all values in the array are valid, false if not
     */
    public boolean isValid() {
        for (int i = 0; i < baseCipher.length; i++) {
            if (!baseCipher[i].isValid()) {
                return false;
            }
        }
        return true;
    }

    /***
     *  @param message
     *  @return the encrypted message after all ciphers in the BaseCipher have been applied
     */
    public String encrypt(String message) {
        String enctryptedMessage = message;
        for (int i = 0; i < baseCipher.length; i++) {
            enctryptedMessage = baseCipher[i].encrypt(enctryptedMessage);
        }
        return enctryptedMessage;
    }
    /***
     *  @param message, but the encrypted version
     *  @return the decrypted message after all the decryptions of the ciphers in the BaseCipher have been applied
     */
    public String decrypt(String message) {
        String decryptedMessage = message;
        for (int i = (baseCipher.length - 1); i >= 0; i--) {
            decryptedMessage = baseCipher[i].decrypt(decryptedMessage);
        }
        return decryptedMessage;
    }

    /***
     *  @return a string formatted as SuperCipher(...|...| list of BaseCiphers |...|...)
     */
    public String toString(){
        String newString ="SuperCipher(";
        for(int i = 0; i<baseCipher.length; i++ )
        {
            newString += baseCipher[i].toString();
            if(i<baseCipher.length-1){
                newString += " | ";
            }
        }
        return newString+")";
    }

    /***
     *  @param other, object for comparison
     *  Checks for equality in the SuperCipher array
     *  @return True if the arrays are the same (same type, length, and content)
     */
    public boolean equals(Object other){
        if(this == other){
            return true;
        } else if (other == null){
            return false;
        } else if (other instanceof SuperCipher){
            SuperCipher superCipher = (SuperCipher) other;
            if(Arrays.equals(superCipher.baseCipher,baseCipher)){
                return true;
            }
            return false;

        } else{
            return false;
        }
    }
}




