package umn.ac.vorgoprojek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import umn.ac.vorgoprojek.fragment.ChatFragment;
import umn.ac.vorgoprojek.Feature_FriendList.FriendFragment;
import umn.ac.vorgoprojek.Profile.MoreFragment;
import umn.ac.vorgoprojek.Feature_Project.ProjectFragment;
import umn.ac.vorgoprojek.Feature_MyTask.TaskFragment;

//joe
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private TextView txtTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new ProjectFragment());

        BottomNavigationView btmNavView = findViewById(R.id.bn_main);

        btmNavView.setOnNavigationItemSelectedListener(this);
        btmNavView.getMenu().findItem(R.id.project_menu).setChecked(true);
        txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText("Project");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        txtTitle = findViewById(R.id.txtTitle);
        switch (menuItem.getItemId()){
            case R.id.chat_menu:
                fragment = new ChatFragment();
                txtTitle.setText("Chat");
                break;

            case R.id.friend_menu:
                fragment = new FriendFragment();
                txtTitle.setText("Friend List");
                break;
            case R.id.project_menu:
                fragment = new ProjectFragment();
                txtTitle.setText("Project");
                break;
            case R.id.task_menu:
                fragment= new TaskFragment();
                txtTitle.setText("My Task");
                break;
            case R.id.more_menu:
                fragment= new MoreFragment();
                txtTitle.setText("More");
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
