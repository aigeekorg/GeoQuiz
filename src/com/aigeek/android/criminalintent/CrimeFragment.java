package com.aigeek.android.criminalintent;

import java.util.UUID;

import com.aigeek.android.criminalintent.R.string;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class CrimeFragment extends Fragment {
	public static final String EXTRA_CRIME_ID = 
			"com.aigeek.android.criminalinatent.crime_id";
	private Crime mCrime;
	private EditText mTitleField;
	private Button mDateButton;
	private CheckBox mSolvedCheckBox;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//为UUID定义并赋值，确保其唯一性
//		UUID crimeId = (UUID)getActivity().getIntent()
//				.getSerializableExtra(EXTRA_CRIME_ID);
		
		
		//从Fragment类的getArguments()方法和Bundle方法中获取argument
		UUID crimeId = (UUID)getArguments().getSerializable(EXTRA_CRIME_ID);
		
		mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
		
//		mCrime = new Crime();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_crime, parent, false);
		
		mTitleField = (EditText)v.findViewById(R.id.crime_title);
		
		mTitleField.setText(mCrime.getTitle());
		
		mTitleField.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				// TODO Auto-generated method stub
				//调用mCrime自写的类中设置标题的方法
				mCrime.setTitle(c.toString());
			}
			@Override
			public void beforeTextChanged(CharSequence c, int start, int count, int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable c) {
				// TODO Auto-generated method stub
				
			}
		});
		mDateButton = (Button)v.findViewById(R.id.crime_date);
		mDateButton.setText(mCrime.getDate().toString());
		mDateButton.setEnabled(false);
		
		mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
		
		mSolvedCheckBox.setChecked(mCrime.isSolved());
		
		mSolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				mCrime.setSolved(isChecked);
			}
		});
		
		
		return v;
	}


	/**
	 * 该方法用于创建用于保存UUID的 argument bundle方法，
	 * 每一个fragment实例都可以带一个Bundle对象，bundle对象可包含多个key-value对象，
	 * 每一个key-value对象即为一个argument
	 * @param crimeIdkey-value对象
	 * @return fragment
	 */
	public static CrimeFragment newInstance(UUID crimeId) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_CRIME_ID, crimeId);
		
		CrimeFragment fragment = new CrimeFragment();
		fragment.setArguments(args);
		
		return fragment;
		
	}

}
