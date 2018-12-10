package saeed.example.com.instamorning;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {


    public TabAdapter(FragmentManager fm) {
        super( fm );
    }

    @Override
    public Fragment getItem(int tapPosition) {

        switch (tapPosition)
        {
            case 0:
                ProfileTap profileTap = new ProfileTap();
                return profileTap;

            case 1:

                return new UsersTab();

            case 2:

                return new SharePictureTab();

                default:
                    return null;

        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position)
        {
            case 0:
                return "Profile";

            case 1:
                return "Users";
            case 2:
                return "Share Picture";

                default:
                    return null;
        }

    }
}
