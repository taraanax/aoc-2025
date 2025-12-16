import java.util.ArrayList;

public class Day01 extends Day {

    @Override
    public int part1() {
        ArrayList<String> data = readInput();

        int count = 0;
        int jala = 50;
        for (String datum : data) {
            int nucci = Integer.parseInt(datum.substring(1)) % 100;
            if (datum.charAt(0) == 'R') {
                if (jala + nucci > 99) {
                    jala = nucci - (100 - jala);
                } else {
                    jala += nucci;
                }
            } else {
                if (jala - nucci < 0) {
                    jala = 100 - (nucci - jala);
                } else {
                    jala -= nucci;
                }
            }
            if (jala == 0) count++;
        }
        return count;
    }

    @Override
    public int part2() {
        ArrayList<String> data = readInput();

        int count = 0;
        int jala = 50;
        for (String datum : data) {
            int nucci = Integer.parseInt(datum.substring(1));
            int buba = nucci / 100;  // celi krogi
            nucci = nucci % 100; // premik

            if (datum.charAt(0) == 'R') {
                for (int i = 0; i < nucci; i++) {
                    if ((jala + i) % 100 == 0) count++;
                }
                jala = (jala + nucci) % 100;
            } else {
                for (int i = 0; i < nucci; i++) {
                    if ((jala - i + 100) % 100 == 0) count++;
                }
                jala = (jala - nucci + 100) % 100;
            }
            count += buba;
        }
        return count;
    }

}

