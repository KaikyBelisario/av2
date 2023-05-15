package com.example.farmbook3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declarar variaveis
    EditText user,email,pwd;
    Button send;

public static final String MyPreferences = "arquivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText) findViewById(R.id.username);
        email=(EditText) findViewById(R.id.email);
        pwd=(EditText) findViewById(R.id.password);
        send=(Button) findViewById(R.id.button);

        //Classe sharedpreferences
        SharedPreferences sharedPreferences = getSharedPreferences(MyPreferences, 0);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declaração de variaveis locais
                String usuarioLocal = user.getText().toString();
                String emailLocal = email.getText().toString();
                String senhaLocal = pwd.getText().toString();

                //Declaração de editor - SharedPreferences no modo de edição
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //Fazer a persistência de dados
                editor.putString("usuario", usuarioLocal);
                editor.putString("email", emailLocal);
                editor.putString("senha", senhaLocal);

                //Confirmar persistência
                editor.commit();

                //Notificação no app
                Toast.makeText(MainActivity.this,"Dados cadastrados com sucesso", Toast.LENGTH_LONG).show();

                //Limpar formulario (global) para o próximo cadastro
                user.getText().clear();
                email.getText().clear();
                pwd.getText().clear();
                user.requestFocus();
            }
        });
    }
}