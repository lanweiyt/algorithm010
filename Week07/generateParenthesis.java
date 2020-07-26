import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        generateParenthesis(res, builder,  0, 0, n);
        return res;
    }

    private void generateParenthesis(List<String> res, StringBuilder builder,
                                     int left, int right, int max) {
        if (right == max) {
            res.add(builder.toString());
            return;
        }
        if (left < max) {
            generateParenthesis(res, builder.append("("), left + 1, right, max);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right < left) {
            generateParenthesis(res, builder.append(")"), left, right + 1, max);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
