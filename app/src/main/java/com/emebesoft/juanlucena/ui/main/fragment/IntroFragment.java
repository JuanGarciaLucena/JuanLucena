package com.emebesoft.juanlucena.ui.main.fragment;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.emebesoft.juanlucena.R;
import com.emebesoft.juanlucena.Utils.FirebaseUrl;
import com.emebesoft.juanlucena.databinding.FragmentIntroBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class IntroFragment extends Fragment {

    private FragmentIntroBinding fragmentIntroBinding;

    public IntroFragment() {}

    public static IntroFragment newInstance() {
        IntroFragment fragment = new IntroFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentIntroBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_intro, container, false);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("introduction").child("text");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Glide.with(getActivity()).load(FirebaseUrl.profilePictureURL).into(fragmentIntroBinding.ivProfile);

                if(Build.VERSION.SDK_INT < 24) {
                    fragmentIntroBinding.text.setText(Html.fromHtml(dataSnapshot.getValue().toString()));
                }else{
                    fragmentIntroBinding.text.setText(Html.fromHtml(dataSnapshot.getValue().toString(), Html.FROM_HTML_MODE_LEGACY));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getActivity(), "MAL", Toast.LENGTH_SHORT).show();
            }
        });


        return fragmentIntroBinding.getRoot();
    }
}
