package com.jubi.ai.chatbot.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;
import com.jubi.ai.chatbot.enums.MaterialTheme;
import com.jubi.ai.chatbot.models.ChatBotConfig;
import com.jubi.ai.chatbot.views.activity.ChatBotActivity;

public class ChatActivity extends AppCompatActivity {

    Button open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ChatBotActivity.setUp(this, chatBotConfig());
        open = findViewById(R.id.open);
        //call this on click event if setWidgetRequired = false else don't
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatBotActivity.launch(ChatActivity.this);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ChatBotActivity.CODE_DRAW_OVER_OTHER_APP_PERMISSION) {
            ChatBotActivity.initChatHead(this);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private ChatBotConfig chatBotConfig() {
        ChatBotConfig chatBotConfig = new ChatBotConfig();
        chatBotConfig.setAppLogo(R.drawable.ic_icici_logo);
        chatBotConfig.setMaterialTheme(MaterialTheme.ICICI);
        chatBotConfig.setTitle("ICICI");
        chatBotConfig.setAttachmentRequired(false);
        chatBotConfig.setSubTitle("Your virtual assistant");
        chatBotConfig.setProjectId("JUBIglSWd_amazon");
        chatBotConfig.setPath("android");
        chatBotConfig.setHost("http://132.145.44.1:8000");
        chatBotConfig.setSpeechRequired(true);
        chatBotConfig.setFcmToken(FirebaseInstanceId.getInstance().getToken());
        chatBotConfig.setWidgetRequired(false);
        chatBotConfig.setPersistentMenu("Start Over," +
                "Cancel conversation");
        return chatBotConfig;
    }

}
