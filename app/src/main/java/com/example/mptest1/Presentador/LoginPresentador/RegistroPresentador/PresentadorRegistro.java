package com.example.mptest1.Presentador.LoginPresentador.RegistroPresentador;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.mptest1.VistaPrincipal;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PresentadorRegistro {

    private Context mContext;
    private String TAG = "Creando usuario";
    private FirebaseAuth mAuth;
    private DatabaseReference mdb;
    private StorageReference mStorageRef;


    public PresentadorRegistro(Context mContext, FirebaseAuth mAuth, DatabaseReference mdb,StorageReference mStor ) {
        this.mContext = mContext;
        this.mAuth = mAuth;
        this.mdb = mdb;
        this.mStorageRef = mStor;
    }


    public String uploadImage(final Uri filePath){
        if (filePath!=null){

            final ProgressDialog dialog= new ProgressDialog(mContext);
            dialog.setMessage("Subiendo Imagen...");
            dialog.setCancelable(false);
            dialog.show();



            mStorageRef.child("Fotos/"+ UUID.randomUUID().toString());
            mStorageRef.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Toast.makeText(mContext,"Subiendo Imagen",Toast.LENGTH_SHORT).show();

                        }
                    });
            dialog.dismiss();

        }
            return  filePath.toString();
    }


    public void singUpUser(final String email, final String password
            , final String nombreUsuario
            , final String nombre
            , final String apellido
            , final  String telefono
            , final Uri filePath){

        final ProgressDialog dialog= new ProgressDialog(mContext);
        dialog.setMessage("Registrando...");
        dialog.setCancelable(false);
        dialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            dialog.dismiss();
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Map<String,Object> crearUsuario= new HashMap<>();
                            crearUsuario.put("nombreUsuarioReg",nombreUsuario);
                            crearUsuario.put("nombreReg",nombre);
                            crearUsuario.put("apellidoReg",apellido);
                            crearUsuario.put("emailReg",email);
                            // crearUsuario.put("passReg",password);
                            crearUsuario.put("telefonoReg",telefono);
                            crearUsuario.put("UriDowload",uploadImage(filePath));


                            mdb.child("Usuario").child(task.getResult().getUser().getUid()).updateChildren(crearUsuario);
                            // ir a la vista principal
                            Intent ventanaPrincipal = new Intent(mContext, VistaPrincipal.class);
                            mContext.startActivity(ventanaPrincipal);
                        } else {

                            dialog.dismiss();
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText( mContext, "Authentication failed.",Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }


}
