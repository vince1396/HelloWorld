package com.example.vincent.helloworld;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;
        import java.util.ArrayList;

        import butterknife.BindView;
        import butterknife.ButterKnife;
        import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    //================================ DECLARATION VARIABLES GLOBALES===============================
    @BindView(R.id.nom) EditText nom;
    @BindView(R.id.email) EditText email;
    @BindView(R.id.user) Button createUser;
    @BindView(R.id.valider) Button valider;
    @BindView(R.id.rep) Button rep;
    @BindView(R.id.contacts) RecyclerView listContacts;
    @BindView(R.id.repbyname) Button repByName;
    @BindView(R.id.okbyname) Button okByName;
    @BindView(R.id.searchName) EditText searchName;

    private ArrayList<User> alRep = new ArrayList<>();

    //======================================= ON CREATE ============================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        listContacts.setLayoutManager(new LinearLayoutManager(this));
        listContacts.setAdapter(new Adapter(alRep));

    }

    //=============================== CLICK SUR BOUTON SHOW ========================================
    @OnClick(R.id.show)
    public void showClick(){

        Toast.makeText(MainActivity.this, "Coucou", Toast.LENGTH_SHORT).show();
    }

    //================================== CLICK SUR BOUTON GO =======================================
    @OnClick(R.id.go)
    public void goClick(){

        Intent intent = new Intent(MainActivity.this, ShowActivity.class);
        startActivity(intent);
    }

    //================================= CLICK SUR BOUTON SAISIR ====================================
    @OnClick(R.id.saisir)
    public void saisirClick(){

        Intent intent2 = new Intent(MainActivity.this, Edit.class);
        startActivity(intent2);
    }

    //================================== CLICK SUR BOUTON CREER ====================================
    @OnClick(R.id.user)
    public void creerClick(){

        valider.setVisibility(View.VISIBLE);
        createUser.setVisibility(View.INVISIBLE);
        nom.setVisibility(View.VISIBLE);
        email.setVisibility(View.VISIBLE);
        rep.setVisibility(View.INVISIBLE);
        listContacts.setVisibility(View.INVISIBLE);
        repByName.setVisibility(View.INVISIBLE);
    }

    //================================== CLICK SUR BOUTON VALIDER ==================================
    @OnClick(R.id.valider)
    public void validerClick(){

        if(nom.getText().toString().equals("") | email.getText().toString().equals(""))
        {
            Toast.makeText(MainActivity.this, "Veuillez remplir les champs", Toast.LENGTH_SHORT).show();
        }
        else
        {


            createUser.setVisibility(View.VISIBLE);
            valider.setVisibility(View.INVISIBLE);
            nom.setVisibility(View.INVISIBLE);
            email.setVisibility(View.INVISIBLE);
            rep.setVisibility(View.VISIBLE);
            repByName.setVisibility(View.VISIBLE);

            String pNom = nom.getText().toString();
            String pEmail = email.getText().toString();

            email.setText("");
            nom.setText("");

            User user = new User();
            user.setNom(pNom);
            user.setEmail(pEmail);
            alRep.add(user);
        }
    }

    //==================================== CLICK SUR BOUTON REP ====================================
    @OnClick(R.id.rep)
    public void repClick(){

        String texte = "";

        for(int i =0; i< alRep.size(); i++)
        {
            texte = texte + "\n Nom : " + alRep.get(i).getNom() + "\n Email : " + alRep.get(i).getEmail() + "\n";
        }

        listContacts.setVisibility(View.VISIBLE);
        //// TODO: 01/06/2017 setText manquant 
    }

    //================================ CLICK SUR BOUTON REPNAME ====================================
    @OnClick(R.id.repbyname)
    public void RepByNameClick(){

        createUser.setVisibility(View.INVISIBLE);
        rep.setVisibility(View.INVISIBLE);
        searchName.setVisibility(View.VISIBLE);
        repByName.setVisibility(View.INVISIBLE);
        okByName.setVisibility(View.VISIBLE);
        listContacts.setVisibility(View.INVISIBLE);

        searchName.setText("");
    }

    //================================= CLICK SUR BOUTON OK ========================================
    @OnClick(R.id.okbyname)
    public void okClick(){

        if(searchName.getText().toString().equals(""))
        {
            Toast.makeText(MainActivity.this, "Veuillez saisir un nom", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String search = searchName.getText().toString();
            String result ="";
            int nb_match = 0;
            String nomContact = "";

            for(int i=0; i<alRep.size(); i++)
            {
                if(alRep.get(i).getNom().equals(search))
                {
                    nb_match++;
                    nomContact = alRep.get(i).getNom();
                    result = result + alRep.get(i).getEmail() + "\n";
                }
            }

            if(nb_match > 1)
            {
                result = nb_match + " contacts trouvés \n \n" + result;
            }
            else if(nb_match == 1 && !result.equals(""))
            {
                result = "Email de "+ nomContact + " : " + result;
            }

            if(result.equals(""))
            {
                result = "Aucun contact trouvé";
            }

            //// TODO: 01/06/2017 setText manquant

            createUser.setVisibility(View.VISIBLE);
            rep.setVisibility(View.VISIBLE);
            searchName.setVisibility(View.INVISIBLE);
            repByName.setVisibility(View.VISIBLE);
            okByName.setVisibility(View.INVISIBLE);
            listContacts.setVisibility(View.VISIBLE);
        }
    }
}