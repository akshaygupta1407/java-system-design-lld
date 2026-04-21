package module4.composite;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showDetails();
}

class FileLeaf implements FileSystemComponent {
    private final String name;

    public FileLeaf(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File: " + name);
    }
}

class FolderComposite implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> children = new ArrayList<>();

    public FolderComposite(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    public void showDetails() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent child : children) {
            child.showDetails();
        }
    }
}

public class CompositeLesson {
    public static void main(String[] args) {
        System.out.println("--- Composite Demo ---");
        FolderComposite root = new FolderComposite("root");
        root.add(new FileLeaf("a.txt"));
        FolderComposite docs = new FolderComposite("docs");
        docs.add(new FileLeaf("b.txt"));
        root.add(docs);
        root.showDetails();
    }
}
