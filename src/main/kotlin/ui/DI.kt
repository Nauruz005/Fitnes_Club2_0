package ui

import data.repository.FitnesClubRepositoryImpl
import data.sourse.FitnesClubDataSourse
import data.sourse.FitnesClubDataSourseImpl
import domain.FitnesClubRepository
import domain.FitnesClubUseCase
import domain.FitnesClubUseCaseImpl

object DI {

    //для сдоя Data
    fun createDataSourse(): FitnesClubDataSourse = FitnesClubDataSourseImpl()

    fun createRepository(): FitnesClubRepository = FitnesClubRepositoryImpl(createDataSourse())

    //для сдоя Domain
    fun createFitnesClubUseCase(): FitnesClubUseCase = FitnesClubUseCaseImpl(createRepository())

    //для сдоя Ui
    fun createFitnesClubAdapter() = FitnesClubAdapter(fitnesClubUseCase = createFitnesClubUseCase())
}