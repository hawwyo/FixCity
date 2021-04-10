package ru.dropdatabase.fixcity.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import ru.dropdatabase.fixcity.GetPetitionInfoSingleton;
import ru.dropdatabase.fixcity.Petition;
import ru.dropdatabase.fixcity.PetitionHolder;
import ru.dropdatabase.fixcity.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        FirebaseRecyclerOptions<Petition> options =
                new FirebaseRecyclerOptions.Builder<Petition>()
                        .setQuery(GetPetitionInfoSingleton.getInstanceOf().getPetitionsWithoutComments(), Petition.class)
                        .build();



        FirebaseRecyclerAdapter<Petition, PetitionHolder> adapter = new FirebaseRecyclerAdapter<Petition, PetitionHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull PetitionHolder holder, int position, @NonNull Petition model) {
                holder.petition.setBackgroundImage( model.getImage() );
                if (holder.petition.getBackgroundImage() == null) {
                    holder.petition.setBackgroundImage(BitmapFactory.decodeResource( root.getResources(), R.drawable.rubbish ));
                }
                holder.petition.setTitle( model.getTitle() );
                holder.petition.setCntOfComments( model.getCntOfComments() );
                holder.petition.setCntOfLikes( model.getCntOfLikes() );
                holder.petition.setPetitionId( model.getId() );

                Log.d("mytag", "onBindViewHolder: ");
            }

            @NonNull
            @Override
            public PetitionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycler_item, parent, false);

                return new PetitionHolder(view);
            }
        };

        RecyclerView recyclerView = root.findViewById(R.id.first_screen_recycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(root.getContext()));

        adapter.startListening();

//        GetPetitionInfoSingleton.getInstanceOf().getPetitionsWithoutComments()
//            .addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot ds : snapshot.getChildren()) {
//                    Petition wi = ds.getValue(Petition.class);
//
//                    Log.d("mytag", wi.getTitle());
//                }
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        return root;
    }
}