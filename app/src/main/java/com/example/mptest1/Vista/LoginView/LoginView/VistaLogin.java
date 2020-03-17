package com.example.mptest1.Vista.LoginView.LoginView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mptest1.Presentador.LoginPresentador.LoginPresentador.PresentadorLogin;
import com.example.mptest1.R;
import com.example.mptest1.VistaSplash;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.File;
import java.util.regex.Pattern;

public class VistaLogin extends AppCompatActivity implements View.OnClickListener {


    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                   // "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");



    private EditText nEtxtEmail,nEtxtPass;
    private PresentadorLogin presentadorLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseAuth nAuth = FirebaseAuth.getInstance();
        DatabaseReference mDB =FirebaseDatabase.getInstance().getReference();
//vinculo los campos de la vista
        presentadorLogin=new PresentadorLogin(this,nAuth,mDB);
       // presentadorLogin.subirPub();
        nEtxtEmail = findViewById(R.id.etCorreo);
        nEtxtPass = findViewById(R.id.etPass);


//clic de botones
        Button nBtnLogin = findViewById(R.id.btnaccedersistema);
        nBtnLogin.setOnClickListener(this);
        Button nBtnRegistrar = findViewById(R.id.btnRegistrarSistema);
        nBtnRegistrar.setOnClickListener(this);
    }

    private boolean validateEmail() {
        String emailInput = nEtxtEmail.getText().toString().trim();

        if (emailInput.isEmpty()) {
            nEtxtEmail.setError("El campo no puede ser vacio!");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            nEtxtEmail.setError("Por favor ingrese una Email valido!");
            return false;
        } else {
            nEtxtEmail.setError(null);
            return true;
        }
    }
    private boolean validatePassword() {
        String passwordInput = nEtxtPass.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            nEtxtPass.setError("El campo no puede ser vacio!");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            nEtxtPass.setError("la contraseña es muy debil!");
            return false;
        } else {
            nEtxtPass.setError(null);
            return true;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnaccedersistema : // hacer el logica de sistema
                Boolean email = validateEmail();
                boolean pass = validatePassword();
                if (email && pass){
                    //acceder al sistema si el formato es valido
                    String emailInput = nEtxtEmail.getText().toString().trim();
                    String passwordInput = nEtxtPass.getText().toString().trim();
                    presentadorLogin.singInUser(emailInput,passwordInput);

                }
                break;
            case R.id.btnRegistrarSistema: //logica para crear usuario
                    presentadorLogin.registrarEnSitema();
                break;

        }
    }
}
