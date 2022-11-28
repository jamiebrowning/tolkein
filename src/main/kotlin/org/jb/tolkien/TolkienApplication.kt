package org.jb.tolkien

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TolkienApplication

fun main(args: Array<String>) {
	runApplication<TolkienApplication>(*args)
}
