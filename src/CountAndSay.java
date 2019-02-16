public class CountAndSay {

    public static void main(String args[]) {
        String ans = countAndSay(4);
        System.out.println();
    }

    public static String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }

        StringBuilder build = new StringBuilder("0");
        process(build, n, 1);
        return build.toString();
    }

    private static void process(StringBuilder build, int n, int count) {
        if (count <= n) {
            String temp = build.toString();
            build.setLength(0);
            for (int i=0; i<temp.length(); i++) {
                if (temp.charAt(i) == '0') {
                    build.append("1");
                } else if (temp.charAt(i) == '2') {
                    build.append("12");
                } else if (temp.charAt(i) == '1') {
                    if (i+1 < temp.length() && temp.charAt(i+1) == '1') {
                        build.append("21");
                        i++;
                    } else {
                        build.append("11");
                    }
                }
            }

            process(build, n, count + 1);
        }
    }
}
