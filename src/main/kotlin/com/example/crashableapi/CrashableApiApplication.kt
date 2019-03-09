package com.example.crashableapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.web.bind.annotation.*
import java.time.Duration
import java.time.LocalDateTime
import kotlin.concurrent.thread

@SpringBootApplication
class CrashableApiApplication

fun main(args: Array<String>) {
    runApplication<CrashableApiApplication>(*args)
}

@RestController
class TestController {
    @GetMapping("/hello")
    fun hello(): String {
        return "Hello, the api is up and happily working!"
    }

    @GetMapping("/doSomething/{seconds}")
    fun hello(@PathVariable seconds : Long): String {
        val millisToWait = seconds * 1000
        val now = LocalDateTime.now()

        while (true) {
            if (Duration.between(now, LocalDateTime.now()).toMillis() > millisToWait){
                break
            }
            println("Doing something for $seconds seconds!")
            Thread.sleep(500)
        }
        return "Wow, that took awhile... $seconds seconds to be precise!"
    }
}

@RestController
class CrashController : ApplicationContextAware {
    private lateinit var context: ConfigurableApplicationContext

    @GetMapping("/crash")
    fun crash(): String {
        println("Requested to crash the API...")
        thread {
            context.close()
        }
        return "OK"
    }

    override fun setApplicationContext(context: ApplicationContext) {
        this.context = context as ConfigurableApplicationContext
    }
}
