package com.fdanielpm.petagram;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fdanielpm.petagram.adapters.PageAdapter;
import com.fdanielpm.petagram.adapters.PetAdapter;
import com.fdanielpm.petagram.fragments.PerfilFragment;
import com.fdanielpm.petagram.fragments.RecyclerViewFragment;
import com.fdanielpm.petagram.pojo.Pet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private static String accountId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =  (Toolbar) findViewById(R.id.idToolbar);
        tabLayout =  (TabLayout) findViewById(R.id.tabLayout);
        viewPager =  (ViewPager) findViewById(R.id.viewPager);

        if(  getIntent() != null && getIntent().getExtras()!=null ) {
            Bundle extras = getIntent().getExtras();
            accountId = extras.getString("instagram_account_id");
        }else {
            accountId = readAccountInfo();
        }
        if( accountId !=null && !accountId.isEmpty() ) {
            Toast.makeText(this, "Account:" + accountId, Toast.LENGTH_SHORT).show();
        }

        setUpViewPager();

        if( toolbar!=null){
            setSupportActionBar(toolbar);
        }


    }

    private void setUpViewPager(){

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add( new RecyclerViewFragment() );
        fragments.add( new PerfilFragment() );

        viewPager.setAdapter( new PageAdapter( getSupportFragmentManager(), fragments ) );
        tabLayout.setupWithViewPager( viewPager );
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_perfil);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mAbout:
                Intent intentMail = new Intent(this, MailActivity.class);
                startActivity(intentMail);
                break;
            case R.id.mContact:
                 Intent intentBio = new Intent(this, BioActivity.class);
                 startActivity(intentBio);
                break;
            case R.id.mStar:
                List<Pet> mascotas = new ArrayList<>();

                mascotas.add( new Pet("1","Scoby Doo",R.drawable.dog01,1) );
                mascotas.add( new Pet("2","Benji",R.drawable.dog02,3) );
                mascotas.add( new Pet("3","Pulgoso",R.drawable.dog03,0) );
                mascotas.add( new Pet("4","Odie",R.drawable.dog04,5) );
                mascotas.add( new Pet("5","Snoppy",R.drawable.dog05,2) );
                mascotas.add( new Pet("6","Beethoven",R.drawable.dog06,2) );

                if( mascotas !=null && !mascotas.isEmpty() ){
                    Pet max = mascotas.get(0);
                    for(Pet p: mascotas ){
                        if( p.getLikes() >  max.getLikes() ){
                            max = p;
                        }
                    }
                    if( max == null ){
                        max = new Pet("1","Scoby Doo",R.drawable.dog01,1);
                    }
                    Intent intentFav = new Intent(this,MascotaFavorita.class);
                    intentFav.putExtra("name",max.getName());
                    intentFav.putExtra("photo", max.getPhoto() );
                    intentFav.putExtra("likes",  max.getLikes() );
                    this.startActivity( intentFav );

                }

                break;
            case R.id.mAccount:
                Intent intentAccount = new Intent(this, AccountActivity.class);
                startActivity(intentAccount);
                break;
            case R.id.mNotificaciones:
                Intent intentNotificacion = new Intent(this, NotificacionActivity.class);
                intentNotificacion.putExtra("instagram_account_id",accountId);
                startActivity(intentNotificacion);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private String readAccountInfo(){
        String account = null;
        try {
            FileInputStream in = openFileInput("account.txt");
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(in) );
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            account = sb.toString();
        }catch (Exception e){

        }
        return account;
    }

    public static String getAccountId(){
        return accountId;
    }
}
