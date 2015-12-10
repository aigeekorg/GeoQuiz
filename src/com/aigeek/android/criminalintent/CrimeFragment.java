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
		
		//ΪUUID���岢��ֵ��ȷ����Ψһ��
//		UUID crimeId = (UUID)getActivity().getIntent()
//				.getSerializableExtra(EXTRA_CRIME_ID);
		
		
		//��Fragment���getArguments()������Bundle�����л�ȡargument
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
				//����mCrime��д���������ñ���ķ���
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
	 * �÷������ڴ������ڱ���UUID�� argument bundle������
	 * ÿһ��fragmentʵ�������Դ�һ��Bundle����bundle����ɰ������key-value����
	 * ÿһ��key-value����Ϊһ��argument
	 * @param crimeIdkey-value����
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
