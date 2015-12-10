package com.aigeek.android.criminalintent;

import android.R.anim;
import android.app.AlertDialog;
import android.app.Dialog;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;

public class DatePickerFragment extends DialogFragment {

	String TAG = CrimeFragment.TAG;
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		View v = getActivity().getLayoutInflater()
				.inflate(R.layout.dialog_date, null);
		Log.i(TAG, "创建了对话框");
		
		
		// TODO Auto-generated method stub
		return new AlertDialog.Builder(getActivity())
				.setView(v)
				.setTitle(R.string.date_picker_title)
				.setPositiveButton(android.R.string.ok, null)
				.create();

	}
	
}
