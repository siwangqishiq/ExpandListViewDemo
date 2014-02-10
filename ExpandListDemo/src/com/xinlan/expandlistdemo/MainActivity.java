package com.xinlan.expandlistdemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ExpandableListView mExpandListView;

	private List<String> GroupData;// ����������
	private List<List<String>> ChildrenData;// �������е�������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mExpandListView = (ExpandableListView) findViewById(R.id.myExpandableListView);
		LoadListDate();
		mExpandListView.setAdapter(new ExpandableAdapter());
	}

	private class ExpandableAdapter extends BaseExpandableListAdapter {
		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return ChildrenData.get(groupPosition).get(childPosition);
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return 0;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			TextView myText = null;
			if (convertView != null) {
				myText = (TextView) convertView;
				myText.setText(ChildrenData.get(groupPosition).get(
						childPosition));
			} else {
				myText = createView(ChildrenData.get(groupPosition).get(
						childPosition));
			}
			return myText;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return ChildrenData.get(groupPosition).size();
		}

		@Override
		public Object getGroup(int groupPosition) {
			return GroupData.get(groupPosition);
		}

		@Override
		public int getGroupCount() {
			return GroupData.size();
		}

		@Override
		public long getGroupId(int groupPosition) {
			return 0;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			TextView myText = null;
			if (convertView != null) {
				myText = (TextView) convertView;
				myText.setText(GroupData.get(groupPosition));
			} else {
				myText = createView(GroupData.get(groupPosition));
			}
			return myText;
		}

		@Override
		public boolean hasStableIds() {
			return false;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return false;
		}

		private TextView createView(String content) {
			AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
					ViewGroup.LayoutParams.FILL_PARENT, 80);
			TextView myText = new TextView(MainActivity.this);
			myText.setLayoutParams(layoutParams);
			myText.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			myText.setPadding(80, 0, 0, 0);
			myText.setText(content);
			return myText;
		}
	} // end  inner class

	private void LoadListDate() {
		GroupData = new ArrayList<String>();
		GroupData.add("����");
		GroupData.add("����");
		GroupData.add("����");

		ChildrenData = new ArrayList<List<String>>();
		List<String> Child1 = new ArrayList<String>();
		Child1.add("���");
		Child1.add("κ��");
		Child1.add("���");
		ChildrenData.add(Child1);
		List<String> Child2 = new ArrayList<String>();
		Child2.add("����");
		Child2.add("�ŷ�");
		Child2.add("��Τ");
		Child2.add("����");
		Child2.add("�ܲ�");
		Child2.add("����");
		Child2.add("����");
		Child2.add("���");
		ChildrenData.add(Child2);
		List<String> Child3 = new ArrayList<String>();
		Child3.add("�������µ�");
		Child3.add("�ɰ���ìǹ");
		Child3.add("��ֽ�");
		Child3.add("���빭");
		Child3.add("����ǹ");
		ChildrenData.add(Child3);
	}
}// end class
