
/***
 * Represents EncryptUtils
 * @author Mitra Kian
 * @version 1
 * The following class stores the decryptions and encryptions for each BaseCipher in the array
 */

public class EncryptUtils {
    /***
     * @param baseCipher and String array with the secret message
     * @return the encrypted version of the array
     */
    public static String[] encryptMany(BaseCipher baseCipher, String[] array) {
        int length = array.length;
        String[] newArray = new String[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = baseCipher.encrypt(array[i]);
        }
        return newArray;
    }
    /***
     * @param baseCipher and String array with encrypted secret message
     * @return the decrypted version of the array
     */
    public static String[] decryptMany(BaseCipher baseCipher, String[] array){
        int length = array.length;
        String[] newArray = new String[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = baseCipher.decrypt(array[i]);
        }
        return newArray;
    }
}
