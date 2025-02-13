import java.util.ArrayList; // Import ArrayList
import java.util.List;      // Import List

interface FileSystemComponent{
    String getName();
    long getSize();
    void add(FileSystemComponent component); // For Composite only
    void remove(FileSystemComponent component); // For Composite only
    FileSystemComponent getChild(int index); // For Composite only
}

class File implements FileSystemComponent{
    private String name;
    private long size;
    public File(String name, long size){
        this.name = name;
        this.size = size;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public long getSize(){
        return size;
    }
    @Override
    public void add(FileSystemComponent component){
        throw new UnsupportedOperationException("Cannot add to file");
    }
    @Override
    public void remove(FileSystemComponent component){
        throw new UnsupportedOperationException("Cannot remove from a file");
    }
    @Override
    public FileSystemComponent getChild(int index){
        throw new UnsupportedOperationException("File doesn't have children");
    }
}

class Directory implements FileSystemComponent{
    private String name;
    private List<FileSystemComponent> children;

    public Directory(String name){
        this.name = name;
        this.children = new ArrayList<>();
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public long getSize(){
        long totalSize = 0;
        for(FileSystemComponent child: children){
            totalSize+=child.getSize();
        }
        return totalSize;
    }
    @Override
    public void add(FileSystemComponent component){
        children.add(component);
    }
    @Override
    public void remove(FileSystemComponent component){
        children.remove(component);
    }
    @Override
    public FileSystemComponent getChild(int index){
        return children.get(index);
    }
}
public class CompositePattern {
    public static void main(String[] args) {
        File file1 = new File("document.txt", 1024);
        File file2 = new File("image.jpg", 2048);
        Directory documents = new Directory("Documents");
        documents.add(file1);
        documents.add(file2);
        File file3 = new File("report.pdf", 4096);
        Directory project = new Directory("Project");
        project.add(file3);
        project.add(documents);
        System.out.println("Size of " + project.getName() + ": " + project.getSize());
        System.out.println("Size of " + documents.getName() + ": " + documents.getSize());
        System.out.println("Name of file 1 in Documents: " + documents.getChild(0).getName());
    }

}
