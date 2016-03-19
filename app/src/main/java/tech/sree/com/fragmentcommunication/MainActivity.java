package tech.sree.com.fragmentcommunication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements Color_Fragment.ColorChangeListener{
LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout)findViewById(R.id.mainAct);
        Color_Fragment color_fragment = new Color_Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fr_container,color_fragment);
        fragmentTransaction.commit();
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
}
