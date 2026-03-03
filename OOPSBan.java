public class OOPSBan {

    static class CharacterPatternMap {
        private Character character;
        private String[] pattern;

        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public Character getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    public static CharacterPatternMap[] createCharacterPatternMaps() {
        CharacterPatternMap[] charMaps = new CharacterPatternMap[4];

        // Adjusted to uniform 7-character width for a clean look
        String[] patternO = {
            " ***** ",
            "** **",
            "** **",
            "** **",
            "** **",
            "** **",
            " ***** "
        };

        String[] patternP = {
            "****** ",
            "** **", // Fixed missing spaces and asterisks
            "** **", // Fixed missing spaces and asterisks
            "****** ", // Fixed the middle part of the 'P'
            "** ", // Fixed the stem of the 'P'
            "** ", // Fixed the stem of the 'P'
            "** "  // Fixed the stem of the 'P'
        };

        String[] patternS = {
            " ***** ",
            "** ", // Adjusted for better 'S' shape
            "** ", // Adjusted for better 'S' shape
            " ***** ",
            "     **",
            "     **",
            " ***** "
        };

        String[] patternSpace = {
            "       ", // Space should be completely empty
            "       ",
            "       ",
            "       ",
            "       ",
            "       ",
            "       "
        };

        charMaps[0] = new CharacterPatternMap('O', patternO);
        charMaps[1] = new CharacterPatternMap('P', patternP);
        charMaps[2] = new CharacterPatternMap('S', patternS);
        charMaps[3] = new CharacterPatternMap(' ', patternSpace); // Fixed the character key to actually be a space

        return charMaps;
    }

    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        // Fallback to space if character is not found
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ' ') {
                return map.getPattern();
            }
        }
        return new String[7];
    }

    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        for (int line = 0; line < 7; line++) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                String[] pattern = getCharacterPattern(ch, charMaps);
                // Added 1 standard space between each letter for readability (reduced from 2)
                row.append(pattern[line]).append(" "); 
            }
            System.out.println(row.toString());
        }
    }

    public static void main(String[] args) {
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        String message = "OOPS";
        printMessage(message, charMaps);
    }
}