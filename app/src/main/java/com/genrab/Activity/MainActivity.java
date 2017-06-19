package com.genrab.Activity;

import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.genrab.Fragment.FragmentAddFund;
import com.genrab.Fragment.FragmentBingo;
import com.genrab.Fragment.FragmentDashBoard;
import com.genrab.Fragment.FragmentManage;
import com.genrab.Fragment.FragmentMyAccount;
import com.genrab.Fragment.FragmentInvestment;
import com.genrab.Fragment.FragmentNetwork;
import com.genrab.Fragment.FragmentRequest;
import com.genrab.Fragment.FragmentSetting;
import com.genrab.Fragment.FragmentState;
import com.genrab.R;
import com.genrab.Untils.Credentials;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager;
    LinearLayout addfundLinearLayout, bingoLinearLayout, investLinearLayout, widthLinearLayout;
    Toolbar toolbar;
    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FragmentManager
        fragmentManager = getSupportFragmentManager();
        //Open dash Board Here first
        FragmentDashBoard fragmentDashBoard = new FragmentDashBoard();
        InflateFragment(fragmentDashBoard);
        //End
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Genrab");
        setSupportActionBar(toolbar);
        setTitle("");


        //Widget grtting method
        init();
        //Click Listener method
        listener();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {
            FragmentDashBoard fragmentDashBoard = new FragmentDashBoard();
            InflateFragment(fragmentDashBoard);
            setTitle("");
            mTitle.setText("DashBoard");
        } else if (id == R.id.nav_addInvest) {
            FragmentInvestment fragmentInvestment = new FragmentInvestment();
            InflateFragment(fragmentInvestment);
            setTitle("");
            mTitle.setText("Add Investments");

        } else if (id == R.id.nav_myaccount) {
            FragmentMyAccount fragmentmyaccount = new FragmentMyAccount();
            InflateFragment(fragmentmyaccount);
            setTitle("");
            mTitle.setText("My Account");

        } else if (id == R.id.nav_network) {
            FragmentNetwork fragmentNetwork = new FragmentNetwork();
            InflateFragment(fragmentNetwork);
            setTitle("");
            mTitle.setText("Network Info");
        } else if (id == R.id.nav_manage) {
            FragmentManage fragmentManage = new FragmentManage();
            InflateFragment(fragmentManage);
            setTitle("");
            mTitle.setText("Manage Withdrawals");

        } else if (id == R.id.nav_statement) {
            FragmentState fragmentState = new FragmentState();
            InflateFragment(fragmentState);
            setTitle("");
            mTitle.setText("Statement");

        } else if (id == R.id.nav_setting) {
            FragmentSetting fragmentSetting = new FragmentSetting();
            InflateFragment(fragmentSetting);
            setTitle("");
            mTitle.setText("Account Setting");
        } else if (id == R.id.nav_faq) {

        } else if (id == R.id.nav_term) {

        } else if (id == R.id.nav_rate) {

        } else if (id == R.id.nav_logout) {
            Credentials.logout(MainActivity.this);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


    private void init() {
        //LinearLayout
        addfundLinearLayout = (LinearLayout) findViewById(R.id.layAddFund);
        bingoLinearLayout = (LinearLayout) findViewById(R.id.layBingo);
        investLinearLayout = (LinearLayout) findViewById(R.id.layInvestment);
        widthLinearLayout = (LinearLayout) findViewById(R.id.layWidth);

    }

    private void listener() {
        addfundLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentAddFund fragmentAddFund = new FragmentAddFund();
                InflateFragment(fragmentAddFund);
                mTitle.setText("Add Funds");
            }
        });
        bingoLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentBingo fragmentBingo = new FragmentBingo();
                InflateFragment(fragmentBingo);
                mTitle.setText("My Bingo");
            }
        });

        investLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentInvestment fragmentInvestment = new FragmentInvestment();
                InflateFragment(fragmentInvestment);
                mTitle.setText("Add Investments");
            }
        });
        widthLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentRequest fragmentRequest = new FragmentRequest();
                InflateFragment(fragmentRequest);
                mTitle.setText("Request Withdrawal");

            }
        });


    }

    /*********************************
     * inflate fragments
     *****************************/
    public void InflateFragment(Fragment frg) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, frg);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}
