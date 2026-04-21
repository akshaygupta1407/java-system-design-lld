package module3.command;

/**
 * PRACTICE QUESTION: Command Pattern
 *
 * Scenario: You are building a text editor.
 *
 * Your goal:
 * 1. Create a `Command` interface with `execute()`.
 * 2. Implement commands such as:
 *    - `InsertTextCommand`
 *    - `DeleteTextCommand`
 * 3. Create a `TextEditor` receiver that holds the actual text.
 * 4. Create an invoker that can execute commands one by one.
 *
 * Hint:
 * The invoker should not know the internals of the text editor.
 */

interface Command {
    void execute();
}

class InsertTextCommand implements Command {
    private TextEditor editor;
    private String text;

    public InsertTextCommand(TextEditor editor, String text) {
        this.editor = editor;
        this.text = text;
    }

    @Override
    public void execute() {
        editor.insertText(text);
    }
}

class DeleteTextCommand implements Command {
    private TextEditor editor;
    private int startIndex;
    private int endIndex;

    public DeleteTextCommand(TextEditor editor, int startIndex, int endIndex) {
        this.editor = editor;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void execute() {
        editor.deleteText(startIndex, endIndex);
    }
}

class TextEditor {
    private StringBuilder text;

    public TextEditor() {
        this.text = new StringBuilder();
    }

    public void insertText(String text) {
        this.text.append(text);
    }

    public void deleteText(int startIndex, int endIndex) {
        this.text.delete(startIndex, endIndex);
    }

    public String getText() {
        return this.text.toString();
    }
}

public class CommandPractice {
    public static void main(String[] args) {
        System.out.println("--- Command Practice ---");

        // TODO:
        // 1. Define the command interface and concrete commands.
        // 2. Create the receiver text editor.
        // 3. Create an invoker to run commands.
        // 4. Test multiple commands.

        System.out.println("Complete the TODOs to practice Command.");
    }
}
