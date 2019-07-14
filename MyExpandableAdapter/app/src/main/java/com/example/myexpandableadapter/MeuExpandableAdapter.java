package com.example.myexpandableadapter;

import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class MeuExpandableAdapter implements ExpandableListAdapter {

    private Map<String, List<String>> dados;
    private List<String> keys;

    public MeuExpandableAdapter(Map<String, List<String>> dados) {
        this.dados = dados;
        this.keys = new ArrayList<>(dados.keySet());
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getGroupCount() {
        return dados.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return dados.get(keys.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return keys.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return dados.get(keys.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        if (view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_expandable_list_item_1,null);
        }
        TextView txt = view.findViewById(android.R.id.text1);
        txt.setTextColor(Color.WHITE);
        txt.setBackgroundColor(Color.GRAY);
        txt.setText(keys.get(i));

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        if (view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_expandable_list_item_1,null);
        }
        TextView txt = view.findViewById(android.R.id.text1);
        txt.setText(dados.get(keys.get(i)).get(i1));

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int i) {

    }

    @Override
    public void onGroupCollapsed(int i) {

    }

    @Override
    public long getCombinedChildId(long l, long l1) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long l) {
        return 0;
    }
}