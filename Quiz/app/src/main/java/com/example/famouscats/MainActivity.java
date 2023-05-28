package com.example.famouscats;

import static com.example.famouscats.R.id.textFinish;
import static com.example.famouscats.R.id.textNum;


import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.InputStream;
import java.util.Random;

import android.widget.TextView;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private int selectedVariant=0;
    private int randomButton;


    //number of rightVariant equal number of Person
    //the array includes right variants which have already been for excluding right variants
    public int[] rightVariant;
    private ImageButton Quiz;

    private ImageButton Settings;
    private ImageButton Finish;
    private Button Variant1;
    private Button Variant2;
    private Button Variant3;
    private Button Variant4;
    // file with persons
    private String str;
    String [] strSplit;
    int o;
    int test;
    String test1= "";

    //number of questions!!!!!!!!!!!!!!!!!!!!!!!!LOOK AT CAREFULLY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private int N =55;
    //the arrays includes all person for quiz
    public CatPerson[] cats = new CatPerson[N];

    private View forSettings;

    private int iChangeWallpapers=0;



    //the method return random integer from some range
    public int getRandomWithExclusion(Random rnd, int start, int end, int... exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }
    //the method read txt file and add elements to  our array cats

    public void addElementsToArrayCats()  {

    //////////////////////////ЧТЕНИЕ ФАЙЛА СДЕЛАТЬ//////////////////////////////////////////////////
        try{
        InputStream inStr = getAssets().open("persons.txt");
        int size = inStr.available();
        byte[] buffer = new byte[size];
        inStr.read(buffer);
        str = new String(buffer);
        strSplit = str.split("\n");
        o = strSplit.length;
        N=o;

        for(int i = 0; i < o; i++) {
            String[] sHelp;
            sHelp = strSplit[i].split("\\|");
            //LOOK AT LAST STRING AT FILE!!!!!WARNING!!!!! \n should be last symbol at the string in person.txt
            cats[i] = new CatPerson(sHelp[0],sHelp[1], sHelp[2],sHelp[3].substring(0, sHelp[3].length() - 1));
            //test=sHelp[3].length();
            //test1 = sHelp[3];

        }
        List intList = Arrays.asList(cats);

        Collections.shuffle(intList);

        intList.toArray(cats);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        //cats[0] = new CatPerson("Кек","Лел","Мур");



    }
    int i = 0;
    int randI = 0;
    List<Integer> fill =  Arrays.asList(1, 2, 3, 4);


    int getRandFour() {
        Random dice = new Random();
        int randFour = getRandomWithExclusion(dice, 1, 4);


        //Collections.shuffle(fill);

        return randFour;

    }
    public void changeButtons() {


        randomButton = getRandFour();

        if (randomButton == 1) {

            Variant1.setText(cats[i].CatName);
            Random kek1 = new Random();
            int [] excl ;
            excl = new int[]{i};
            Arrays.sort(excl);
            int a1 = getRandomWithExclusion(kek1, 0, N-1, excl);
            Variant2.setText(cats[a1].CatName);
            excl = new int[]{i,a1};
            Arrays.sort(excl);
            int a2 = getRandomWithExclusion(kek1, 0, N-1, excl);
            Variant3.setText(cats[a2].CatName);
            excl = new int[]{i,a1,a2};
            Arrays.sort(excl);
            int a3 = getRandomWithExclusion(kek1, 0, N-1,excl);
            Variant4.setText(cats[a3].CatName);


        }
        if (randomButton == 2) {

            Variant2.setText(cats[i].CatName);
            Random kek2 = new Random();
            int [] excl ;
            excl = new int[]{i};
            Arrays.sort(excl);

            int a1 = getRandomWithExclusion(kek2, 0, N-1, excl);
            Variant1.setText(cats[a1].CatName);
            excl = new int[]{i,a1};
            Arrays.sort(excl);
            int a2 = getRandomWithExclusion(kek2, 0, N-1, excl);
            Variant3.setText(cats[a2].CatName);
            excl = new int[]{i,a1,a2};
            Arrays.sort(excl);
            int a3 = getRandomWithExclusion(kek2, 0, N-1,excl);
            Variant4.setText(cats[a3].CatName);

        }
        if (randomButton == 3) {

            Variant3.setText(cats[i].CatName);
            Random kek3 = new Random();
            int [] excl ;
            excl = new int[]{i};
            Arrays.sort(excl);
            int a1 = getRandomWithExclusion(kek3, 0, N-1, excl);
            Variant1.setText(cats[a1].CatName);
            excl = new int[]{i,a1};
            Arrays.sort(excl);
            int a2 = getRandomWithExclusion(kek3, 0, N-1, excl);
            Variant2.setText(cats[a2].CatName);
            excl = new int[]{i,a1,a2};
            Arrays.sort(excl);
            int a3 = getRandomWithExclusion(kek3, 0, N-1,excl);
            Variant4.setText(cats[a3].CatName);


        }
        if (randomButton == 4) {

            Variant4.setText(cats[i].CatName);
            Random kek4 = new Random();
            int [] excl ;
            excl = new int[]{i};
            Arrays.sort(excl);
            int a1 = getRandomWithExclusion(kek4, 0, N-1, excl);
            Variant1.setText(cats[a1].CatName);
            excl = new int[]{i,a1};
            Arrays.sort(excl);
            int a2 = getRandomWithExclusion(kek4, 0, N-1, excl);
            Variant2.setText(cats[a2].CatName);
            excl = new int[]{i,a1,a2};
            Arrays.sort(excl);
            int a3 = getRandomWithExclusion(kek4, 0, N-1,excl);
            Variant3.setText(cats[a3].CatName);

        }
    }


    void changeImageAndTip(){
        String uri = "@drawable/" + cats[i].CatImage;  // where my resource (without the extension) is the file
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        ImageView imageCurrent = findViewById(R.id.imageView);
        Drawable res = getResources().getDrawable(imageResource);
        imageCurrent.setImageDrawable(res);
        //change Tip under the Image
        TextView view1 = (TextView) findViewById(R.id.textTip);
        TextView view2 =  (TextView) findViewById(textNum);
        view1.setText(cats[i].CatTip);
        view2.setText(Integer.toString(selectedVariant) + "|" + Integer.toString(i+1) + "|" + Integer.toString(N));
    }
    @SuppressLint("MissingInflatedId")
    void showResults(){
        //change status bar to black
        setContentView(R.layout.finish);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.black_1));
            TextView veiwFinish =(TextView) findViewById(textFinish);
            veiwFinish.setText("РЕЗУЛЬАТ\n"+Integer.toString(selectedVariant)+"|"+Integer.toString(N));
        }
        Finish = findViewById(R.id.butFinish);
        Finish.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                finish();
            }
        });
    }


    //starting app from main menu
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        }

        //quiz will be started after click "Приступить"
        Quiz = findViewById(R.id.Quiz);
        Quiz.setOnClickListener(new View.OnClickListener() {



            @SuppressLint("WrongViewCast")
            public void onClick(View view) {

                //change status bar to black
                setContentView(R.layout.quiz);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.black_1));
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.black_1));
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                }

                addElementsToArrayCats();

                //buttons in quiz
                Variant1 = findViewById(R.id.button1);
                Variant2 = findViewById(R.id.button2);
                Variant3 = findViewById(R.id.button3);
                Variant4 = findViewById(R.id.button4);


                changeImageAndTip();
                changeButtons();

                Settings = findViewById(R.id.Settings);

                Settings.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {

                        iChangeWallpapers++;

                        if(iChangeWallpapers==0) {

                            String uri2 = "@drawable/" + "red_wallpaper";  // where my resource (without the extension) is the file
                            int imageResource2 = getResources().getIdentifier(uri2, null, getPackageName());
                            ImageView imageCurrent2 = findViewById(R.id.imageBackground);
                            Drawable res = getResources().getDrawable(imageResource2);
                            imageCurrent2.setImageDrawable(res);
                        }

                        if(iChangeWallpapers==1) {

                            String uri2 = "@drawable/" + "blue_wallpaper";  // where my resource (without the extension) is the file
                            int imageResource2 = getResources().getIdentifier(uri2, null, getPackageName());
                            ImageView imageCurrent2 = findViewById(R.id.imageBackground);
                            Drawable res = getResources().getDrawable(imageResource2);
                            imageCurrent2.setImageDrawable(res);
                        }
                        if(iChangeWallpapers==2) {

                            String uri2 = "@drawable/" + "green_wallpaper";  // where my resource (without the extension) is the file
                            int imageResource2 = getResources().getIdentifier(uri2, null, getPackageName());
                            ImageView imageCurrent2 = findViewById(R.id.imageBackground);
                            Drawable res = getResources().getDrawable(imageResource2);
                            imageCurrent2.setImageDrawable(res);
                        }
                        if(iChangeWallpapers==3) {

                            String uri2 = "@drawable/" + "black_wallpaper";  // where my resource (without the extension) is the file
                            int imageResource2 = getResources().getIdentifier(uri2, null, getPackageName());
                            ImageView imageCurrent2 = findViewById(R.id.imageBackground);
                            Drawable res = getResources().getDrawable(imageResource2);
                            imageCurrent2.setImageDrawable(res);
                        }
                        if(iChangeWallpapers==4) {

                            String uri2 = "@drawable/" + "white_wallpaper";  // where my resource (without the extension) is the file
                            int imageResource2 = getResources().getIdentifier(uri2, null, getPackageName());
                            ImageView imageCurrent2 = findViewById(R.id.imageBackground);
                            Drawable res = getResources().getDrawable(imageResource2);
                            imageCurrent2.setImageDrawable(res);
                        }
                        if(iChangeWallpapers==5){
                            iChangeWallpapers=-1;
                        }
                    }
                });






                Variant1.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {

                            if (randomButton == 1) {

                                selectedVariant++;

                            }


                        if(i==N-1) {

                            i++;
                            showResults();

                        }else {

                            i++;
                            changeImageAndTip();
                            changeButtons();

                        }



                    }
                });

                Variant2 = findViewById(R.id.button2);
                Variant2.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {



                            if (randomButton == 2) {

                                selectedVariant++;

                            }

                        if(i==N-1) {
                            i++;

                            showResults();

                        }else{

                            i++;
                            changeImageAndTip();
                            changeButtons();

                        }
                    }
                });


                Variant3.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {

                        if (randomButton == 3) {

                            selectedVariant++;

                        }

                        if (i == N - 1) {

                            i++;
                            showResults();

                        } else {

                            i++;
                            changeImageAndTip();
                            changeButtons();
                        }


                    }
                });



                Variant4.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view) {


                        if (randomButton == 4) {

                                selectedVariant++;

                        }


                        if(i==N-1) {

                            i++;
                            showResults();

                        }else{

                            i++;
                            changeImageAndTip();
                            changeButtons();

                        }

                    }
                });



            }



        });

    }



}
