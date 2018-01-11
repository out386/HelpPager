package gh.out386.helppager.models;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.io.Serializable;
import java.util.List;

import gh.out386.helppager.R;

public class HelpItem extends AbstractItem<HelpItem, HelpItem.ViewHolder> implements Serializable {

    private static final long serialVersionUID = 1L;
    private String itemName;
    private String itemText;

    private HelpItem(Builder builder) {
        itemName = builder.itemName;
        itemText = builder.itemText;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemText() {
        return itemText;
    }

    @Override
    public int getType() {
        return R.id.help_item;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_help;
    }

    @Override
    public ViewHolder getViewHolder(@NonNull View v) {
        return new ViewHolder(v);
    }

    protected static class ViewHolder extends FastAdapter.ViewHolder<HelpItem> {
        TextView name;
        TextView text;

        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.hpg_item_name);
            text = view.findViewById(R.id.hpg_item_text);
        }

        @Override
        public void bindView(HelpItem item, List<Object> payloads) {
            name.setText(item.getItemName());
            text.setText(item.getItemText());
        }

        @Override
        public void unbindView(HelpItem item) {
            name.setText(null);
            text.setText(null);
        }
    }

    public static class Builder {

        private String itemName;
        private String itemText;

        public Builder withName(String name) {
            this.itemName = name;
            return this;
        }

        public Builder withText(String text) {
            this.itemText = text;
            return this;
        }

        public HelpItem build() {
            return new HelpItem(this);
        }
    }
}
