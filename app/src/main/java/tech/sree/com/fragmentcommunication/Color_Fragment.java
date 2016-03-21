package tech.sree.com.fragmentcommunication;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Created by ananth on 3/19/2016.
 */
public class Color_Fragment extends Fragment {
    RadioGroup radioGroup;
    EditText sendInfo;
    Button submit;
    ColorChangeListener colorChangeListener;
    SendInfoListener sendInfoListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.color_fragment,container,false);
        sendInfo = (EditText)view.findViewById(R.id.inText);
        submit = (Button)view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Data =  sendInfo.getText().toString();
                sendInfoListener.Send_update_Info(Data);

            }
        });
        radioGroup =  (RadioGroup) view.findViewById(R.id.fr_radioG);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.red:
                        colorChangeListener.colorChanged("RED");
                        break;
                    case R.id.green:
                        colorChangeListener.colorChanged("GREEN");
                        break;
                    case R.id.blue:
                        colorChangeListener.colorChanged("BLUE");
                        break;
                }

            }
        });
        return view;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            colorChangeListener = (ColorChangeListener)activity;
            sendInfoListener =(SendInfoListener)activity;

        }
        catch (Exception ex){}
    }

    public interface  SendInfoListener{
        public void Send_update_Info(String Data);

    }    public interface  ColorChangeListener{
        public void colorChanged(String color);

    }


}
