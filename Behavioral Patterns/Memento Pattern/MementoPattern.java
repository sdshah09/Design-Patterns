import java.util.Stack;

class EditorMemento{
    final String text; // once the word is final we can't change it
    public EditorMemento(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }
}

class TextEditor{
    String text;
    public TextEditor(){
        text="";
    }
    public void write(String newText){
        text+=newText;
    }
    public String getText(){
        return text;
    }
    public EditorMemento save(){
        return new EditorMemento(text); // create a memento saving point
    }
    public void restore(EditorMemento memento){
        text = memento.getText();
    }
}
class History{
    Stack<EditorMemento> history = new java.util.Stack<>();
    public void push(EditorMemento memento){
        history.push(memento);
    }
    public EditorMemento pop(){
        if(!history.isEmpty()){
            return history.pop();
        }
        return null;
    }
}
public class MementoPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();
        editor.write("Hello, ");
        System.out.println("Current text: " + editor.getText());
        history.push(editor.save());
        editor.write("How are you? ");
        System.out.println("Current text: " + editor.getText());
        editor.restore(history.pop());
        System.out.println("Current text : " + editor.getText());
    }
}
