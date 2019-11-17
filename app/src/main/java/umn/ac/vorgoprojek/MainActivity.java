package umn.ac.vorgoprojek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import umn.ac.vorgoprojek.fragment.ChatFragment;
import umn.ac.vorgoprojek.fragment.FriendFragment;
import umn.ac.vorgoprojek.fragment.MoreFragment;
import umn.ac.vorgoprojek.fragment.ProjectFragment;
import umn.ac.vorgoprojek.fragment.TaskFragment;

//joe
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new ProjectFragment());

        BottomNavigationView btmNavView = findViewById(R.id.bn_main);

        btmNavView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.chat_menu:
                fragment = new ChatFragment();
                break;

            case R.id.friend_menu:
                fragment = new FriendFragment();
                break;
            case R.id.project_menu:
                fragment = new ProjectFragment();
                break;
            case R.id.task_menu:
                fragment= new TaskFragment();
                break;
            case R.id.more_menu:
                fragment= new MoreFragment();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
            return true;
        }

        return false;
    }
}
