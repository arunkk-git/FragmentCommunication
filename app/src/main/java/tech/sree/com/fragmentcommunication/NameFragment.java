package tech.sree.com.fragmentcommunication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ananth on 3/20/2016.
 */
public class NameFragment extends Fragment {
TextView receivedData;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view =    inflater.inflate(R.layout.name, container, false);
        receivedData = (TextView)view.findViewById(R.id.fr2);
        return  view ;
    }

    public void GetInfoFromOtherFragmet( String Data){
receivedData.setText("Info from Other Fragment : \n "+Data);

    }
}
