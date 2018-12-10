package saeed.example.com.instamorning;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileTap extends Fragment {

    EditText edtProfileName, edtProfileBio, edtProfileProfession, edtProfileHobbies, edtProfileFavoriteSport;
    Button btnUpdateInfo;



    public ProfileTap() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate( R.layout.fragment_profile_tap, container, false );
        //similar to container

        edtProfileName = view.findViewById( R.id.edtProfileName );
        edtProfileBio = view.findViewById( R.id.edtProfileBio );
        edtProfileProfession = view.findViewById( R.id.edtProfileProfession );
        edtProfileHobbies = view.findViewById( R.id.edtProfileHobbies );
        edtProfileFavoriteSport = view.findViewById( R.id.edtProfileFavoriteSport );

        final ParseUser currentUser = ParseUser.getCurrentUser();

        if(currentUser.get( "Bio" )==null )
        {
            edtProfileBio.setText( "" );

        }
        else
        {

            edtProfileBio.setText( currentUser.get( "Bio" )+"" );
        }





        edtProfileFavoriteSport.setText( currentUser.get( "FavoriteSport" )+"" );
        edtProfileHobbies.setText( currentUser.get( "Hobbies" )+"" );
        edtProfileProfession.setText( currentUser.get( "Profession" )+"" );
        edtProfileName.setText( currentUser.get( "PofileName" )+"" );



        view.findViewById( R.id.btn ).setOnClickListener( new View.OnClickListener() {
           @Override
           public void onClick(View v) {



               currentUser.put( "PofileName", edtProfileName.getText().toString() );
               currentUser.put( "Bio", edtProfileBio.getText().toString() );
               currentUser.put( "Profession", edtProfileProfession.getText().toString() );
               currentUser.put( "Hobbies",edtProfileHobbies.getText().toString() );
               currentUser.put( "FavoriteSport", edtProfileFavoriteSport.getText().toString() );
               currentUser.saveInBackground( new SaveCallback() {
                   @Override
                   public void done(ParseException e) {
                       if (e == null) {
                           Toast.makeText( getContext(), "updated", Toast.LENGTH_LONG ).show();
                       } else {
                           Toast.makeText( getContext(), "not updated", Toast.LENGTH_LONG ).show();

                       }
                   }
               } );

           }
       } );






        return view;


    }

}
