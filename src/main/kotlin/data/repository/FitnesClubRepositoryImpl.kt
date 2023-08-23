package data.repository

import domain.FitnesClubRepository
import data.sourse.FitnesClubDataSourse
import model.Client
import model.Ticket
import model.Trainer

class FitnesClubRepositoryImpl(private val dataSourse: FitnesClubDataSourse): FitnesClubRepository {
    override fun getClients(): List<Client> = dataSourse.getClients()
    override fun getTrainer(): List<Trainer> = dataSourse.getTrainer()
    override fun getTickets(): List<Ticket> = dataSourse.getTickets()

}