package com.example.myapplication13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication13.network.APICleint

class ImageFragment : Fragment() {

   // private val retrofitViewModel: RetrofitViewModel by viewModels()
    private var productImage: MutableList<DataImage> = mutableListOf()
    private lateinit var adapter: MyAdapter2
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view2)
        adapter = MyAdapter2(productImage, requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val productsViewModelFactory = ProductsViewModelFactory(
            repo = ProductsRepositoryImpi(
                remoteDS = APICleint
            )
        )

        val retrofitViewModel = ViewModelProvider(this, productsViewModelFactory).get(
            RetrofitViewModel::class.java)

        val getPosition = arguments?.getInt("pos", 0) ?: 0
        retrofitViewModel.getAllProducts()
        retrofitViewModel.productList.observe(viewLifecycleOwner) { productsList ->
            val images = productsList.getOrNull(getPosition)?.images ?: emptyList()
            productImage.clear()
            productImage.addAll(images.map { DataImage(it) })
            adapter.notifyDataSetChanged()
        }
    }
}
