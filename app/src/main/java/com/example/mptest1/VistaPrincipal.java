package com.example.mptest1;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mptest1.Adaptadores.AdaptadorPublicacion;
import com.example.mptest1.Modelo.Publicacion;
import com.example.mptest1.Modelo.Usuario;
import com.example.mptest1.Vista.LoginView.RegistroView.VistaRegistro1;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class VistaPrincipal extends AppCompatActivity {

    DatabaseReference reference;
    private Usuario usuarioLogeado;


    private ImageView imgUsuario;
    private ImageButton btnAgregar,btnActualizar;

    private RecyclerView recyclerView;
    private AdaptadorPublicacion mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Publicacion> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_principal);

        Bundle objEnviado= getIntent().getExtras();
        usuarioLogeado = null;
        imgUsuario = findViewById(R.id.imgPerUsuario);

        if (objEnviado!= null){

        }


        list =  new ArrayList<Publicacion>();

        recyclerView = (RecyclerView) findViewById(R.id.listadoPost);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        reference = FirebaseDatabase.getInstance().getReference().child("Publicaciones");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (   DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                    Publicacion p = dataSnapshot1.getValue(Publicacion.class);
                    list.add(p);
                }
                mAdapter = new AdaptadorPublicacion(VistaPrincipal.this,list);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(VistaPrincipal.this, "Error al cargar las publicaciones", Toast.LENGTH_SHORT).show();
            }
        });

        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent agregaPublicacion = new Intent()
                Toast.makeText(VistaPrincipal.this, "Nueva publicacion", Toast.LENGTH_SHORT).show();

                final ProgressDialog dialog= new ProgressDialog(VistaPrincipal.this);
                dialog.setMessage("Ingresando...");
                dialog.setCancelable(false);
                dialog.show();

                Intent ventana= new Intent(VistaPrincipal.this, VistaNPub.class);
                VistaPrincipal.this.startActivity(ventana);
                dialog.dismiss();
            }
        });

        btnActualizar = findViewById(R.id.btnActualizar);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference().child("Publicaciones");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Toast.makeText(VistaPrincipal.this, "Actualizando", Toast.LENGTH_SHORT).show();
                        list.clear();
                        for (   DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                            Publicacion p = dataSnapshot1.getValue(Publicacion.class);
                            list.add(p);
                        }
                        mAdapter = new AdaptadorPublicacion(VistaPrincipal.this,list);
                        recyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(VistaPrincipal.this, "Error al cargar las publicaciones", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    } // fin del oncreate
}
