
import static java.lang.Character.isAlphabetic;

/***
 * Represents CaesarCipher
 * @Mitra Kian and lab Partner Rachel Springer
 * @version 2
 * Performs the CasesarCipher encryption and decryption
 */

public class CaesarCipher extends BaseCipher{
    private int key;

    /***
     * Constructor for the key variable of the CaesarCipher object
     * @param key
     */
    public CaesarCipher(int key){
        super("CaesarCipher");
        this.key=key;
    }

    /***
     * Checks CaesarCipher validity
     * @return boolean, true is the cipher key is between [1,25]
     */
    @Override
    public boolean isValid(){
        return key <= 25 && key >= 1;
    }

    /***
     * @param message, secret message
     * @return message, message with the CaesarCipher applied to the message
     */
    @Override
    public String encrypt(String message){
        //The encrypt method in the BaseCipher changes all letters to lowercase
        message = super.encrypt(message);
        int length = message.length();
        String newMess = "";
        for(int i=0; i < length; i++){
           newMess += encryptCharacter(message.charAt(i));
        }
        return newMess;
    }

    /***
     * @param message, encrypted secret message
     * @return  string with the CaesarCipher decryption applied to the message
     */
    @Override
    public String decrypt(String message){
        // to lower case was already in th encrypt methods of BaseCipher
        message = super.encrypt(message);
        int length = message.length();
        String newMess = "";
        for(int i = 0; i < length; i++){
            newMess += decryptCharacter(message.charAt(i));
        }
        return newMess;
    }

    /***
     * @param character, character of the unencrypted secret message
     * Encrypts the individual characters of the spring applying the shift based on the given key
     * @return  Encrypted character
     */
    public char encryptCharacter(char character){
        if(Character.isAlphabetic(character)) {
            int integer = (int)(character-'a');
            integer = (integer+key)%26;
            char newChar = (char)(integer+'a');
            return newChar;
        }
        return character;
    }

    /***
     * @param  character, character of the encrypted secret message
     * Decrypts the individual characters of the spring applying the shift based on the given key
     * @return  Decrypted character
     */
    public char decryptCharacter(char character){
        if(Character.isAlphabetic(character)) {
            int integer = (int)(character-'a');
            integer = (integer-key)%26;
            if(integer<0){
                integer += 26;
            }
            char newChar = (char)(integer+'a');

            return newChar;
        }
        return character;
    }

    /***
     * @return  string of format Caesar(key)
     */
    @Override
    public String toString(){
        return "Caesar("+ key + ")";
    }

    /***
     * @param other, object for comparison
     * Checks if a passed in object is the same as the compared CaesarCipher
     * @return  true if object is a CaesarCipher with the same key
     */
    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        } else if (other == null){
            return false;
        } else if (other instanceof CaesarCipher){
            CaesarCipher caesarCipher = (CaesarCipher) other;
            return this.key == caesarCipher.key;
        } else{
            return false;
        }
    }
}
