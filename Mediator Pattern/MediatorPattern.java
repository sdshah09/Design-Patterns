interface ChatRoom{
    void sendMessage(String message, User user);
}
class ChatRoomImpl implements ChatRoom{
    java.util.List<User> users = new java.util.ArrayList<>();
    public void registerUser(User user){
        users.add(user);
    }
    public void sendMessage(String message, User user){
        for(User u: users){
            if(u!=user){
                u.receiveMessage(message);
            }
        }
    }
}


class User{
    String name;
    ChatRoom chatRoom;
    public User(String name, ChatRoom chatRoom){
        this.name = name;
        this.chatRoom = chatRoom;
    }
    public void sendMessage(String message){
        chatRoom.sendMessage(message, this);
    }
    public void receiveMessage(String message){
        System.out.println(name + " received: " + message);
    }
}
public class MediatorPattern {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoomImpl();
        User john = new User("John", chatRoom);
        User jane = new User("Jane", chatRoom);
        User joe = new User("Joe",chatRoom);
        ((ChatRoomImpl) chatRoom).registerUser(john);
        ((ChatRoomImpl) chatRoom).registerUser(jane);
        ((ChatRoomImpl) chatRoom).registerUser(joe);
        john.sendMessage("Hi Jane!");
        jane.sendMessage("Hello John");
        jane.sendMessage("Hello Joe");
    }
}
