package com.nexton.nextonprojet.ui.main.viewmodel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nexton.nextonprojet.data.api.ApiHelper
import com.nexton.nextonprojet.data.api.ApiService
import com.nexton.nextonprojet.data.repository.MainRepository
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException


@RunWith(AndroidJUnit4::class)
class MainViewModelTest () : TestCase() {

    private lateinit var viewModel: MainViewModel
    private lateinit var mainRepository: MainRepository
    @Mock
    private lateinit var apiService: ApiService


    @get:Rule
    val instantTasExecutorRule = InstantTaskExecutorRule()

    @Before
    public override fun setUp() {
        super.setUp()

        MockitoAnnotations.initMocks(this)
        mainRepository = MainRepository(ApiHelper(apiService))
        viewModel = MainViewModel(mainRepository)

    }

    @Test
    fun testMainViewModel (){

        viewModel.fetchProgrammeTv("Game")
        val result = viewModel.programmeTvLiveData.getOrAwaitValue().data

        assert(result != null)
        }



    /**
     * Test LiveData result
     */
    fun <T> LiveData<T>.getOrAwaitValue():T {

        var data: T? = null

        val latch = CountDownLatch(1)

        val observer = object : Observer<T>{
            override fun onChanged(t: T) {

                data = t
                this@getOrAwaitValue.removeObserver(this)
                latch.countDown()
            }
        }

        this.removeObserver(observer)

        try {
            if(!latch.await(3,TimeUnit.SECONDS)){
                throw  TimeoutException("Live Data didn't gets any values")
            }
        }finally {
            this.removeObserver(observer)
        }

        return data as T
    }
}