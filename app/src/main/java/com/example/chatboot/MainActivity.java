package com.example.chatboot;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView messageListView;
    private EditText messageEditText;
    private Button sendButton;
    private List<String> messages;
    private ArrayAdapter<String> messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageListView = findViewById(R.id.messageListView);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        messages = new ArrayList<>();
        messageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, messages);
        messageListView.setAdapter(messageAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = messageEditText.getText().toString().trim();
        if (!message.isEmpty()) {
            messages.add("You: " + message);
            String response = generateResponse(message);
            messages.add("Chatbot: " + response);
            messageAdapter.notifyDataSetChanged();
            messageEditText.setText("");
        }
    }

    private String generateResponse(String question) {

            if (question.contains("becas")) {
            return "Puedes acceder en el siguiente enlace: [becas](https://smart.zegelipae.edu.pe/ContenedorSolicitudBecasBus.aspx?)";
        } else if (question.contains("cursos")) {
            return "Accede a los cursos aqui: [cursos](https://www.zegelipae.edu.pe/cursos";

                } else {
            return "Lo siento, no puedo responder esa pregunta en este momento.";
        }
    }
}

