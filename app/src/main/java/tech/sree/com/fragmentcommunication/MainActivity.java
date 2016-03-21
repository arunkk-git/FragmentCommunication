package tech.sree.com.fragmentcommunication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements Color_Fragment.SendInfoListener, Color_Fragment.ColorChangeListener /*,NameFragment.GetInfoFromOtherFragmet */{

    LinearLayout linearLayout;
String passingData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout)findViewById(R.id.mainAct);
//        Color_Fragment color_fragment = new Color_Fragment();
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.fr_container,color_fragment);
//        fragmentTransaction.commit();
    }

    @Override
    public void colorChanged(String color) {
        int color_ = 0;
        if(color.equals("RED"))
            color_ = Color.RED;
        if(color.equals("BLUE"))
            color_ = Color.BLUE;
        if(color.equals("GREEN"))
            color_ = Color.GREEN;

        linearLayout.setBackgroundColor(color_);
    }

    @Override
    public void Send_update_Info(String Data) {
        passingData =Data;
        Toast.makeText(getApplication(), "Data From Fr1 : " + Data, Toast.LENGTH_LONG).show();
        NameFragment nameFragment= (NameFragment)getFragmentManager().findFragmentById(R.id.fr21);
        nameFragment.GetInfoFromOtherFragmet(Data);
    }

}
