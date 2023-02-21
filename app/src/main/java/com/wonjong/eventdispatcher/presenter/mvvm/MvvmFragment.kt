package com.wonjong.eventdispatcher.presenter.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.wonjong.eventdispatcher.databinding.FragmentMvvmBinding
import com.wonjong.eventdispatcher.event.EventTracker
import com.wonjong.eventdispatcher.event.code.EventTrackingCode
import com.wonjong.eventdispatcher.event.type.EventTrackingType
import com.wonjong.eventdispatcher.presenter.mvvm.adapter.MvvmAdapter
import com.wonjong.eventdispatcher.presenter.utils.LCE
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.json.JSONObject
import javax.inject.Inject

/**
 * Created by CaptainWonJong@gmail.com on 2023-01-03
 */
@AndroidEntryPoint
class MvvmFragment : Fragment() {
    private var _binding: FragmentMvvmBinding? = null
    private val binding: FragmentMvvmBinding get() = _binding!!

    private val viewModel: MvvmViewModel by viewModels<MvvmViewModel>()

    @Inject
    lateinit var eventTracker: EventTracker

    private val mvvmAdapter: MvvmAdapter by lazy {
        MvvmAdapter(onItemClick = viewModel::onItemClick)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMvvmBinding.inflate(inflater, container, false)
        setUpViews()
        collectFlows()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.list.adapter = null
        _binding = null
    }

    private fun setUpViews() {
        binding.list.adapter = mvvmAdapter
    }

    private fun collectFlows() {
        viewModel.posts.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).onEach { lce ->
            binding.loading.isVisible = lce is LCE.Loading
            binding.error.isVisible = lce is LCE.Error
            binding.list.isVisible = lce is LCE.Content
            mvvmAdapter.submitList(lce.data ?: emptyList())
        }.launchIn(lifecycleScope)

        viewModel.events.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).onEach { events ->
            handleEvents(events)
        }.launchIn(lifecycleScope)
    }

    private fun handleEvents(event: MvvmViewModel.MvvmEvents) = when (event) {
        is MvvmViewModel.MvvmEvents.ClickItem -> {
            Toast.makeText(context, event.post.title, Toast.LENGTH_SHORT).show()
            val params = JSONObject().apply {
                put(EventTrackingCode.ID, event.post.id)
                put(EventTrackingCode.USER_ID, event.post.userId)
                put(EventTrackingCode.TITLE, event.post.title)
            }
            eventTracker.send(EventTrackingType.CLICK_ITEM, params)
        }
    }
}