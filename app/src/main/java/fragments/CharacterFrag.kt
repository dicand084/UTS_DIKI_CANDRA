package fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Intents
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uts_botnavrecview.*


class CharacterFrag : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: CharactersAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var charArrayList: ArrayList<Characters>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvChar)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharactersAdapter(charArrayList){
        val intent = Intent(context,DetailCharacterActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        charArrayList = arrayListOf<Characters>()

        image = arrayOf(
            R.drawable.alpukat,
            R.drawable.anggur,
            R.drawable.apel,
            R.drawable.durian,
            R.drawable.jambu,
            R.drawable.jeruk,
            R.drawable.leci,
            R.drawable.pepaya,
            R.drawable.pisang,
            R.drawable.semangka,
        )

        title = arrayOf(
            getString(R.string.Alpukat),
            getString(R.string.Anggur),
            getString(R.string.Apel),
            getString(R.string.Durian),
            getString(R.string.Jambu),
            getString(R.string.Jeruk),
            getString(R.string.Leci),
            getString(R.string.Pepaya),
            getString(R.string.Pisang),
            getString(R.string.Semangka),

        )
        description = arrayOf(
            getString(R.string.desc_alpukat),
            getString(R.string.desc_anggur),
            getString(R.string.desc_apel),
            getString(R.string.desc_durian),
            getString(R.string.desc_jambu),
            getString(R.string.desc_jeruk),
            getString(R.string.desc_leci),
            getString(R.string.desc_pepaya),
            getString(R.string.desc_pisang),
            getString(R.string.desc_semangka),
        )

        for (i in image.indices) {
            val char = Characters(image[i], title[i], description[i])
            charArrayList.add(char)
        }

    }
}
