package com.example.vincent.helloworld;

import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private ArrayList<User> personne;

    public Adapter(ArrayList<User> pPersonne){

        this.personne = pPersonne;
    }


    @Override
    public int getItemCount() {

        return personne.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String nom = personne.get(position).getNom();
        String email = personne.get(position).getEmail();
        holder.display(personne.get(position));
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView email;
        private Pair<String, String> currentPair;

        public MyViewHolder(final View itemView) {

            super(itemView);
            name = ((TextView) itemView.findViewById(R.id.name));
            email = ((TextView) itemView.findViewById(R.id.email));

            /*itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(currentPair.first)
                            .setMessage(currentPair.second)
                            .show();
                }
            }); */
        }

        public void display(User pUser) {

            name.setText(pUser.getNom());
            email.setText(pUser.getEmail());
        }
    }
}