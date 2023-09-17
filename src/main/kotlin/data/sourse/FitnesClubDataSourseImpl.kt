package data.sourse

import model.Client
import model.Ticket
import model.Trainer
import java.nio.file.Files
import java.nio.file.Paths

class FitnesClubDataSourseImpl: FitnesClubDataSourse {
    private val fileClients = "Clients.csv"
    fun readCsvFileClients(): List<String> {
        val bufferedReader = Files.newBufferedReader(Paths.get(fileClients))
        var result = mutableListOf<String>()
        bufferedReader.useLines { lines ->
            for (line in lines)
                result.add(line)
        }
        return result
    }

    override fun getClients(): List<Client> = readCsvFileClients().map { client ->
        val (name, id, status) = client.split(",")
        return@map Client(name, id.toInt(), status)
    }

    private val fileTrainers = "Trainers.csv"
    fun readCsvFileTrainers(): List<String> {
        val bufferedReader = Files.newBufferedReader(Paths.get(fileTrainers))
        var result = mutableListOf<String>()
        bufferedReader.useLines { lines ->
            for (line in lines)
                result.add(line)
        }
        return result
    }
    override fun getTrainer(): List<Trainer> = readCsvFileTrainers().map{ trainer ->
        val (name, id) = trainer.split(",")
        return@map Trainer(name, id.toInt())
    }

    private val fileTickets = "Tickets.csv"
    fun readCsvFileTickets(): List<String> {
        val bufferedReader = Files.newBufferedReader(Paths.get(fileTickets))
        var result = mutableListOf<String>()
        bufferedReader.useLines { lines ->
            for (line in lines)
                result.add(line)
        }
        return result
    }

    override fun getTickets(): List<Ticket> = readCsvFileTickets().map{ ticket ->
        val (id, clientId, trainerId, price) = ticket.split(",")
        return@map Ticket(id.toInt(), clientId.toInt(), trainerId.toInt(), price.toInt())
    }
}