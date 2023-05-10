/*
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sample.yogiraj.instagram.demo.ui.common.dialogs.progress

import androidx.lifecycle.MutableLiveData
import com.sample.yogiraj.instagram.demo.ui.base.BaseDialogViewModel
import com.sample.yogiraj.instagram.demo.utils.common.Resource
import com.sample.yogiraj.instagram.demo.utils.network.NetworkHelper
import com.sample.yogiraj.instagram.demo.utils.rx.SchedulerProvider
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * [BaseDialogViewModel] subclass for [ProgressTextDialogFragment].
 *
 * @
 */
class ProgressTextDialogSharedViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseDialogViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    // LiveData for the Progress status with message
    val progressStatus: MutableLiveData<Resource<Int>> = MutableLiveData()

    /**
     * Callback method to be implemented, which will be called when this ViewModel's Activity/Fragment is created.
     */
    override fun onCreate() {
        //No-op
    }

    /**
     * Called by the Activities/Fragments that show the [ProgressTextDialogFragment] to change
     * the Progress [status] message displayed.
     */
    fun onProgressStatusChange(status: Resource<Int>) {
        progressStatus.postValue(status)
    }

}