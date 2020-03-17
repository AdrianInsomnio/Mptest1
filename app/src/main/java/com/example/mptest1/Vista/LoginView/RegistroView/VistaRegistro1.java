package com.example.mptest1.Vista.LoginView.RegistroView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mptest1.ACtividad2;
import com.example.mptest1.Presentador.LoginPresentador.LoginPresentador.PresentadorLogin;
import com.example.mptest1.Presentador.LoginPresentador.RegistroPresentador.PresentadorRegistro;
import com.example.mptest1.R;
import com.example.mptest1.VistaPrincipal;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.regex.Pattern;

public class VistaRegistro1 extends AppCompatActivity  implements View.OnClickListener {


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
    private EditText nEtxtEmail,nEtxtPass,nEtxtNombreUsuario,nEtxtnombre,nEtxtapellido,nEtxtTelefono;
    PresentadorRegistro presentador;
    FirebaseStorage mStorageRef;

    // fotos
    private ImageView imagenPerfil;
    private EditText et1;
    Button mbtnGuardar;
    ImageButton cam,galeria;
    private Uri filepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_registro1);

        //FirebaseStorage storage = FirebaseStorage.getInstance();

        mStorageRef = FirebaseStorage.getInstance();
        StorageReference refSto= mStorageRef.getReference();

        FirebaseAuth nAuth = FirebaseAuth.getInstance();
        DatabaseReference mDB = FirebaseDatabase.getInstance().getReference();

        presentador = new PresentadorRegistro(this,nAuth,mDB,refSto);
        //vinculo los campos de la vista

        nEtxtEmail = findViewById(R.id.etCorreoReg);
        nEtxtPass = findViewById(R.id.etPassReg);
        nEtxtNombreUsuario = findViewById(R.id.etUsuarioReg);
        nEtxtnombre = findViewById(R.id.etNombreReg);
        nEtxtapellido = findViewById(R.id.etApellidoReg);
        nEtxtTelefono = findViewById(R.id.etTelefonoReg);

        mbtnGuardar = findViewById(R.id.btnRegistrarUsuario);
        mbtnGuardar.setOnClickListener(this);

        imagenPerfil = findViewById(R.id.logoImagen);

        cam = findViewById(R.id.imageCamara);
        cam.setOnClickListener(this);

        galeria = findViewById(R.id.imageGaleria);
        galeria.setOnClickListener(this);

        //filepath = imagenPerfil;

        //imagen1=(ImageView)findViewById(R.id.imageView);
        //et1=(EditText)findViewById(R.id.editText);
    }



    //validaciones


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
            nEtxtPass.setError("la contraseña es muy debil!\nDebe tener 6 caracteres\nAl menos 1 digito\nAl menos 1 numero");
            return false;
        } else {
            nEtxtPass.setError(null);
            return true;
        }
    }
    Boolean validarForm(){
        Boolean email = true ;// validateEmail();
        Boolean pass = true ;//  validatePassword();

        if (validateEmail()){
            if (validatePassword()) {
                return true;
            }else {return  false;}
        }else {return  false;}
    }

    // implemantacion del click de botones

    public void tomarFoto(View v) {
        Intent intento1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //File foto = new File(getExternalFilesDir(null), et1.getText().toString());
        //intento1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
        startActivityForResult(intento1,200);
    }
    public void recuperarFoto(View v) {
        Intent intentGaleria = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intentGaleria,100);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data !=null &&data.getData() != null) {

            filepath = data.getData();
            imagenPerfil.setImageURI(data.getData());
        }
        if (requestCode == 200 && resultCode == RESULT_OK && data !=null &&data.getData() != null) {

            filepath = data.getData();
            imagenPerfil.setImageBitmap((Bitmap) data.getExtras() .get("data"));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistrarUsuario: // hacer el logica de sistema


                if (validarForm()) {
                    //acceder al sistema si el formato es valido

                    // correo
                    String emailInput = nEtxtEmail.getText().toString().trim();
                    // contraseña
                    String passwordInput = nEtxtPass.getText().toString().trim();
                    // nombre
                    String nombreInput= nEtxtnombre.getText().toString().trim();
                    // apellido
                    String apellidoInput=nEtxtapellido.getText().toString().trim();
                    // telefono
                    String nombreUsuario = nEtxtNombreUsuario.getText().toString().trim();
                    // telefono
                    String telefonoInput = nEtxtTelefono.getText().toString().trim();

                   // presentador.uploadImage(filepath);


                   presentador.singUpUser(emailInput,passwordInput,nombreInput,nombreUsuario,apellidoInput,telefonoInput,filepath);

                }
                break;
            case R.id.imageCamara:
//                startActivity(intent);
                 tomarFoto(view);
                break;
            case R.id.imageGaleria:
                recuperarFoto(view);
                break;
            case R.id.listarMascotas:
                // activiti con lista de mascotas de cada ususario
                Toast.makeText(VistaRegistro1.this, "Listando  Mascotas", Toast.LENGTH_SHORT).show();
                
                break;
        }


    }

}
