package umn.ac.vorgoprojek.Feature_Project;

import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.Exclude;
import java.util.HashMap;
import java.util.Map;

public class project {


    String edtTitle, color;
    public project() {

    }

    public String getEdtTitle() {
        return edtTitle;
    }

    public void setEdtTitle(String edtTitle) {
        this.edtTitle = edtTitle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("edtTitle", edtTitle);
        result.put("color", color);
        return result;
    }

}
