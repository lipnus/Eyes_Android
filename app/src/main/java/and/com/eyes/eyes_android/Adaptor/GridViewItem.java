package and.com.eyes.eyes_android.Adaptor;

import android.content.Intent;
import android.net.Uri;

public class GridViewItem {
    public int id;
    public String imagePath;
    public String text;
    public Uri image;

    public GridViewItem(int id, String text) {
        this.id = id;
        this.text = text;
    }


}
