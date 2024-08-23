package com.example.myapplication13

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication13.network.APICleint

class MainFragment : Fragment() {

    private var productData: MutableList<ProductData> = mutableListOf()
    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        adapter = MyAdapter(productData, requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val productsViewModelFactory = ProductsViewModelFactory(
            repo = ProductsRepositoryImpi(
                remoteDS = APICleint
            )
        )
        val retrofitViewModel = ViewModelProvider(this, productsViewModelFactory).get(
            RetrofitViewModel::class.java)
        retrofitViewModel.getAllProducts()
        retrofitViewModel.productList.observe(viewLifecycleOwner) { productsList ->
            for (item in productsList) {
                productData.add(ProductData(item.thumbnail, item.title, item.price))
            }
            adapter.notifyDataSetChanged()
        }
        retrofitViewModel.isRemoteSourseError.observe(viewLifecycleOwner) { isError ->
            if (isError) {
                Toast.makeText(requireContext(), "Data Source Error", Toast.LENGTH_LONG).show()
            }
        }
    }
}

