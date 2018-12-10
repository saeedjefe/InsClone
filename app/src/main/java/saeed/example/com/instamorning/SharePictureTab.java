package saeed.example.com.instamorning;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;


/**
 * A simple {@link Fragment} subclass.
 */
public class SharePictureTab extends Fragment {


    public SharePictureTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate( R.layout.fragment_share_picture_tab, container, false );


//        .findViewById( R.id.txtTest ).setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ParseUser parseUser = ParseUser.getCurrentUser();
//
//                parseUser.put( "Hobby", "Swimming");
//
//                parseUser.saveEventually( new SaveCallback() {
//                    @Override
//                    public void done(ParseException e) {
//                        if(e==null)
//                        {
//                            Toast.makeText( getContext(), "updated", Toast.LENGTH_LONG ).show();
//                        }
//                        else
//                        {
//                            Toast.makeText( getContext(), "not updated", Toast.LENGTH_LONG ).show();
//
//                        }
//                    }
//                } );
//            }
//        } );





        return view;
    }

}
