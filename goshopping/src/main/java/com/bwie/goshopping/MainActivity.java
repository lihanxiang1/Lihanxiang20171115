package com.bwie.goshopping;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bwie.goshopping.R;

import com.bwie.goshopping.fragment.Fragment4;

public class MainActivity extends AppCompatActivity {

    private RadioGroup group;
    private FragmentManager manager;
    private Fragment4 fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fuzhu_activity);

        group = (RadioGroup) findViewById(R.id.radio_group);
        manager = getSupportFragmentManager();
        fragment4 = new Fragment4();
        manager.beginTransaction().add(R.id.fragme_layout , fragment4).commit();

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentTransaction transaction = manager.beginTransaction();

                if (fragment4 != null){
                    transaction.hide(fragment4);
                }

                switch (i){
                    case R.id.button_homePage:
                        if (fragment4 == null){
                            fragment4 = new Fragment4();
                            transaction.add(R.id.fragme_layout , fragment4);
                        }else{
                            transaction.show(fragment4);
                        }
                        break;

                    default:
                        break;
                }
                transaction.commit();
            }
        });
    }
}
