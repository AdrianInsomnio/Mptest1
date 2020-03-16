package com.example.mptest1.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mptest1.Modelo.Publicacion;
import com.example.mptest1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/***
 *
 */
public class AdaptadorPublicacion extends RecyclerView.Adapter<AdaptadorPublicacion.PublicacionViewHolder> {

    private Context mContext;
    private List<Publicacion> publicacionLista;

    public AdaptadorPublicacion(Context mContext, List<Publicacion> publicacionLista) {
        this.mContext = mContext;
        this.publicacionLista = publicacionLista;
    }

    @NonNull
    @Override
    public PublicacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view= inflater.inflate(R.layout.activity_vista_item_found,null);
        PublicacionViewHolder holder= new PublicacionViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PublicacionViewHolder holder, int position) {
        Publicacion publicacion = publicacionLista.get(position);

        holder.tvTipoPub .setText(publicacion.getTipoPublicacion());
        holder.tvDescPub .setText(publicacion.getmMensajePublicacion());
        holder.tvNombrePub .setText((publicacion.getnNombreProp()));

        Picasso.get().load(publicacion.getMfoto()).into(holder.imgeAnimal);



    }

    @Override
    public int getItemCount() {
        return publicacionLista.size();
    }

    class PublicacionViewHolder extends RecyclerView.ViewHolder{

        ImageView imgeAnimal,image01,image02,imge03;
        TextView tvTipoPub,tvNombrePub,tvDescPub;




        public PublicacionViewHolder(@NonNull View itemView) {
            super(itemView);

            //imageView
            imgeAnimal = itemView.findViewById(R.id.imgAnimal);
            image01 = itemView.findViewById(R.id.imageIzquierdaCorazon);
            image02 = itemView.findViewById(R.id.imageCentroMano);
            imge03 =  itemView.findViewById(R.id.imageDerechaUbicacion);



            //textView
            tvTipoPub = itemView.findViewById(R.id.tvTipoPublicacion);
            tvNombrePub = itemView.findViewById(R.id.tvNombreUsuario);
            tvDescPub = itemView.findViewById(R.id.tvDescripcion);




        }
    }
}
