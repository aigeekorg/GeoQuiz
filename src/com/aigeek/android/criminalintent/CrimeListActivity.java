package com.aigeek.android.criminalintent;

import android.support.v4.app.Fragment;

public class CrimeListActivity extends SingleFragmentActivity {

	//����̳���һ�������࣬�ͱ���ʵ�ָó������еĳ��󷽷���
	//�����������CrimeListActivity���̳еĳ�������SingleFragmentActivity��
	//���Բ鿴�ó������еĳ��󷽷��� protected abstract Fragment createFragment();
	//���Խ����÷���ʱ����ѡabstract��ѡ�ø��࣬����������ʱ���Զ�������ʵ�ָó��󷽷��ķ�����
	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return new CrimeListFragment();
	}

}
