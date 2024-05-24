package com.example.dising_pattern_android.facade

import com.example.dising_pattern_android.facade.car.actions.BuckleUpinCar
import com.example.dising_pattern_android.facade.car.actions.CarEngaine
import com.example.dising_pattern_android.facade.car.actions.GetingCar
import com.example.dising_pattern_android.facade.car.actions.OpenDoorCar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class StartCarFacadeImpl(
    private val openDoor: OpenDoorCar,
    private val getingCar: GetingCar,
    private val buckleUpinCar: BuckleUpinCar,
    private val carEngaine: CarEngaine,
) : StartCarFacade {
    override fun startCar() {
        CoroutineScope(Dispatchers.IO + SupervisorJob()).launch {
            openDoor.OpenDoorCars()
            getingCar.GetingCars()
            buckleUpinCar.BuckleUpinCars()
            carEngaine.CarEngaines()
        }
    }
}