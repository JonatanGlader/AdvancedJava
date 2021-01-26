public class Finding {

    String word;
    int line;
    int start;
    int end;

    int amount;

    int part = 0;

    Finding(int part, String word, int line, int start, int end) {
        this.word = word;
        this.line = line;
        this.start = start;
        this.end = end;
        this.part = part;
    }

    Finding(int part, int amount) {
        this.amount = amount;
        this.part = part;
    }

    public String toString() {

        if(amount > 0) {
            return "\n" + part + ": " + "Found: " + amount + " of the pattern";
        } else {
            return "\n" + part + ": " + "word found: " + this.word + " at line: " + this.line + " Position: starts at: " + this.start + " ends at: " + this.end;
        }
    }
}
