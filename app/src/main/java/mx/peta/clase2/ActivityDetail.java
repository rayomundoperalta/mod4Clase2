package mx.peta.clase2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mx.peta.clase2.fragment.FragmentList;
import mx.peta.clase2.fragment.FragmentProfile;

/**
 * Created by rayo on 6/12/16.
 */
public class ActivityDetail extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_detail);
        String userName = getIntent().getExtras().getString("key_user");
        String hello = String.format(getString(R.string.hello), userName);
        findViewById(R.id.btnFragmentA).setOnClickListener(this);
        findViewById(R.id.btnFragmentB).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnFragmentA:
                changeFragmentA();
                break;
            case R.id.btnFragmentB:
                changeFragmentB();
                break;
        }
    }

    private void changeFragmentA() {
        FragmentProfile f = FragmentProfile.newInstance(" Hola mundo");
        getFragmentManager().beginTransaction().replace(R.id.fragmentHolder, f).commit();
    }

    private void changeFragmentB() {
        getFragmentManager().beginTransaction().replace(R.id.fragmentHolder, new FragmentList()).commit();
        // FragmentList f = new FragmentList();
        //getFragmentManager().beginTransaction().replace(R.id.fragment_xml,f).commit();
    }
}
