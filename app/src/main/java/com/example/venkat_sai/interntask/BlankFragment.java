package com.example.venkat_sai.interntask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



public class BlankFragment extends Fragment {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<Announcement> arrayList;
    RecyclerView recyclerView;
    Context context;

    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    //    return inflater.inflate(R.layout.fragment_blank, container, false);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle("notifications");
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        final View rootview = inflater.inflate(R.layout.fragment_blank, container, false);
        arrayList = new ArrayList<>();
        context = getActivity();
        recyclerView = rootview.findViewById(R.id.announce);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseReference.child("notifications").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    if (dataSnapshot1.getChildrenCount() != 0)
                        arrayList.add(dataSnapshot1.getValue(Announcement.class));
                }
                recyclerView.setAdapter(new AnnouncementAdapter(arrayList));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return rootview;
    }



}
