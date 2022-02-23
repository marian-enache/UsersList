package com.example.userslist.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userslist.databinding.FragmentUsersBinding
import com.example.userslist.global.ComponentsProvider
import com.example.userslist.utils.UserComparator
import com.example.userslist.viewmodels.UsersViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UsersFragment : Fragment() {

    private var binding: FragmentUsersBinding? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: UsersViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ComponentsProvider.viewModelComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(UsersViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.rvUsers?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding?.rvUsers?.adapter = UsersAdapter(UserComparator)

        lifecycleScope.launch() {
            viewModel.users
                .collectLatest { pagedData ->
                    getRVAdapter()?.submitData(pagedData)
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun getRVAdapter() = binding?.rvUsers?.adapter as? UsersAdapter
}