package com.nexton.nextonprojet.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nexton.nextonprojet.data.model.DetailLink
import com.nexton.nextonprojet.data.model.ProgrammeTV
import com.nexton.nextonprojet.data.repository.MainRepository
import com.nexton.nextonprojet.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val programmeTvLiveData = MutableLiveData<Resource<ProgrammeTV>>()
    val contentsLiveData = MutableLiveData<Resource<DetailLink>>()

    private val compositeDisposable = CompositeDisposable()

            /**
             * fetch programme TV
             */
             fun fetchProgrammeTv(key : String) {
                 programmeTvLiveData.postValue(Resource.loading(null))
                compositeDisposable.add(
                    mainRepository.getProgrammeTV(key)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ programmetvList ->
                            programmeTvLiveData.postValue(Resource.success(programmetvList))
                        }, {
                           // Nothing to do
                        })
                )
            }

            /**
             * fetch programme's detail
             */
               fun fetchDetail(detailLink : String) {
                   contentsLiveData.postValue(Resource.loading(null))
                    compositeDisposable.add(
                            mainRepository.getPitch(detailLink)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe({ pitchtvList ->
                                        contentsLiveData.postValue(Resource.success(pitchtvList))
                                    }, {
                                        // Nothing to do
                                    })
                    )
                }



            override fun onCleared() {
                super.onCleared()
                compositeDisposable.dispose()
            }


}