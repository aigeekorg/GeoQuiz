package com.aigeek.android.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

import android.R.integer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class CrimePagerActivity extends FragmentActivity{
	private ViewPager mViewPager;
	private ArrayList<Crime> mCrimes;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//新建viewPager实例
		mViewPager = new ViewPager(this);
		mViewPager.setId(R.id.viewPager);
		setContentView(mViewPager);
		
		//viewPager借助于PagerAdapter提供视图
		
		mCrimes = CrimeLab.get(this).getCrimes();
		
		FragmentManager fm = getSupportFragmentManager();
		mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mCrimes.size();
			}
			
			@Override
			public Fragment getItem(int pos) {
				// TODO Auto-generated method stub
				Crime crime = mCrimes.get(pos);
				return CrimeFragment.newInstance(crime.getId());
			}
		});
		
		
		/**
		 * 将标题栏/操作栏显示为当前的Itme名称
		 */
		
		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			
			//当前页面所处的行为状态
			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
				
			}
			
			
			//此方法可以告诉我们页面会滑向哪里
			@Override
			public void onPageScrolled(int pos, float posOffset, int posOffsetPixels) {
				// TODO Auto-generated method stub
				
			}	
			
			//哪一个页面被选中
			@Override
			public void onPageSelected(int pos) {
				// TODO Auto-generated method stub
				Crime crime = mCrimes.get(pos);
				if(crime.getTitle() != null){
					setTitle(crime.getTitle());
				}
			}

			

		});
		
		
		/**
		 * 设置初始分页显示项
		 */
		
		UUID crimeId = (UUID)getIntent()
				.getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);

		for(int i = 0; i < mCrimes.size(); i++){
			if(mCrimes.get(i).getId().equals(crimeId)){
				mViewPager.setCurrentItem(i);
				break;
			}
		}
		
	}
	
	
}
