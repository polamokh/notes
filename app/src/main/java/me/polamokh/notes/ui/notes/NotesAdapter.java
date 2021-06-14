package me.polamokh.notes.ui.notes;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import me.polamokh.notes.databinding.ItemNoteBinding;
import me.polamokh.notes.model.Note;

public class NotesAdapter extends ListAdapter<Note, NotesAdapter.NotesViewHolder> {

    protected NotesAdapter() {
        super(new DiffUtil.ItemCallback<Note>() {
            @Override
            public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NotesViewHolder.from(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Note note = getItem(position);
        holder.bind(note);
    }

    static class NotesViewHolder extends RecyclerView.ViewHolder {

        private final ItemNoteBinding itemNoteBinding;

        public NotesViewHolder(ItemNoteBinding itemNoteBinding) {
            super(itemNoteBinding.getRoot());
            this.itemNoteBinding = itemNoteBinding;
        }

        public void bind(Note note) {
            itemNoteBinding.setNote(note);
            itemNoteBinding.executePendingBindings();
        }

        public static NotesViewHolder from(ViewGroup parent) {
            ItemNoteBinding binding = ItemNoteBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent, false
            );
            return new NotesViewHolder(binding);
        }
    }
}
