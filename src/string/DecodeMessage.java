package string;

/**
 * This problem was asked by Facebook.
 *
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 *
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 *
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */
public class DecodeMessage {
    public int waysToDecode(String encodedMessage) {
        return waysToDecode(encodedMessage, 0);
    }

    private int waysToDecode(String encodedMessage, int idx) {

        if(encodedMessage.equals(""))
            return 0;
        int mapping = Integer.parseInt(encodedMessage.substring(idx));
        if(mapping >=1 && mapping <=26)
            return 1;

//        return waysToDecode(encodedMessage, idx+1) + waysToDecode(encodedMessage.substring(0, idx), );
        return 0;
    }
    public static void main(String[] args) {
        DecodeMessage decodeMessage = new DecodeMessage();
        String message = "111";
        System.out.println(decodeMessage.waysToDecode(message));;
    }
}
