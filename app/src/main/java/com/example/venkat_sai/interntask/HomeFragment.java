package com.example.venkat_sai.interntask;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.fragment_home, container, false);

//        VideoView view = (VideoView)rootview.findViewById(R.id.videoview);
//        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.videofile;
//        view.setVideoURI(Uri.parse(path));
//        view.start();
        return rootview;
    }

}
