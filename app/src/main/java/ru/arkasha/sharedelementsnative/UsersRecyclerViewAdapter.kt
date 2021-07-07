package ru.arkasha.sharedelementsnative

import android.view.View
import android.widget.TextView
import androidx.core.view.ViewCompat
import ru.arkasha.sharedelementsnative.base.SingleViewHolderRecyclerViewAdapter
import ru.arkasha.sharedelementsnative.base.glide.GlideApp
import ru.arkasha.sharedelementsnative.data.User

class UsersRecyclerViewAdapter : SingleViewHolderRecyclerViewAdapter<User>() {

    override val viewHolderLayoutId: Int = R.layout.i_user

    var onClicked: (View, User) -> Unit = { _, _ -> }


    override fun bindModel(holder: ViewHolder, model: User) {
        with(holder.itemView) {
            GlideApp.with(context)
                .load(model.avatar)
                .centerCrop()
                .placeholder(R.drawable.gitlab)
                .error(R.drawable.gitlab)
                .fallback(R.drawable.gitlab)
                .into(findViewById(R.id.ivAvatar))

            ViewCompat.setTransitionName(findViewById(R.id.ivAvatar), model.id)

            findViewById<TextView>(R.id.tvName).text = model.name

            setOnClickListener { onClicked(this, model) }
        }
    }
}