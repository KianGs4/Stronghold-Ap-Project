package model.chatRoom;

import java.util.ArrayList;

public class Chat {
    public enum ChatMode{
        GLOBAL, PRIVATE, ROOM;
    }
    private final String chatId;
    private final ArrayList<String> users;
    private ArrayList<Message> messages;
    private ChatMode chatMode;
    public Chat(ArrayList<String> users, ChatMode chatMode, String id){
        this.users = users;
        this.chatMode = chatMode;
        messages = new ArrayList<>();
        chatId = chatMode.name().toLowerCase() + id;
        ChatManager.updateChat(this, chatMode);
    }

    public void addMessage(Message msg){
     messages.add(msg);
     ChatManager.updateChat(this, chatMode);
    }

    public String getChatId() {
        return chatId;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public ChatMode getChatMode() {
        return chatMode;
    }

    public ArrayList<String> getUsers() {
        return users;
    }
}
