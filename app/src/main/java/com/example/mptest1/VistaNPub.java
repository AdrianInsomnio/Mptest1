package com.example.mptest1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.mptest1.Vista.LoginView.RegistroView.VistaRegistro1;

import de.hdodenhof.circleimageview.CircleImageView;

public class VistaNPub extends AppCompatActivity  implements View.OnClickListener {

    Uri filepath;
    ImageView imagenPublicacion;
    ImageButton camPub,galPub;
    Button guardar;
    CircleImageView perfil;
    Spinner progreso;
    EditText descPub,extra;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_n_pub);

        imagenPublicacion = findViewById(R.id.logoImagenPub);
        camPub = findViewById(R.id.imageCamaraPub);
        galPub = findViewById(R.id.imageGaleriaPub);
        guardar = findViewById(R.id.btnRegistrarPub);
        perfil = findViewById(R.id.usuarioLogoPub);

        //Spinner spinner = (Spinner) findViewById(R.id.TipoPublicacion);

        camPub.setOnClickListener(this);
        galPub.setOnClickListener(this);
    }


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
            imagenPublicacion.setImageURI(data.getData());
        }
        if (requestCode == 200 && resultCode == RESULT_OK && data !=null &&data.getData() != null) {

            filepath = data.getData();
           // imagenPublicacion.setImageBitmap((Bitmap) data.getExtras() .get("data"));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistrarPub: // hacer el logica de sistema

/*
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
*/

                break;
            case R.id.imageCamaraPub:
//                startActivity(intent);
                tomarFoto(view);
                break;
            case R.id.imageGaleriaPub:
                recuperarFoto(view);
                break;

        }


    }



}
