package com.aigeek.android.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.util.UUID;

import android.os.Bundle;


public class CrimeActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		
		//return new CrimeFragment();
		UUID crimeId = (UUID)getIntent()
				.getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		
		return CrimeFragment.newInstance(crimeId);
	}

}
