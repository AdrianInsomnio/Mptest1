package com.example.mptest1.Presentador.LoginPresentador.LoginPresentador;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.mptest1.Vista.LoginView.RegistroView.VistaRegistro1;
import com.example.mptest1.VistaPrincipal;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

//import static androidx.constraintlayout.widget.Constraints;

public class PresentadorLogin {
    private Context mContext;
    private String TAG;
    private FirebaseAuth mAuth;
    private DatabaseReference mdb;

    public PresentadorLogin(Context mContext, FirebaseAuth mAuth, DatabaseReference mdb) {
        this.mContext = mContext;
        this.mAuth = mAuth;
        this.mdb = mdb;
    }
    public void registrarEnSitema(){
        final ProgressDialog dialog= new ProgressDialog(mContext);
        dialog.setMessage("Ingresando...");
        dialog.setCancelable(false);
        dialog.show();

        Intent ventana= new Intent(mContext, VistaRegistro1.class);
        mContext.startActivity(ventana);
        dialog.dismiss();
    }
    public void singInUser(String email,String password){
        final ProgressDialog dialog= new ProgressDialog(mContext);
        dialog.setMessage("Ingresando...");
        dialog.setCancelable(false);
        dialog.show();


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:Exitoso");
                            dialog.dismiss();
                            mdb.child("Usuarios").setValue(task.getResult().getUser().getUid());
                            Toast.makeText(mContext, "Bienvenido",
                                    Toast.LENGTH_SHORT).show();
                            Intent inten= new Intent(mContext, VistaPrincipal.class);
                            mContext.startActivity(inten);

                        } else {

                            dialog.dismiss();
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(mContext, "Usuario Invalido.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
}
