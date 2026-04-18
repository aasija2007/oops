import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// ================= MAIN =================
public class Main {
    public static void main(String[] args) {
        ChatService service = new AutoReplyService();

        // Check if GUI is supported
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("Running in console mode (Headless Environment)");
            new ConsoleChat(service).start();
        } else {
            SwingUtilities.invokeLater(() -> {
                ChatView view = new ChatView();
                new ChatController(view, service);
                view.setVisible(true);
            });
        }
    }
}

// ================= SOLID: MESSAGE MODEL =================
class Message {
    private final String sender;
    private final String text;
    private final String time;

    public Message(String sender, String text) {
        this.sender = sender;
        this.text = text;
        this.time = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "[" + time + "] " + sender + ": " + text;
    }
}

// ================= SOLID: SERVICE =================
interface ChatService {
    String getReply(String userMessage);
}

class AutoReplyService implements ChatService {
    public String getReply(String msg) {
        msg = msg.toLowerCase();

        if (msg.contains("hi") || msg.contains("hello"))
            return "Hello! Nice to meet you.";
        if (msg.contains("time"))
            return "Current time: " + LocalTime.now();
        if (msg.contains("bye"))
            return "Goodbye!";

        return "Bot received: " + msg;
    }
}

// ================= SWING VIEW =================
class ChatView extends JFrame {
    JTextArea chatArea = new JTextArea();
    JTextField inputField = new JTextField();
    JButton sendButton = new JButton("Send");

    public ChatView() {
        setTitle("Chat Simulator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea.setEditable(false);

        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(inputField, BorderLayout.CENTER);
        bottom.add(sendButton, BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);
    }

    public void appendMessage(String msg) {
        chatArea.append(msg + "\n");
    }
}

// ================= CONTROLLER =================
class ChatController {
    private final ChatView view;
    private final ChatService service;

    public ChatController(ChatView view, ChatService service) {
        this.view = view;
        this.service = service;

        view.sendButton.addActionListener(e -> send());
        view.inputField.addActionListener(e -> send());
    }

    private void send() {
        String text = view.inputField.getText().trim();
        if (text.isEmpty()) return;

        view.appendMessage(new Message("You", text).toString());
        view.inputField.setText("");

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            String reply = service.getReply(text);
            SwingUtilities.invokeLater(() ->
                    view.appendMessage(new Message("Bot", reply).toString()));
        }).start();
    }
}

// ================= CONSOLE MODE =================
class ConsoleChat {
    private final ChatService service;

    public ConsoleChat(ChatService service) {
        this.service = service;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("You: ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) break;

            Thread botThread = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                System.out.println("Bot: " + service.getReply(input));
            });

            botThread.start();

            try {
                botThread.join();
            } catch (InterruptedException e) {
            }
        }

        sc.close();
    }
}