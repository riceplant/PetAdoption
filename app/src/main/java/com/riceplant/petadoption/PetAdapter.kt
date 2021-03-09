package com.riceplant.petadoption

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.riceplant.petadoption.data.Pet

class PetAdapter(private val mPets: List<Pet>) : RecyclerView.Adapter<PetAdapter.PetViewholder>() {

    inner class PetViewholder(view: View) : RecyclerView.ViewHolder(view) {
        private val petImageView: ImageView = view.findViewById(R.id.pet_image)
        private val nameTextView: TextView = view.findViewById(R.id.pet_name)
        private val breedTextView: TextView = view.findViewById(R.id.pet_breed)
        private val sexTextView: TextView = view.findViewById(R.id.pet_sex)
        private val descriptionTextView: TextView = view.findViewById(R.id.pet_description)
        private var currentPet: Pet? = null

        fun bind(pet: Pet) {
            currentPet = pet

            petImageView.setImageResource(pet.photo)
            nameTextView.text = pet.name
            breedTextView.text = pet.breed
            sexTextView.text = pet.sex
            descriptionTextView.text = pet.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetAdapter.PetViewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return PetViewholder(view)
    }

    override fun getItemCount(): Int {
        return mPets.size
    }

    override fun onBindViewHolder(holder: PetViewholder, position: Int) {
        val pet = mPets.get(position)
        holder.bind(pet)
    }
}
