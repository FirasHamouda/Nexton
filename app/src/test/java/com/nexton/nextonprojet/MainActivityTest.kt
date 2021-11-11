package com.nexton.nextonprojet


import com.nexton.nextonprojet.data.model.ProgrammeTvItems
import com.nexton.nextonprojet.databinding.ActivityMainBinding
import com.nexton.nextonprojet.ui.main.adapter.TVShowAdapter
import com.nexton.nextonprojet.ui.main.view.MainActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MainActivityTest {

    /**
     * verify that MainActivity void's methods are called on a right way
     */

    private lateinit var mBinding : ActivityMainBinding

    @InjectMocks
    private val mainActivity: MainActivity? = null

    /**
     * verify that initAdapter method is called in init() on a right way
     */
    @get:Test
    val isInitAdapterIsCalled: Unit
        get() {
            mainActivity?.init()
            verify(mainActivity)?.initAdapter()
        }

    /**
     * verify that setupViewModel method is called in init() on a right way
     */
    @get:Test
    val isSetupViewModelIsCalled: Unit
        get() {
            mainActivity?.init()
            verify(mainActivity)?.setupViewModel()
        }

    /**
     * verify that setupObserver method is called in init() on a right way
     */
    @get:Test
    val isSetupObserverIsCalled: Unit
        get() {
            mainActivity?.init()
            verify(mainActivity)?.setupObserver()
        }

    /**
     * verify that initEvent method is called in init() on a right way
     */
    @get:Test
    val isInitEventIsCalled: Unit
        get() {
            mainActivity?.init()
            verify(mainActivity)?.initEvent()
        }

    /**
     * verify that getSharedPrefs method is called in initEvent() on a right way
     */
    @get:Test
    val isGetSharedPrefsIsCalled: Unit
        get() {
            mainActivity?.initEvent()
            verify(mainActivity)?.getSharedPrefs()
        }


    /**
     * verify that hideGrid method is called in initEvent() on a right way
     */
    @get:Test
    val isHdeGridIsCalledWithTrue: Unit
        get() {
            mainActivity?.initEvent()

            if(mBinding.header.searchContent.length()>2)
            verify(mainActivity)?.hideGrid(true)
            else
            verify(mainActivity)?.hideGrid(false)
        }

}

