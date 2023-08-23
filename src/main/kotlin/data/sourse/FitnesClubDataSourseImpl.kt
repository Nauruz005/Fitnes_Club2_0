package data.sourse

import model.Client
import model.Ticket
import model.Trainer
import java.nio.file.Files
import java.nio.file.Paths

class FitnesClubDataSourseImpl: FitnesClubDataSourse {
    private val fileNameOne = "Clients.csv"
    fun readCsvFilefileNameOne(): List<String> {
        val bufferedReader = Files.newBufferedReader(Paths.get(fileNameOne))
        var result = mutableListOf<String>()
        bufferedReader.useLines { lines ->
            for (line in lines)
                result.add(line)
        }
        return result
    }

    override fun getClients(): List<Client> = readCsvFilefileNameOne().map { client ->
        val (name, id, status) = client.split(",")
        return@map Client(name, id.toInt(), status)
    }

    private val fileNameTwo = "Trainers.csv"
    fun readCsvFilefileNameTwo(): List<String> {
        val bufferedReader = Files.newBufferedReader(Paths.get(fileNameTwo))
        var result = mutableListOf<String>()
        bufferedReader.useLines { lines ->
            for (line in lines)
                result.add(line)
        }
        return result
    }
    override fun getTrainer(): List<Trainer> = readCsvFilefileNameTwo().map{ trainer ->
        val (name, id) = trainer.split(",")
        return@map Trainer(name, id.toInt())
    }

    private val fileNameThree = "Tickets.csv"
    fun readCsvFilefileNameThree(): List<String> {
        val bufferedReader = Files.newBufferedReader(Paths.get(fileNameThree))
        var result = mutableListOf<String>()
        bufferedReader.useLines { lines ->
            for (line in lines)
                result.add(line)
        }
        return result
    }

    override fun getTickets(): List<Ticket> = readCsvFilefileNameThree().map{ ticket ->
        val (id, clientId, trainerId, price) = ticket.split(",")
        return@map Ticket(id.toInt(), clientId.toInt(), trainerId.toInt(), price.toInt())
    }
}