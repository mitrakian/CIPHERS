
/***
 * Represents WordReplacementCipher
 * @author Mitra Kian
 * @version 1
 * The following class constructs a WordReplacementCipher
 * Additionally it performs the WordReplacementCipher encryption and decryption
 */
public class WordReplacementCipher extends BaseCipher{
    private String fromWord;
    private String toWord;

    /***
     * @param fromWord, toWord, the word which is being replaced and the word it is replaced with
     * Constructs the WordReplacementCipher with the "fromWord" and the replacement "toWord"
     */
    public WordReplacementCipher(String fromWord, String toWord){
        super("WordReplacementCipher");
        this.fromWord = fromWord;
        this.toWord = toWord;
    }

    /***
     * @param message, takes in the secret message
     * Replaces the fromWords with the twoWords
     * @return the string with the encrypted cipher
     */
    @Override
    public String encrypt(String message) {
        return message.replace(fromWord,toWord);
    }

    /***
     * @param message, takes in the secret message
     * Replaces the toWords with the fromWords
     * @return the string with the decrypted cipher
     */
    @Override
    public String decrypt(String message){
        return message.replace(toWord,fromWord);
    }

    /***
     * @return a string of the following format: WordReplacementCipher(fromWord,toWord)
     */
    @Override
    public String toString(){
        return "WordReplacementCipher("+fromWord+", "+toWord+")";
    }

    /***
     * @param other, object for comparison
     * Compares two objects to see if they are both the SAME WordReplacementCipher (same toWord and fromWord)
     * @return true if they are both word replacement ciphers with the same toWord and fromWord
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof WordReplacementCipher) {
            WordReplacementCipher wordReplacementCipher = (WordReplacementCipher) other;
            return this.toWord.equals(wordReplacementCipher.toWord) && this.fromWord.equals(wordReplacementCipher.fromWord);
        } else {
            return false;
        }
    }
}

