package umn.ac.vorgoprojek.Feature_MyTask;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import umn.ac.vorgoprojek.R;

public class Mytask_actv extends AppCompatActivity {
    SpaceNavigationView navigationView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        navigationView = findViewById(R.id.space);
        navigationView.initWithSaveInstanceState(savedInstanceState);

        navigationView.addSpaceItem(new SpaceItem("project", R.drawable.ic_chat_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_friends_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_collections_bookmark_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_more_vert_black_24dp));

        navigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {

                navigationView.setCentreButtonSelectable(true);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {

            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });
    }
}
