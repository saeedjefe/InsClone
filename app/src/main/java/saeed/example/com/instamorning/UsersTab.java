package saeed.example.com.instamorning;


import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UsersTab extends Fragment {


    public UsersTab() {
        // Required empty public constructor
    }

    ListView lstView ;
    ArrayList arrayList;
    TextView txtView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate( R.layout.fragment_users_tab, container, false );

        txtView = view.findViewById(R.id.txtLoading  );


       lstView = view.findViewById( R.id.lstView );
       arrayList = new ArrayList(  );
        final ArrayAdapter arrayAdapter = new ArrayAdapter( getContext(), android.R.layout.simple_expandable_list_item_1, arrayList );


        ParseQuery<ParseUser> parseQuery = ParseUser.getQuery();


           parseQuery.whereNotEqualTo( "username",ParseUser.getCurrentUser().getUsername() );

           parseQuery.findInBackground( new FindCallback<ParseUser>() {
               @Override
               public void done(List<ParseUser> objects, ParseException e) {
                   if (e == null) {
                       if (objects.size() > 0) {
                           for (ParseUser users : objects) {
                               arrayList.add( users.getUsername() );
                           }

                           lstView.setAdapter( arrayAdapter );

                           txtView.animate().alpha( 0 );

                           lstView.setVisibility( View.VISIBLE );
                       }


                   }

               }
           } );











       return view;
    }

}
