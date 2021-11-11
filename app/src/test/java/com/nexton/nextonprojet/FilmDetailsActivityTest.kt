package com.nexton.nextonprojet


import com.nexton.nextonprojet.data.model.Contents
import com.nexton.nextonprojet.data.model.ProgrammeTvItems
import com.nexton.nextonprojet.databinding.ActivityMainBinding
import com.nexton.nextonprojet.ui.main.adapter.TVShowAdapter
import com.nexton.nextonprojet.ui.main.view.FilmDetailsActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class FilmDetailsActivityTest {

    /**
     * verify that FilmDetailsActivity void's methods are called on a right way
     */


    @InjectMocks
    private val filmDetailsActivityTest: FilmDetailsActivity? = null

    /**
     * verify that initBinding method is called in init() on a right way
     */
    @get:Test
    val isInitBindingIsCalled: Unit
        get() {
            filmDetailsActivityTest?.init()
            verify(filmDetailsActivityTest)?.initBinding()
        }

    /**
     * verify that setupViewModel method is called in init() on a right way
     */
    @get:Test
    val isSetupViewModelIsCalled: Unit
        get() {
            filmDetailsActivityTest?.init()
            verify(filmDetailsActivityTest)?.setupViewModel()
        }

    /**
     * verify that setupDetailsObserver method is called in init() on a right way
     */
    @get:Test
    val isSetupDetailsObserverIsCalled: Unit
        get() {
            filmDetailsActivityTest?.init()
            verify(filmDetailsActivityTest)?.setupDetailsObserver()
        }

    /**
     * verify that initLiveData method is called in init() on a right way
     */
    @get:Test
    val isInitLiveDataIsCalled: Unit
        get() {
            filmDetailsActivityTest?.init()
            verify(filmDetailsActivityTest)?.initLiveData()
        }

    /**
     * verify that initEvent method is called in init() on a right way
     */
    @get:Test
    val isInitEventIsCalled: Unit
        get() {
            filmDetailsActivityTest?.init()
            verify(filmDetailsActivityTest)?.initEvent()
        }

    /**
     * verify that manageVisibility method is called in initEvent() on a right way
     */
    @get:Test
    val isManageVisibilityCalled: Unit
        get() {
            filmDetailsActivityTest?.initEvent()
            verify(filmDetailsActivityTest)?.manageVisibility()
        }


}

