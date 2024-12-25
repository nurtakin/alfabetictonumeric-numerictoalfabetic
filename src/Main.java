import java.util.Scanner;

public class Main {

    public static String alphabeticToNumeric(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isAlphabetic(ch)) {
                char letter = Character.toLowerCase(ch);
                int position = letter - 'a' + 1;
                result.append(position).append(" ");
            } else if (ch == ' ') {
                result.append("  ");
            } else {
                result.append(ch).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static String numericToAlphabeticSeparate(String text) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isDigit(ch)) {
                int num = ch - '0'; // Hər bir rəqəmi ayrı-ayrı götürmək
                if (num >= 1 && num <= 9) {
                    result.append((char) (num + 'a' - 1));
                }
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String numericToAlphabeticGrouped(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); ) {
            if (i + 1 < text.length() && Character.isDigit(text.charAt(i)) && Character.isDigit(text.charAt(i + 1))) {
                int num = Integer.parseInt(text.substring(i, i + 2));
                if (num >= 1 && num <= 26) {
                    result.append((char) (num + 'a' - 1));
                    i += 2;
                } else {
                    result.append(text.charAt(i));
                    i++;
                }
            } else if (Character.isDigit(text.charAt(i))) {
                int num = text.charAt(i) - '0';
                if (num >= 1 && num <= 9) {
                    result.append((char) (num + 'a' - 1));
                }
                i++;
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("NAS ilə kriptoqrafiyanın substitusiya prosesini həyata keçirmək üçün söz və ya rəqəm daxil edin:");
        String input = scanner.nextLine();

        System.out.println("1. Hərfləri rəqəmə çevir (alphabetic to numeric)");
        System.out.println("2. Rəqəmləri hərfə çevir (numeric to alphabetic)");
        System.out.print("Seçiminizi edin (1 və ya 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            String result = alphabeticToNumeric(input);
            System.out.println("Çevrilmiş nəticə: " + result);
        } else if (choice == 2) {
            System.out.println("1. Ayrı-ayrı rəqəmlər üzrə çevirmək (məsələn: abac)");
            System.out.println("2. Qruplaşdırılmış rəqəmlər üzrə çevirmək (məsələn: la)");
            System.out.print("Seçiminizi edin (1 və ya 2): ");
            int mode = scanner.nextInt();
            scanner.nextLine();

            if (mode == 1) {
                String result = numericToAlphabeticSeparate(input);
                System.out.println("Çevrilmiş nəticə: " + result);
            } else if (mode == 2) {
                String result = numericToAlphabeticGrouped(input);
                System.out.println("Çevrilmiş nəticə: " + result);
            } else {
                System.out.println("Yanlış seçim! Yalnız 1 və ya 2 daxil edin.");
            }
        } else {
            System.out.println("Yanlış seçim! Yalnız 1 və ya 2 daxil edin.");
        }

        scanner.close();
    }
}

