package gh.out386.helppager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.ArrayList;

import gh.out386.helppager.models.HelpItem;

public class HelpPagerFragment extends Fragment {
    private static final String ARG_LIST = "list";
    private ArrayList<HelpItem> items;

    public HelpPagerFragment() {
    }

    public static HelpPagerFragment newInstance(ArrayList<HelpItem> items) {
        HelpPagerFragment fragment = new HelpPagerFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_LIST, items);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            items = (ArrayList<HelpItem>) getArguments().getSerializable(ARG_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_help_pager, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.help_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ItemAdapter<HelpItem> itemAdapter = new ItemAdapter<>();
        FastAdapter fastAdapter = FastAdapter.with(itemAdapter);
        recyclerView.setAdapter(fastAdapter);
        itemAdapter.add(items);
        return v;
    }

}
